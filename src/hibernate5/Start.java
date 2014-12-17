/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate5;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author rodrigoa
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Libro libro1 = new Libro("El lobo estepario");
        Libro libro2 = new Libro("10000 leguas de viaje submarino");
        
        Persona yo = new Persona("Rodrigo", libro1);
        yo.addLibro(libro2);
        yo.addLibro("El Eternauta");
        
        Libro libro3 = new Libro ("Storm Tactics");
        Libro libro4 = new Libro ("Yo Robot");
        List<Libro> nuevosLibros = new ArrayList<Libro>();
        nuevosLibros.add(libro3);
        nuevosLibros.add(libro4);
        
        yo.addLibro(nuevosLibros);
        
        //lo guardo en la base
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        sesion.persist(yo);
        sesion.getTransaction().commit();
        sesion.close();
        
        
        //ahora agrego otros libros y otra persona
        Persona lu = new Persona("Lujan", "Eugenesia");        
        lu.addLibro("Cachorros");
        sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        sesion.persist(lu);
        sesion.getTransaction().commit();
        sesion.close();
        
        
        //me borro
         sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        sesion.delete(yo);
        sesion.getTransaction().commit();
        sesion.close();
        
        System.exit(0);
    }
    
}
