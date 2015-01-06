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
public class accionesUsuario {
    private Usuario usuario;

    public accionesUsuario() {
    }  
    
    private boolean usuarioExiste(Usuario usuario){
        Session session = HibernateUtil.getSessionFactory().openSession();        
        String strQuery = "From Usuario u WHERE u.nombre = :nombreUsuario";
        Query query = (Query) session.createQuery(strQuery);
        query.setParameter("nombreUsuario", usuario.getNombre());
                
        List usuarios = query.list();
        session.close();
        
        // si no devolvio nada, entonces el usuario no existe
        if (usuarios.size() == 0)
            return false;
        else
            return true;
    }
    
    public void altaUsuario (Usuario usuario)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();        
        session.persist(usuario);                
        session.getTransaction().commit();
        session.close();
    }
    
    public void bajaUsuario (Usuario usuario)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(usuario);
        session.getTransaction().commit();
        session.close();
    }
    
    public void modificarUSuario (long IdUsuario, Usuario usuarioModificado){
       Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(null, usuario);
        session.getTransaction().commit();
        session.close();
    }
    
    public void modificarUSuario (Usuario usuarioModificado){
       Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(usuarioModificado);
        session.getTransaction().commit();
        session.close();
    }
    
    public boolean validarIngreso (String nombreUsuario, String Password){
       Session session = HibernateUtil.getSessionFactory().openSession();
       String hql = "FROM Usuario u WHERE u.nombre = :nombreUsuario AND u.password = :Password";
       Query query = session.createQuery(hql);
       query.setParameter("nombreUsuario", nombreUsuario);
       query.setParameter("Password", Password);
       List usuarios = query.list();
       session.close();              

       //si encontró un usuario con esa clave, entonces devuelvo true
       if (usuarios.size() == 0)
       {
           return false;
       }
       
       else
       {
           return true;
       }
    }
    
    //obtiene el usuario pasando el nombre
    public Usuario obtenerUsuario(String nombreUsuario){
        Session session = HibernateUtil.getSessionFactory().openSession();        
        String strQuery = "From Usuario u WHERE u.nombre = :nombreUsuario";
        Query query = (Query) session.createQuery(strQuery);
        query.setParameter("nombreUsuario", nombreUsuario);
                
        List usuarios = query.list();
        Usuario usuario = (Usuario) usuarios.get(0);
        session.close();        
        return usuario;
    }
    
    
    //obtiene el usuario pasando el id de usuario
    public Usuario obtenerUsuario(long IdUsuario){
        Session session = HibernateUtil.getSessionFactory().openSession();        
        Usuario usuario = null;
        usuario = (Usuario) session.get(Usuario.class, IdUsuario);        
        session.close();        
        return usuario;
    }
}
