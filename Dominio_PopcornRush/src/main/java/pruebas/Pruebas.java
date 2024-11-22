/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import daos.AdministradorDAO;
import daos.ComentarioDAO;
import daos.PostComunDAO;
import daos.UsuarioNormalDAO;
import entidades.Administrador;
import entidades.Comentario;
import static entidades.Comentario_.postComun;
import entidades.Estado;
import entidades.Municipio;
import entidades.PostComun;
import entidades.UsuarioNormal;
import excepciones.ExcepcionAT;
import interfacesDAO.IAdministradorDAO;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author galan
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdministradorDAO administradorDAO= new AdministradorDAO();
        Estado estado= new Estado("Sonora");
        Municipio municipio= new Municipio("Cajeme", estado);
        Calendar calendario = Calendar.getInstance();
        calendario.set(2004, Calendar.AUGUST, 13);
        Administrador admin= new Administrador("xd", "xd", "xd", "6441401671", "xd", "Ciudad Obregon", calendario, "Hombre", municipio);
        try {
            administradorDAO.registrarAdministrador(admin);
        } catch (ExcepcionAT ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsuarioNormalDAO usuarioDAO= new UsuarioNormalDAO();
        UsuarioNormal usuario= new UsuarioNormal("Pablo", "xd", "xd", "6441401671", "xd", "Ciudad Obregon", calendario, "Hombre", municipio);
        try {
            usuarioDAO.registrarUsuarioNormal(usuario);
        } catch (ExcepcionAT ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PostComunDAO postComunDAO= new PostComunDAO();
        PostComun postComun= new PostComun(usuario, calendario, "Hola", "excelente", calendario);
        try {
            postComunDAO.registrarPostComun(postComun);
        } catch (ExcepcionAT ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
        ComentarioDAO comentarioDAO= new ComentarioDAO();
        Comentario comentario= new Comentario(calendario, "buen meme bro", postComun, usuario);
        try {
            comentarioDAO.registrarComentario(comentario);
        } catch (ExcepcionAT ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }

//        PostComunDAO postComunDAO = new PostComunDAO();
//        PostComun post=null;
//        try {
//            post = postComunDAO.obtenerPostComun("Hola");
//            System.out.println(post.getContenido());
//        } catch (ExcepcionAT ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        ComentarioDAO comentarioDAO = new ComentarioDAO();
//        try {
//            Comentario comentario= comentarioDAO.obtenerComentario(post);
//            System.out.println(comentario.getContenido());
//        } catch (ExcepcionAT ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    
        
    }
}
