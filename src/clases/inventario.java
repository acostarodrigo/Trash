/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Date;
import javax.persistence.*;

/**
 *
 * @author rodrigoa
 */
@Entity
@Table (name = "Inventario")
public class inventario {
    @Id
    private Date fecha;
    
    @ManyToOne
    private Libro libro;
    private int inventario;

    public inventario() {
    }   
    

    private void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    public int obtenerInventario(long idLibro){
        return 0;
    }
    
    public void altaLibro(long idLibro){
        
    }
    
    public void bajaLibro (long idLibro){
        
    }
    
    public int inventarioTotal(){
        return 0;
    }
    
}
