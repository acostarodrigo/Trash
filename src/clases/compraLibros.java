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
@Table (name = "CompraLibros")
public class compraLibros {
    @Id    
    private Date fecha;
    
    @ManyToOne
    private Usuario usuario;
    
    @ManyToOne
    private Libro libro;
}
