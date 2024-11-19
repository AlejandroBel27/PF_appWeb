/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Comentario;
import entidades.PostComun;
import excepciones.ExcepcionAT;
import interfacesDAO.IComentarioDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author galan
 */
public class ComentarioDAO implements IComentarioDAO{
    EntityManagerFactory emf;
    EntityManager em;

    public ComentarioDAO() {
        emf = Persistence.createEntityManagerFactory("DominioPU");
    }

    @Override
    public void registrarComentario(Comentario comentario) throws ExcepcionAT {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.persist(comentario);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al registrar Comentario: " + e.getMessage());
            throw new ExcepcionAT("Error al obtener Comentario", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void actualizarComentario(Comentario comentario) throws ExcepcionAT {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.merge(comentario);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al actuzalizar Comentario: " + e.getMessage());
            throw new ExcepcionAT("Error al actualizar Comentario", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void eliminarComentario(Comentario comentario) throws ExcepcionAT {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.remove(comentario);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al eliminar Comentario: " + e.getMessage());
            throw new ExcepcionAT("Error al eliminar Comentario", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Comentario obtenerComentario(PostComun postComun) throws ExcepcionAT {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            String jpql = "SELECT c FROM Comentario c WHERE c.postComun = :post";
            TypedQuery<Comentario> query = em.createQuery(jpql, Comentario.class);
            query.setParameter("post", postComun);

            Comentario comentario = query.getSingleResult();

            em.getTransaction().commit();
            return comentario;
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al buscar Comentario: " + e.getMessage());
            throw new ExcepcionAT("Error al obtener Comentario", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    @Override
    public Comentario obtenerComentario(Comentario comentarioPadre) throws ExcepcionAT {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            String jpql = "SELECT c FROM Comentario c WHERE c.comentarioPadre = :comentario";
            TypedQuery<Comentario> query = em.createQuery(jpql, Comentario.class);
            query.setParameter("comentario", comentarioPadre);

            Comentario comentario = query.getSingleResult();

            em.getTransaction().commit();
            return comentario;
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al buscar Comentario: " + e.getMessage());
            throw new ExcepcionAT("Error al obtener Comentario", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
