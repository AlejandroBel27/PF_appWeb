/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachada;

import entidades.*;
import excepciones.ExcepcionAT;

/**
 *
 * @author galan
 */
public interface IFachadaDominio {

    // Métodos para Administrador
    public void registrarAdministrador(Administrador administrador) throws ExcepcionAT;

    public void actualizarAdministrador(Administrador administrador) throws ExcepcionAT;

    public void eliminarAdministrador(Administrador administrador) throws ExcepcionAT;

    public Administrador obtenerAdministrador(String correo, String contraseña) throws ExcepcionAT;

    // Métodos para Comentario
    public void registrarComentario(Comentario comentario) throws ExcepcionAT;

    public void actualizarComentario(Comentario comentario) throws ExcepcionAT;

    public void eliminarComentario(Comentario comentario) throws ExcepcionAT;

    public Comentario obtenerComentarioPorPost(PostComun postComun) throws ExcepcionAT;

    public Comentario obtenerComentarioPorPadre(Comentario comentarioPadre) throws ExcepcionAT;

    // Métodos para Estado
    public void registrarEstado(Estado estado) throws ExcepcionAT;

    public void actualizarEstado(Estado estado) throws ExcepcionAT;

    public void eliminarEstado(Estado estado) throws ExcepcionAT;

    // Métodos para Municipio
    public void registrarMunicipio(Municipio municipio) throws ExcepcionAT;

    public void actualizarMunicipio(Municipio municipio) throws ExcepcionAT;

    public void eliminarMunicipio(Municipio municipio) throws ExcepcionAT;

    // Métodos para PostAnclado
    public void registrarPostAnclado(PostAnclado postAnclado) throws ExcepcionAT;

    public void actualizarPostAnclado(PostAnclado postAnclado) throws ExcepcionAT;

    public void eliminarPostAnclado(PostAnclado postAnclado) throws ExcepcionAT;

    public PostAnclado obtenerPostAnclado(String titulo) throws ExcepcionAT;

    // Métodos para UsuarioNormal
    public void registrarUsuarioNormal(UsuarioNormal usuarioNormal) throws ExcepcionAT;

    public void actualizarUsuarioNormal(UsuarioNormal usuarioNormal) throws ExcepcionAT;

    public void eliminarUsuarioNormal(UsuarioNormal usuarioNormal) throws ExcepcionAT;

    public UsuarioNormal obtenerUsuarioNormal(String correo, String contraseña) throws ExcepcionAT;

// Métodos para PostComun
    public void registrarPostComun(PostComun postComun) throws ExcepcionAT;

    public void actualizarPostComun(PostComun postComun) throws ExcepcionAT;

    public void eliminarPostComun(PostComun postComun) throws ExcepcionAT;

    public PostComun obtenerPostComun(String titulo) throws ExcepcionAT;
}
