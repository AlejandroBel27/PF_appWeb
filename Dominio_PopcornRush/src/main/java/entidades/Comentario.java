/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 *
 * @author galan
 */
@Entity
@JsonIgnoreProperties({"postComun"})
@Table(name = "comentarios")
public class Comentario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechaHora", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaHora;

    @Column(name = "contenido", nullable = false, columnDefinition = "TEXT")
    private String contenido;

    // Relación muchos a uno con Post (un post puede tener muchos comentarios)
    @ManyToOne
    @JoinColumn(name = "postComun", nullable = false)
    private PostComun postComun;

    // Relación muchos a uno con Usuario (un usuario puede hacer muchos comentarios)
    @ManyToOne
    @JoinColumn(name = "usuarioNormal", nullable = false)
    private UsuarioNormal usuarioNormal;
    
    // Relación recursiva: un comentario puede tener un comentario padre
    @ManyToOne
    @JoinColumn(name = "comentarioPadre")
    private Comentario comentarioPadre;

    // Relación recursiva: un comentario puede tener varios comentarios hijos
    @OneToMany(mappedBy = "comentarioPadre", cascade = CascadeType.ALL)
    private List<Comentario> comentariosHijos;

    public Comentario() {
    }

    public Comentario(Calendar fechaHora, String contenido, PostComun postComun, UsuarioNormal usuarioNormal, Comentario comentarioPadre) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.postComun = postComun;
        this.usuarioNormal = usuarioNormal;
        this.comentarioPadre = comentarioPadre;
        this.comentariosHijos = new ArrayList<>();
    }

    public Comentario(Calendar fechaHora, String contenido, PostComun postComun, UsuarioNormal usuarioNormal) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.postComun = postComun;
        this.usuarioNormal = usuarioNormal;
        this.comentarioPadre = null;
        this.comentariosHijos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public PostComun getPostComun() {
        return postComun;
    }

    public void setPostComun(PostComun postComun) {
        this.postComun = postComun;
    }

    public UsuarioNormal getUsuarioNormal() {
        return usuarioNormal;
    }

    public void setUsuarioNormal(UsuarioNormal usuarioNormal) {
        this.usuarioNormal = usuarioNormal;
    }

    public Comentario getComentarioPadre() {
        return comentarioPadre;
    }

    public void setComentarioPadre(Comentario comentarioPadre) {
        this.comentarioPadre = comentarioPadre;
    }

    public List<Comentario> getComentariosHijos() {
        return comentariosHijos;
    }

    public void setComentariosHijos(List<Comentario> comentariosHijos) {
        this.comentariosHijos = comentariosHijos;
    }
    
    public void añadirComentarioHijo(Comentario comentario){
        comentariosHijos.add(comentario);
    }
    
    
    
    
    
}
