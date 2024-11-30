/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacesDAO;

import entidades.PostAnclado;
import excepciones.ExcepcionAT;
import java.util.List;

/**
 *
 * @author galan
 */
public interface IPostAncladoDAO {
    /**
     * Metodo que registra al post y arroja una excepcion
     * @param postAnclado Usuario normal que se registrará
     * @throws ExcepcionAT
     */
    public void registrarPostAnclado(PostAnclado postAnclado) throws ExcepcionAT;
    
    /**
     * Metodo que actualiza al post y arroja una excepcion
     * @param postAnclado Usuario normal que se registrará
     * @throws ExcepcionAT
     */
    public void actualizarPostAnclado(PostAnclado postAnclado) throws ExcepcionAT;
    
    /**
     * Método que elimina al post y arroja una excepción
     * @param postAnclado
     * @throws ExcepcionAT 
     */
    public void eliminarPostAnclado(PostAnclado postAnclado) throws ExcepcionAT;
    
    /**
     * Método que busca y regresa al post en la base de datos
     * @return 
     * @throws ExcepcionAT 
     */
    public PostAnclado obtenerPostAnclado(String titulo) throws ExcepcionAT;
    
    /**
     * Método que obtiene todos los posts comunes en la base de datos.
     * @return
     * @throws ExcepcionAT 
     */
    public List<PostAnclado> obtenerPosts() throws ExcepcionAT;
}
