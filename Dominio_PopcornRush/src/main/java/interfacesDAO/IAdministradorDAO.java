/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacesDAO;

import entidades.Administrador;
import excepciones.ExcepcionAT;

/**
 *
 * @author galan
 */
public interface IAdministradorDAO {
    /**
     * Metodo que registra al administrador y arroja una excepcion
     * @param administradorNormal Usuario normal que se registrará
     * @throws ExcepcionAT
     */
    public void registrarAdministrador(Administrador administradorNormal) throws ExcepcionAT;
    
    /**
     * Metodo que actualiza al administrador y arroja una excepcion
     * @param administradorNormal Usuario normal que se registrará
     * @throws ExcepcionAT
     */
    public void actualizarAdministrador(Administrador administradorNormal) throws ExcepcionAT;
    
    /**
     * Método que elimina al administrador y arroja una excepción
     * @param administradorNormal
     * @throws ExcepcionAT 
     */
    public void eliminarAdministrador(Administrador administradorNormal) throws ExcepcionAT;
    
    /**
     * Método que busca y regresa al administrador en la base de datos
     * @param correo
     * @param contraseña
     * @return 
     * @throws ExcepcionAT 
     */
    public Administrador obtenerAdministrador(String correo, String contraseña) throws ExcepcionAT;
}
