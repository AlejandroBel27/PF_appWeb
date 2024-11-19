/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacesDAO;

import entidades.Estado;
import excepciones.ExcepcionAT;

/**
 *
 * @author galan
 */
public interface IEstadoDAO {
    /**
     * Metodo que registra al estado y arroja una excepcion
     * @param estado Estado que se registrará
     * @throws ExcepcionAT
     */
    public void registrarEstado(Estado estado) throws ExcepcionAT;
    
    /**
     * Metodo que actualiza al estado y arroja una excepcion
     * @param estado Estado que se registrará
     * @throws ExcepcionAT
     */
    public void actualizarEstado(Estado estado) throws ExcepcionAT;
    
    /**
     * Método que elimina al estado y arroja una excepción
     * @param estado
     * @throws ExcepcionAT 
     */
    public void eliminarEstado(Estado estado) throws ExcepcionAT;

}
