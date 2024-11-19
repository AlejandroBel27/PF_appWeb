/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacesDAO;

import entidades.UsuarioNormal;
import excepciones.ExcepcionAT;

/**
 *
 * @author galan
 */
public interface IUsuarioNormalDAO {
    
    /**
     * Metodo que registra al usuario y arroja una excepcion
     * @param usuarioNormal Usuario normal que se registrará
     * @throws ExcepcionAT
     */
    public void registrarUsuarioNormal(UsuarioNormal usuarioNormal) throws ExcepcionAT;
    
    /**
     * Metodo que actualiza al usuario y arroja una excepcion
     * @param usuarioNormal Usuario normal que se registrará
     * @throws ExcepcionAT
     */
    public void actualizarUsuarioNormal(UsuarioNormal usuarioNormal) throws ExcepcionAT;
    
    /**
     * Método que elimina al usuario y arroja una excepción
     * @param usuarioNormal
     * @throws ExcepcionAT 
     */
    public void eliminarUsuarioNormal(UsuarioNormal usuarioNormal) throws ExcepcionAT;
    
    /**
     * Método que busca y regresa al usuario en la base de datos
     * @param correo
     * @param contraseña
     * @return 
     * @throws ExcepcionAT 
     */
    public UsuarioNormal obtenerUsuarioNormal(String correo, String contraseña) throws ExcepcionAT;
    
    
}
