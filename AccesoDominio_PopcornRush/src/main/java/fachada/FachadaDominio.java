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
import fabrica.FabricaDominio;
import fabrica.IFabricaDominio;
import java.util.List;

/**
 *
 * @author galan
 */
public class FachadaDominio implements IFachadaDominio {
    
    private IFabricaDominio fabrica;
    
    public FachadaDominio() {
        this.fabrica = new FabricaDominio();
    }

    // Métodos de la fachada para Administrador
    @Override
    public void registrarAdministrador(Administrador administrador) throws ExcepcionAT {
        fabrica.administrador().registrarAdministrador(administrador);
    }
    
    @Override
    public void actualizarAdministrador(Administrador administrador) throws ExcepcionAT {
        fabrica.administrador().actualizarAdministrador(administrador);
    }
    
    @Override
    public void eliminarAdministrador(Administrador administrador) throws ExcepcionAT {
        fabrica.administrador().eliminarAdministrador(administrador);
    }
    
    @Override
    public Administrador obtenerAdministrador(String correo, String contraseña) throws ExcepcionAT {
        return fabrica.administrador().obtenerAdministrador(correo, contraseña);
    }

    // Métodos de la fachada para Comentario
    @Override
    public void registrarComentario(Comentario comentario) throws ExcepcionAT {
        fabrica.comentario().registrarComentario(comentario);
    }
    
    @Override
    public void actualizarComentario(Comentario comentario) throws ExcepcionAT {
        fabrica.comentario().actualizarComentario(comentario);
    }
    
    @Override
    public void eliminarComentario(Comentario comentario) throws ExcepcionAT {
        fabrica.comentario().eliminarComentario(comentario);
    }
    
    @Override
    public Comentario obtenerComentarioPorPost(PostComun postComun) throws ExcepcionAT {
        return fabrica.comentario().obtenerComentario(postComun);
    }
    
    @Override
    public Comentario obtenerComentarioPorPadre(Comentario comentarioPadre) throws ExcepcionAT {
        return fabrica.comentario().obtenerComentario(comentarioPadre);
    }
    
    @Override
    public List<Comentario> obtenerComentariosPorPost(PostComun post) throws ExcepcionAT{
        return fabrica.comentario().obtenerComentariosPorPost(post);
    }

    // Métodos de la fachada para Estado
    @Override
    public void registrarEstado(Estado estado) throws ExcepcionAT {
        fabrica.estado().registrarEstado(estado);
    }
    
    @Override
    public void actualizarEstado(Estado estado) throws ExcepcionAT {
        fabrica.estado().actualizarEstado(estado);
    }
    
    @Override
    public void eliminarEstado(Estado estado) throws ExcepcionAT {
        fabrica.estado().eliminarEstado(estado);
    }

    // Métodos de la fachada para Municipio
    @Override
    public void registrarMunicipio(Municipio municipio) throws ExcepcionAT {
        fabrica.municipio().registrarMunicipio(municipio);
    }
    
    @Override
    public void actualizarMunicipio(Municipio municipio) throws ExcepcionAT {
        fabrica.municipio().actualizarMunicipio(municipio);
    }
    
    @Override
    public void eliminarMunicipio(Municipio municipio) throws ExcepcionAT {
        fabrica.municipio().eliminarMunicipio(municipio);
    }

    // Métodos de la fachada para PostAnclado
    @Override
    public void registrarPostAnclado(PostAnclado postAnclado) throws ExcepcionAT {
        fabrica.postAnclado().registrarPostAnclado(postAnclado);
    }
    
    @Override
    public void actualizarPostAnclado(PostAnclado postAnclado) throws ExcepcionAT {
        fabrica.postAnclado().actualizarPostAnclado(postAnclado);
    }
    
    @Override
    public void eliminarPostAnclado(PostAnclado postAnclado) throws ExcepcionAT {
        fabrica.postAnclado().eliminarPostAnclado(postAnclado);
    }
    
    @Override
    public PostAnclado obtenerPostAnclado(String titulo) throws ExcepcionAT {
        return fabrica.postAnclado().obtenerPostAnclado(titulo);
    }
    
    @Override
    public PostAnclado obtenerPostAncladoPorId(long id) throws ExcepcionAT {
        return fabrica.postAnclado().obtenerPostAncladoPorId(id);
    }
    
    @Override
    public List<PostAnclado> obtenerPostsAnclados() throws ExcepcionAT {
        return fabrica.postAnclado().obtenerPosts();
    }

    // Métodos de la fachada para UsuarioNormal
    @Override
    public void registrarUsuarioNormal(UsuarioNormal usuarioNormal) throws ExcepcionAT {
        fabrica.usuarioNormal().registrarUsuarioNormal(usuarioNormal);
    }
    
    @Override
    public void actualizarUsuarioNormal(UsuarioNormal usuarioNormal) throws ExcepcionAT {
        fabrica.usuarioNormal().actualizarUsuarioNormal(usuarioNormal);
    }
    
    @Override
    public void eliminarUsuarioNormal(UsuarioNormal usuarioNormal) throws ExcepcionAT {
        fabrica.usuarioNormal().eliminarUsuarioNormal(usuarioNormal);
    }
    
    @Override
    public UsuarioNormal obtenerUsuarioNormal(String correo, String contraseña) throws ExcepcionAT {
        return fabrica.usuarioNormal().obtenerUsuarioNormal(correo, contraseña);
    }

// Métodos de la fachada para PostComun
    @Override
    public void registrarPostComun(PostComun postComun) throws ExcepcionAT {
        fabrica.postComun().registrarPostComun(postComun);
    }
    
    @Override
    public void actualizarPostComun(PostComun postComun) throws ExcepcionAT {
        fabrica.postComun().actualizarPostComun(postComun);
    }
    
    @Override
    public void eliminarPostComun(PostComun postComun) throws ExcepcionAT {
        fabrica.postComun().eliminarPostComun(postComun);
    }
    
    @Override
    public PostComun obtenerPostComun(String titulo) throws ExcepcionAT {
        return fabrica.postComun().obtenerPostComun(titulo);
    }
    
    @Override
    public List<PostComun> obtenerPostsComunes() throws ExcepcionAT {
        return fabrica.postComun().obtenerPosts();
    }
    
    @Override
    public PostComun obtenerPostComunPorId(long id) throws ExcepcionAT {
        return fabrica.postComun().obtenerPostComunPoirId(id);
    }

    @Override
    public List<PostComun> obtenerPostsComunesPorUsuario(Usuario usuario) throws ExcepcionAT {
        return fabrica.postComun().obtenerPostsPorUsuario(usuario);
    }
    
    
    
}
