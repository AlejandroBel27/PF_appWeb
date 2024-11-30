/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.UsuarioNormal;
import excepciones.ExcepcionAT;
import interfacesDAO.IUsuarioNormalDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author galan
 */
public class UsuarioNormalDAO implements IUsuarioNormalDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public UsuarioNormalDAO() {
        emf = Persistence.createEntityManagerFactory("DominioPU");
    }

    @Override
    public void registrarUsuarioNormal(UsuarioNormal usuarioNormal) throws ExcepcionAT {
        EntityTransaction transaction = null;
        try {
            em = emf.createEntityManager();
            transaction = em.getTransaction();

            // Inicia la transacción si no está activa
            if (!transaction.isActive()) {
                transaction.begin();
            }

            // Realiza la operación de persistencia
            em.persist(usuarioNormal);

            // Commit de la transacción
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback(); // Rollback si la transacción está activa
            }
            System.err.println("Error al registrar UsuarioNormal: " + e.getMessage());
            throw new ExcepcionAT("Error al obtener UsuarioNormal", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void actualizarUsuarioNormal(UsuarioNormal usuarioNormal) throws ExcepcionAT {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.merge(usuarioNormal);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al actuzalizar UsuarioNormal: " + e.getMessage());
            throw new ExcepcionAT("Error al actualizar UsuarioNormal", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void eliminarUsuarioNormal(UsuarioNormal usuarioNormal) throws ExcepcionAT {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.remove(usuarioNormal);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al eliminar UsuarioNormal: " + e.getMessage());
            throw new ExcepcionAT("Error al eliminar UsuarioNormal", e);
        } finally {
            if (em != null) {
            }
        }
    }

    @Override
    public UsuarioNormal obtenerUsuarioNormal(String correo, String contraseña) throws ExcepcionAT {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            String jpql = "SELECT u FROM UsuarioNormal u WHERE u.correo = :correo AND u.contraseña = :contraseña";
            TypedQuery<UsuarioNormal> query = em.createQuery(jpql, UsuarioNormal.class);
            query.setParameter("correo", correo);
            query.setParameter("contraseña", contraseña);

            UsuarioNormal usuarioNormal = query.getSingleResult();

            em.getTransaction().commit();
            return usuarioNormal;
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al buscar UsuarioNormal: " + e.getMessage());
            throw new ExcepcionAT("Error al obtener UsuarioNormal", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
