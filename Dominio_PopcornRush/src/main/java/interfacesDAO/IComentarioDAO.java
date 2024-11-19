/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacesDAO;

import entidades.Comentario;
import entidades.PostComun;
import excepciones.ExcepcionAT;

/**
 *
 * @author galan
 */
public interface IComentarioDAO {
    /**
     * Metodo que registra al administrador y arroja una excepcion
     * @param comentario Comentario que se registrará
     * @throws ExcepcionAT
     */
    public void registrarComentario(Comentario comentario) throws ExcepcionAT;
    
    /**
     * Metodo que actualiza al administrador y arroja una excepcion
     * @param comentario Comentario que se registrará
     * @throws ExcepcionAT
     */
    public void actualizarComentario(Comentario comentario) throws ExcepcionAT;
    
    /**
     * Método que elimina al Comentario y arroja una excepción
     * @param comentario
     * @throws ExcepcionAT 
     */
    public void eliminarComentario(Comentario comentario) throws ExcepcionAT;
    
    /**
     * Método que busca y regresa al Comentario segun su post en la base de datos
     * @return 
     * @throws ExcepcionAT 
     */
    public Comentario obtenerComentario(PostComun postComun) throws ExcepcionAT;
    
    /**
     * Método que busca y regresa al Comentario en la base de datos segun su comentario padre
     * @return 
     * @throws ExcepcionAT 
     */
    public Comentario obtenerComentario(Comentario comentarioPadre) throws ExcepcionAT;
}
