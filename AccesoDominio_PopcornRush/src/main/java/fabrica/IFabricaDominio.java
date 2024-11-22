/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabrica;

import interfacesDAO.*;

/**
 *
 * @author galan
 */
public interface IFabricaDominio {

    public IAdministradorDAO administrador();

    public IComentarioDAO comentario();

    public IEstadoDAO estado();

    public IMunicipioDAO municipio();

    public IPostComunDAO postComun();

    public IPostAncladoDAO postAnclado();

    public IUsuarioNormalDAO usuarioNormal();
}
