/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacesDAO;

import entidades.PostComun;
import excepciones.ExcepcionAT;

/**
 *
 * @author galan
 */
public interface IPostComunDAO {
    /**
     * Metodo que registra al post y arroja una excepcion
     * @param postComun Usuario normal que se registrará
     * @throws ExcepcionAT
     */
    public void registrarPostComun(PostComun postComun) throws ExcepcionAT;
    
    /**
     * Metodo que actualiza al post y arroja una excepcion
     * @param postComun Usuario normal que se registrará
     * @throws ExcepcionAT
     */
    public void actualizarPostComun(PostComun postComun) throws ExcepcionAT;
    
    /**
     * Método que elimina al post y arroja una excepción
     * @param postComun
     * @throws ExcepcionAT 
     */
    public void eliminarPostComun(PostComun postComun) throws ExcepcionAT;
    
    /**
     * Método que busca y regresa al post en la base de datos
     * @return 
     * @throws ExcepcionAT 
     */
    public PostComun obtenerPostComun(String titulo) throws ExcepcionAT;
}
