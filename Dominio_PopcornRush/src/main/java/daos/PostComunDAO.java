/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.PostComun;
import excepciones.ExcepcionAT;
import interfacesDAO.IPostComunDAO;
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

            em.remove(postComun);

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
}
