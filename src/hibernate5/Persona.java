/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author rodrigoa
 */
@Entity
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)        
    private long id;
    private String nombre;
    
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Libro> libros = new ArrayList<Libro>();
    
    public Persona(){
        
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }
    
    public Persona(String Nombre, Libro Libro)
    {
        this.nombre = Nombre;
        libros.add(Libro);
    }
    
    public Persona(String Nombre, String Libro)
    {
        this.nombre = Nombre;
        libros.add(new Libro(Libro));
    }
    
    public Persona (String Nombre, List<Libro> libros)
    {
        this.nombre = Nombre;
        libros = libros;
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
    
    public void addLibro(String Nombre)
    {
        libros.add(new Libro(Nombre));
    }
    
    public void addLibro(Libro Libro)
    {
        libros.add(Libro);
    }
    
    public void addLibro (List<Libro> Libros){
        this.libros.addAll(Libros);
    }
            
    
            
}
