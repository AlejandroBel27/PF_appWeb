/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import daos.AdministradorDAO;
import daos.ComentarioDAO;
import daos.EstadoDAO;
import daos.MunicipioDAO;
import daos.PostAncladoDAO;
import entidades.*;
import excepciones.ExcepcionAT;

/**
 *
 * @author galan
 */
public class FachadaDominio {
    private AdministradorDAO administradorDAO;
    private ComentarioDAO comentarioDAO;
    private EstadoDAO estadoDAO;
    private MunicipioDAO municipioDAO;
    private PostAncladoDAO postAncladoDAO;

    public FachadaDominio() {
        this.administradorDAO = new AdministradorDAO();
        this.comentarioDAO = new ComentarioDAO();
        this.estadoDAO = new EstadoDAO();
        this.municipioDAO = new MunicipioDAO();
        this.postAncladoDAO = new PostAncladoDAO();
    }

    // Métodos de la fachada para Administrador
    public void registrarAdministrador(Administrador administrador) throws ExcepcionAT {
        administradorDAO.registrarAdministrador(administrador);
    }

    public void actualizarAdministrador(Administrador administrador) throws ExcepcionAT {
        administradorDAO.actualizarAdministrador(administrador);
    }

    public void eliminarAdministrador(Administrador administrador) throws ExcepcionAT {
        administradorDAO.eliminarAdministrador(administrador);
    }

    public Administrador obtenerAdministrador(String correo, String contraseña) throws ExcepcionAT {
        return administradorDAO.obtenerAdministrador(correo, contraseña);
    }

    // Métodos de la fachada para Comentario
    public void registrarComentario(Comentario comentario) throws ExcepcionAT {
        comentarioDAO.registrarComentario(comentario);
    }

    public void actualizarComentario(Comentario comentario) throws ExcepcionAT {
        comentarioDAO.actualizarComentario(comentario);
    }

    public void eliminarComentario(Comentario comentario) throws ExcepcionAT {
        comentarioDAO.eliminarComentario(comentario);
    }

    public Comentario obtenerComentarioPorPost(PostComun postComun) throws ExcepcionAT {
        return comentarioDAO.obtenerComentario(postComun);
    }

    public Comentario obtenerComentarioPorPadre(Comentario comentarioPadre) throws ExcepcionAT {
        return comentarioDAO.obtenerComentario(comentarioPadre);
    }

    // Métodos de la fachada para Estado
    public void registrarEstado(Estado estado) throws ExcepcionAT {
        estadoDAO.registrarEstado(estado);
    }

    public void actualizarEstado(Estado estado) throws ExcepcionAT {
        estadoDAO.actualizarEstado(estado);
    }

    public void eliminarEstado(Estado estado) throws ExcepcionAT {
        estadoDAO.eliminarEstado(estado);
    }

    // Métodos de la fachada para Municipio
    public void registrarMunicipio(Municipio municipio) throws ExcepcionAT {
        municipioDAO.registrarMunicipio(municipio);
    }

    public void actualizarMunicipio(Municipio municipio) throws ExcepcionAT {
        municipioDAO.actualizarMunicipio(municipio);
    }

    public void eliminarMunicipio(Municipio municipio) throws ExcepcionAT {
        municipioDAO.eliminarMunicipio(municipio);
    }

    // Métodos de la fachada para PostAnclado
    public void registrarPostAnclado(PostAnclado postAnclado) throws ExcepcionAT {
        postAncladoDAO.registrarPostAnclado(postAnclado);
    }

    public void actualizarPostAnclado(PostAnclado postAnclado) throws ExcepcionAT {
        postAncladoDAO.actualizarPostAnclado(postAnclado);
    }

    public void eliminarPostAnclado(PostAnclado postAnclado) throws ExcepcionAT {
        postAncladoDAO.eliminarPostAnclado(postAnclado);
    }

    public PostAnclado obtenerPostAnclado(String titulo) throws ExcepcionAT {
        return postAncladoDAO.obtenerPostAnclado(titulo);
    }
}
