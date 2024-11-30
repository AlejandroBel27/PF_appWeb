/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Administrador;
import excepciones.ExcepcionAT;
import interfacesDAO.IAdministradorDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author galan
 */
public class AdministradorDAO implements IAdministradorDAO{
    EntityManagerFactory emf;
    EntityManager em;

    public AdministradorDAO() {
        emf = Persistence.createEntityManagerFactory("DominioPU");
    }

    @Override
    public void registrarAdministrador(Administrador administrador) throws ExcepcionAT {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.persist(administrador);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al registrar Administrador: " + e.getMessage());
            throw new ExcepcionAT("Error al obtener Administrador", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void actualizarAdministrador(Administrador administrador) throws ExcepcionAT {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.merge(administrador);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al actuzalizar Administrador: " + e.getMessage());
            throw new ExcepcionAT("Error al actualizar Administrador", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void eliminarAdministrador(Administrador administrador) throws ExcepcionAT {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.remove(administrador);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al eliminar Administrador: " + e.getMessage());
            throw new ExcepcionAT("Error al eliminar Administrador", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Administrador obtenerAdministrador(String correo, String contraseña) throws ExcepcionAT {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            String jpql = "SELECT u FROM Administrador u WHERE u.correo = :correo AND u.contraseña = :contraseña";
            TypedQuery<Administrador> query = em.createQuery(jpql, Administrador.class);
            query.setParameter("correo", correo);
            query.setParameter("contraseña", contraseña);

            Administrador administrador = query.getSingleResult();

            em.getTransaction().commit();
            return administrador;
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al buscar Administrador: " + e.getMessage());
            throw new ExcepcionAT("Error al obtener Administrador", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
