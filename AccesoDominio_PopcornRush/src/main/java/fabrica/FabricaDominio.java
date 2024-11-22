/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabrica;

import daos.*;
import interfacesDAO.*;

/**
 *
 * @author galan
 */
public class FabricaDominio implements IFabricaDominio {

    @Override
    public IAdministradorDAO administrador() {
        IAdministradorDAO administrador = new AdministradorDAO();
        return administrador;
    }

    @Override
    public IComentarioDAO comentario() {
        IComentarioDAO comentario = new ComentarioDAO();
        return comentario;
    }

    @Override
    public IEstadoDAO estado() {
        IEstadoDAO estado = new EstadoDAO();
        return estado;
    }

    @Override
    public IMunicipioDAO municipio() {
        IMunicipioDAO municipio = new MunicipioDAO();
        return municipio;
    }

    @Override
    public IPostComunDAO postComun() {
        IPostComunDAO postComun = new PostComunDAO();
        return postComun;
    }

    @Override
    public IPostAncladoDAO postAnclado() {
        IPostAncladoDAO postAnclado = new PostAncladoDAO();
        return postAnclado;
    }

    @Override
    public IUsuarioNormalDAO usuarioNormal() {
        IUsuarioNormalDAO usuarioNormal = new UsuarioNormalDAO();
        return usuarioNormal;
    }
}
