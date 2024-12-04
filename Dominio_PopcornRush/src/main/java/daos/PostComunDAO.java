/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.PostComun;
import entidades.Usuario;
import excepciones.ExcepcionAT;
import interfacesDAO.IPostComunDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author galan
 */
public class PostComunDAO implements IPostComunDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public PostComunDAO() {
        emf = Persistence.createEntityManagerFactory("DominioPU");
    }

    @Override
    public void registrarPostComun(PostComun postComun) throws ExcepcionAT {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.persist(postComun);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al registrar post comun: " + e.getMessage());
            throw new ExcepcionAT("Error al obtener post comun", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void actualizarPostComun(PostComun postComun) throws ExcepcionAT {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.persist(postComun);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al actualizar post comun: " + e.getMessage());
            throw new ExcepcionAT("Error al obtener post comun", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void eliminarPostComun(PostComun postComun) throws ExcepcionAT {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            // Cargar la entidad desde la base de datos
            PostComun postManaged = em.find(PostComun.class, postComun.getId());
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
            System.err.println("Error al registrar post comun: " + e.getMessage());
            throw new ExcepcionAT("Error al obtener post comun", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public PostComun obtenerPostComun(String titulo) throws ExcepcionAT {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            String jpql = "SELECT p FROM PostComun p WHERE p.titulo = :titulo";
            TypedQuery<PostComun> query = em.createQuery(jpql, PostComun.class);
            query.setParameter("titulo", titulo);

            PostComun postComun = query.getSingleResult();

            em.getTransaction().commit();
            return postComun;
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al buscar post acnlado: " + e.getMessage());
            throw new ExcepcionAT("Error al buscar post comun", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<PostComun> obtenerPosts() throws ExcepcionAT {
        List<PostComun> posts = null;
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            // Consulta JPQL para obtener todos los posts comunes
            String jpql = "SELECT p FROM PostComun p";
            TypedQuery<PostComun> query = em.createQuery(jpql, PostComun.class);

            // Obtener la lista de resultados
            posts = query.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al obtener posts comunes: " + e.getMessage());
            throw new ExcepcionAT("Error al obtener posts comunes", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return posts;
    }

    @Override
    public PostComun obtenerPostComunPoirId(long id) throws ExcepcionAT {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            String jpql = "SELECT p FROM PostComun p WHERE p.id = :id";
            TypedQuery<PostComun> query = em.createQuery(jpql, PostComun.class);
            query.setParameter("id", id);

            PostComun postComun = query.getSingleResult();

            em.getTransaction().commit();
            return postComun;
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al buscar post acnlado: " + e.getMessage());
            throw new ExcepcionAT("Error al buscar post comun", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<PostComun> obtenerPostsPorUsuario(Usuario usuario) throws ExcepcionAT {
        if (usuario == null || usuario.getId() == null) {
            throw new IllegalArgumentException("El usuario o su ID no pueden ser nulos.");
        }

        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            // Consulta usando ID del usuario
            String jpql = "SELECT p FROM PostComun p WHERE p.usuario.id = :usuarioId";
            TypedQuery<PostComun> query = em.createQuery(jpql, PostComun.class);
            query.setParameter("usuarioId", usuario.getId());

            List<PostComun> posts = query.getResultList();

            em.getTransaction().commit();
            return posts;
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al buscar posts del usuario: " + e.getMessage());
            throw new ExcepcionAT("Error al buscar posts del usuario", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
