/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author galan
 */
@Entity
@Table(name = "usuarios_normales")
public class UsuarioNormal extends Usuario implements Serializable {

    @OneToMany(mappedBy = "usuarioNormal", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;
    
    public UsuarioNormal(){
        
    }
    
    public UsuarioNormal(String nombreCompleto, String correo, String contrasenia, String telefono, String avatar, String ciudad, Calendar fechaNacimiento, String genero, Municipio municipio) {
        super(nombreCompleto, correo, contrasenia, telefono, avatar, ciudad, fechaNacimiento, genero, municipio);
    }
    
}
