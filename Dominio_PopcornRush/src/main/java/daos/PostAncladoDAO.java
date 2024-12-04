/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Comentario;
import entidades.PostAnclado;
import excepciones.ExcepcionAT;
import interfacesDAO.IPostAncladoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author galan
 */
public class PostAncladoDAO implements IPostAncladoDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public PostAncladoDAO() {
        emf = Persistence.createEntityManagerFactory("DominioPU");
    }

    @Override
    public void registrarPostAnclado(PostAnclado postAnclado) throws ExcepcionAT {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.persist(postAnclado);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al registrar post anclado: " + e.getMessage());
            throw new ExcepcionAT("Error al obtener post anclado", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void actualizarPostAnclado(PostAnclado postAnclado) throws ExcepcionAT {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.persist(postAnclado);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al actualizar post anclado: " + e.getMessage());
            throw new ExcepcionAT("Error al obtener post anclado", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
public void eliminarPostAnclado(PostAnclado postAnclado) throws ExcepcionAT {
    try {
        em = emf.createEntityManager();
        em.getTransaction().begin();

        // Cargar la entidad desde la base de datos
        PostAnclado postManaged = em.find(PostAnclado.class, postAnclado.getId());
        if (postManaged != null) {
            em.remove(postManaged);
        } else {
            throw new IllegalArgumentException("La entidad no existe en la base de datos.");
        }

        em.getTransaction().commit();
    } catch (Exception e) {
        if (em != null) {
            em.getTransaction().rollback();
        }
        System.err.println("Error al registrar post anclado: " + e.getMessage());
        throw new ExcepcionAT("Error al obtener post anclado", e);
    } finally {
        if (em != null) {
            em.close();
        }
    }
}

    @Override
    public PostAnclado obtenerPostAnclado(String titulo) throws ExcepcionAT {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            String jpql = "SELECT p FROM PostAnclado p WHERE p.titulo = :titulo";
            TypedQuery<PostAnclado> query = em.createQuery(jpql, PostAnclado.class);
            query.setParameter("titulo", titulo);

            PostAnclado postAnclado = query.getSingleResult();

            em.getTransaction().commit();
            return postAnclado;
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al buscar post acnlado: " + e.getMessage());
            throw new ExcepcionAT("Error al buscar post anclado", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    @Override
    public List<PostAnclado> obtenerPosts () throws ExcepcionAT{
        List<PostAnclado> posts = null;
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            // Consulta JPQL para obtener todos los posts comunes
            String jpql = "SELECT p FROM PostAnclado p";
            TypedQuery<PostAnclado> query = em.createQuery(jpql, PostAnclado.class);

            // Obtener la lista de resultados
            posts = query.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al obtener posts anclados: " + e.getMessage());
            throw new ExcepcionAT("Error al obtener posts anclados", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return posts;
    }

    @Override
    public PostAnclado obtenerPostAncladoPorId(long id) throws ExcepcionAT {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            String jpql = "SELECT p FROM PostAnclado p WHERE p.id = :id";
            TypedQuery<PostAnclado> query = em.createQuery(jpql, PostAnclado.class);
            query.setParameter("id", id);

            PostAnclado postAnclado = query.getSingleResult();

            em.getTransaction().commit();
            return postAnclado;
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al buscar post acnlado: " + e.getMessage());
            throw new ExcepcionAT("Error al buscar post anclado", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
