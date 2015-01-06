/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author rodrigoa
 */
public class accionesLibros {    

    public accionesLibros() {        
    }   
    
    public void altaLibro (Libro libro){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        sesion.persist(libro);
        sesion.getTransaction().commit();
        sesion.close();
    }
    
    public void bajaLibro (Libro libro){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        sesion.delete(libro);
        sesion.getTransaction().commit();
        sesion.close();
    }
          
    public boolean existeLibro (long LibroId){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Libro l where l.id = :LibroId";
        Query query = sesion.createQuery(hql);
        query.setParameter("LibroId", LibroId);
        List resultado = query.list();
        sesion.close();
        if (resultado.size() == 1)
            return true;
        else
            return false;
    }
    
    public List<Libro> obtenerLibros (){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Libro l";
        Query query = sesion.createQuery(hql);        
        List<Libro> resultado = query.list();
        return resultado;
    }
    
    
}
