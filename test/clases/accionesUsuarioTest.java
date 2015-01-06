/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rodrigoa
 */
public class accionesUsuarioTest {
    
    public accionesUsuarioTest() {
    }

    /**
     * Test of altaUsuario method, of class accionesUsuario.
     */
    @Test
    public void testAltaUsuario() {
        System.out.println("altaUsuario");
        Usuario usuario = new Usuario();
        usuario.setNombre("Prueba");
        usuario.setPassword("prueba");
        accionesUsuario instance = new accionesUsuario();
        
        //doy de alta un usuario
        System.out.println("Usuario creado.");
        instance.altaUsuario(usuario);        
        
        //borro el usuario
        System.out.println("Usuario borrado.");
        instance.bajaUsuario(usuario);
    }

    /**
     * Test of bajaUsuario method, of class accionesUsuario.
     */
    @Test
    public void testBajaUsuario() {
        System.out.println("bajaUsuario");
        Usuario usuario = new Usuario();
        usuario.setNombre("Prueba");
        usuario.setPassword("prueba");
        accionesUsuario instance = new accionesUsuario();
        
        //doy de alta un usuario
        System.out.println("Usuario creado.");
        instance.altaUsuario(usuario);        
        
        //borro el usuario
        System.out.println("Usuario borrado.");
        instance.bajaUsuario(usuario);
    }

    /**
     * Test of modificarUSuario method, of class accionesUsuario.
     */
    @Test
    public void testModificarUSuario() {
        System.out.println("modificarUSuario");
        Usuario usuario = new Usuario();
        usuario.setNombre("Prueba");
        usuario.setPassword("prueba");
        accionesUsuario instance = new accionesUsuario();
        
        //doy de alta un usuario
        System.out.println("Usuario creado.");
        instance.altaUsuario(usuario);        
        
        //modifico el usuario
        System.out.println("Usuario modificado.");
        usuario.setPassword("#$DF");
        instance.modificarUSuario(usuario);        
        
        //borro el usuario
        System.out.println("Usuario borrado.");
        instance.bajaUsuario(usuario);
    }

    /**
     * Test of validarIngreso method, of class accionesUsuario.
     */
    @Test
    public void testValidarIngreso() {
        System.out.println("validarIngreso");
        Usuario usuario = new Usuario("PruebaValidacion", "SDSD");
        
        accionesUsuario instance = new accionesUsuario();
        boolean expResult = false;
        boolean result = instance.validarIngreso(usuario.getNombre(), usuario.getPassword());
        
        ///todavía no lo inserté en la base de datos por lo tanto no debe existir
        assertEquals(expResult, result);
        
        
        // inserto el usuario, por lo tanto debería validar ok.
        instance.altaUsuario(usuario);
        expResult = true;
        result = instance.validarIngreso(usuario.getNombre(), usuario.getPassword());
        assertEquals(expResult, result);
        
        //borro el usuario para no generar basura
        instance.bajaUsuario(usuario);
        
        
    }
    
    @Test
    public void testObtenerUsuarioPorID() {
        System.out.println("validarIngreso");
        
        Usuario usuario = new Usuario();
        usuario.setNombre("Prueba");
        usuario.setPassword("prueba");
        accionesUsuario instance = new accionesUsuario();
        
        //doy de alta un usuario
        System.out.println("Usuario creado.");
        instance.altaUsuario(usuario);        
        
        
        String expResult = usuario.getNombre();
        String  result = instance.obtenerUsuario(usuario.getId()).getNombre();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testObtenerUsuarioPorNombre() {
        System.out.println("validarIngreso");
        
        Usuario usuario = new Usuario();
        usuario.setNombre("Prueba");
        usuario.setPassword("prueba");
        accionesUsuario instance = new accionesUsuario();
        
        //doy de alta un usuario
        System.out.println("Usuario creado.");
        instance.altaUsuario(usuario);        
        
        
        String expResult = usuario.getNombre();
        String  result = instance.obtenerUsuario(usuario.getNombre()).getNombre();
        assertEquals(expResult, result);
    }
    
}
