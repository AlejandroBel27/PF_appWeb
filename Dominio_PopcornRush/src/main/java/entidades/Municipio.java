/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author galan
 */
@Entity
@Table(name = "municipios")
public class Municipio implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = true, length = 20)
    private String nombre;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "estado_id") // Clave foránea hacia Estado
    private Estado estado;

    @OneToMany(mappedBy = "municipio", cascade = CascadeType.ALL) // Un municipio puede tener varios usuarios
    private List<Usuario> usuarios;

    public Municipio() {
    }

    
    public Municipio(String nombre, Estado estado) {
        this.nombre = nombre;
        this.estado = estado;
        this.usuarios = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public void añadirUsuarios(Usuario usuario){
        usuarios.add(usuario);
    }
    
}
