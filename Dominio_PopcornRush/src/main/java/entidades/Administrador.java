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
@Table(name = "administradores")
public class Administrador extends Usuario implements Serializable {

    // Relación uno a muchos con Anclado
    @OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL)
    private List<PostAnclado> postsAnclados;
    
    public Administrador(){
        
    }
    
    public Administrador(String nombreCompleto, String correo, String contrasenia, String telefono, String avatar, String ciudad, Calendar fechaNacimiento, String genero, Municipio municipio) {
        super(nombreCompleto, correo, contrasenia, telefono, avatar, ciudad, fechaNacimiento, genero, municipio);
    }

    public List<PostAnclado> getPostsAnclados() {
        return postsAnclados;
    }

    public void setPostsAnclados(List<PostAnclado> postsAnclados) {
        this.postsAnclados = postsAnclados;
    }
    
    
}
