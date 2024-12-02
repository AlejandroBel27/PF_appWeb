/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacesDAO;

import entidades.PostComun;
import entidades.Usuario;
import excepciones.ExcepcionAT;
import java.util.List;

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
    
    /**
     * Método que busca y regresa al post en la base de datos que coincida con el id reqerido.
     * @return 
     * @throws ExcepcionAT 
     */
    public PostComun obtenerPostComunPoirId(long id) throws ExcepcionAT;
    
    /**
     * Método que obtiene todos los posts comunes en la base de datos.
     * @return
     * @throws ExcepcionAT 
     */
    public List<PostComun> obtenerPosts() throws ExcepcionAT;
    
    /**
     * Método que obtiene todos los posts comunes del usuario especificado.
     * @return
     * @throws ExcepcionAT 
     */
    public List<PostComun> obtenerPostsPorUsuario(Usuario usuario) throws ExcepcionAT;
}
