/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacesDAO;

import entidades.Municipio;
import excepciones.ExcepcionAT;

/**
 *
 * @author galan
 */
public interface IMunicipioDAO {
    /**
     * Metodo que registra al municipio y arroja una excepcion
     * @param municipio Municipio que se registrará
     * @throws ExcepcionAT
     */
    public void registrarMunicipio(Municipio municipio) throws ExcepcionAT;
    
    /**
     * Metodo que actualiza al municipio y arroja una excepcion
     * @param municipio Municipio que se registrará
     * @throws ExcepcionAT
     */
    public void actualizarMunicipio(Municipio municipio) throws ExcepcionAT;
    
    /**
     * Método que elimina al municipio y arroja una excepción
     * @param municipio
     * @throws ExcepcionAT 
     */
    public void eliminarMunicipio(Municipio municipio) throws ExcepcionAT;
}
