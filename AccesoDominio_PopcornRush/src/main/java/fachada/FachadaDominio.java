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
import daos.PostComunDAO;
import daos.UsuarioNormalDAO;
import entidades.*;
import excepciones.ExcepcionAT;

/**
 *
 * @author galan
 */
public class FachadaDominio implements IFachadaDominio{
    private AdministradorDAO administradorDAO;
    private ComentarioDAO comentarioDAO;
    private EstadoDAO estadoDAO;
    private MunicipioDAO municipioDAO;
    private PostAncladoDAO postAncladoDAO;
    private UsuarioNormalDAO usuarioNormalDAO;
    private PostComunDAO postComunDAO;

    public FachadaDominio() {
        this.administradorDAO = new AdministradorDAO();
        this.comentarioDAO = new ComentarioDAO();
        this.estadoDAO = new EstadoDAO();
        this.municipioDAO = new MunicipioDAO();
        this.postAncladoDAO = new PostAncladoDAO();
        this.usuarioNormalDAO = new UsuarioNormalDAO();
        this.postComunDAO = new PostComunDAO();
    }

    // Métodos de la fachada para Administrador
    @Override
    public void registrarAdministrador(Administrador administrador) throws ExcepcionAT {
        administradorDAO.registrarAdministrador(administrador);
    }

    @Override
    public void actualizarAdministrador(Administrador administrador) throws ExcepcionAT {
        administradorDAO.actualizarAdministrador(administrador);
    }

    @Override
    public void eliminarAdministrador(Administrador administrador) throws ExcepcionAT {
        administradorDAO.eliminarAdministrador(administrador);
    }

    @Override
    public Administrador obtenerAdministrador(String correo, String contraseña) throws ExcepcionAT {
        return administradorDAO.obtenerAdministrador(correo, contraseña);
    }

    // Métodos de la fachada para Comentario
    @Override
    public void registrarComentario(Comentario comentario) throws ExcepcionAT {
        comentarioDAO.registrarComentario(comentario);
    }

    @Override
    public void actualizarComentario(Comentario comentario) throws ExcepcionAT {
        comentarioDAO.actualizarComentario(comentario);
    }
    
    @Override
    public void eliminarComentario(Comentario comentario) throws ExcepcionAT {
        comentarioDAO.eliminarComentario(comentario);
    }

    @Override
    public Comentario obtenerComentarioPorPost(PostComun postComun) throws ExcepcionAT {
        return comentarioDAO.obtenerComentario(postComun);
    }
    
    @Override
    public Comentario obtenerComentarioPorPadre(Comentario comentarioPadre) throws ExcepcionAT {
        return comentarioDAO.obtenerComentario(comentarioPadre);
    }

    @Override
    // Métodos de la fachada para Estado
    public void registrarEstado(Estado estado) throws ExcepcionAT {
        estadoDAO.registrarEstado(estado);
    }

    @Override
    public void actualizarEstado(Estado estado) throws ExcepcionAT {
        estadoDAO.actualizarEstado(estado);
    }

    @Override
    public void eliminarEstado(Estado estado) throws ExcepcionAT {
        estadoDAO.eliminarEstado(estado);
    }

    // Métodos de la fachada para Municipio
    @Override
    public void registrarMunicipio(Municipio municipio) throws ExcepcionAT {
        municipioDAO.registrarMunicipio(municipio);
    }

    @Override
    public void actualizarMunicipio(Municipio municipio) throws ExcepcionAT {
        municipioDAO.actualizarMunicipio(municipio);
    }

    @Override
    public void eliminarMunicipio(Municipio municipio) throws ExcepcionAT {
        municipioDAO.eliminarMunicipio(municipio);
    }

    // Métodos de la fachada para PostAnclado
    @Override
    public void registrarPostAnclado(PostAnclado postAnclado) throws ExcepcionAT {
        postAncladoDAO.registrarPostAnclado(postAnclado);
    }

    @Override
    public void actualizarPostAnclado(PostAnclado postAnclado) throws ExcepcionAT {
        postAncladoDAO.actualizarPostAnclado(postAnclado);
    }

    @Override
    public void eliminarPostAnclado(PostAnclado postAnclado) throws ExcepcionAT {
        postAncladoDAO.eliminarPostAnclado(postAnclado);
    }

    @Override
    public PostAnclado obtenerPostAnclado(String titulo) throws ExcepcionAT {
        return postAncladoDAO.obtenerPostAnclado(titulo);
    }

    // Métodos de la fachada para Usario normal
    @Override
    public void registrarUsuarioNormal(UsuarioNormal usuarioNormal) throws ExcepcionAT {
        usuarioNormalDAO.registrarUsuarioNormal(usuarioNormal);
    }

    @Override
    public void actualizarUsuarioNormal(UsuarioNormal usuarioNormal) throws ExcepcionAT {
        usuarioNormalDAO.actualizarUsuarioNormal(usuarioNormal);
    }

    @Override
    public void eliminarUsuarioNormal(UsuarioNormal usuarioNormal) throws ExcepcionAT {
        usuarioNormalDAO.eliminarUsuarioNormal(usuarioNormal);
    }

    @Override
    public UsuarioNormal obtenerUsuarioNormal(String correo, String contraseña) throws ExcepcionAT {
        return usuarioNormalDAO.obtenerUsuarioNormal(correo, contraseña);
    }

    //Métodos de la fachada para el post común
    @Override
    public void registrarPostComun(PostComun postComun) throws ExcepcionAT {
        postComunDAO.registrarPostComun(postComun);
    }

    @Override
    public void actualizarPostComun(PostComun postComun) throws ExcepcionAT {
        postComunDAO.actualizarPostComun(postComun);
    }

    @Override
    public void eliminarPostComun(PostComun postComun) throws ExcepcionAT {
        postComunDAO.eliminarPostComun(postComun);
    }

    @Override
    public PostComun obtenerPostComun(String titulo) throws ExcepcionAT {
        return postComunDAO.obtenerPostComun(titulo);
    }
}
