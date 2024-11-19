/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Municipio;
import excepciones.ExcepcionAT;
import interfacesDAO.IMunicipioDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author galan
 */
public class MunicipioDAO implements IMunicipioDAO{
    EntityManagerFactory emf;
    EntityManager em;

    public MunicipioDAO() {
        emf = Persistence.createEntityManagerFactory("DominioPU");
    }

    @Override
    public void registrarMunicipio(Municipio municipio) throws ExcepcionAT {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.persist(municipio);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al registrar municipio: " + e.getMessage());
            throw new ExcepcionAT("Error al obtener municipio", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void actualizarMunicipio(Municipio municipio) throws ExcepcionAT {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.merge(municipio);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al registrar municipio: " + e.getMessage());
            throw new ExcepcionAT("Error al obtener municipio", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void eliminarMunicipio(Municipio municipio) throws ExcepcionAT {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.remove(municipio);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al registrar municipio: " + e.getMessage());
            throw new ExcepcionAT("Error al obtener municipio", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
