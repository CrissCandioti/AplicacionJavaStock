/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDeDatos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author criss
 */
public class DAO<T> {

    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("angeltienda");
    protected EntityManager em;

    /*
     * Metodo que va a heredar a sus clases hijas la cual realiza la coneccion a
     * la base de datos.
     */
    protected void conectar() {
        em = emf.createEntityManager();
    }

    /*
     * Metodo que va a heredar a sus clases hijas la cual realiza la
     * desconeccion a la base de datos.
     */
    protected void desconectar() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }

    /*
     * Metodo que va a heredar sus clases hijas la cual realiza la creacion e
     * insercion del object Entity a la base de datos.
     */
    protected void persistirEntidad(T object) {
        try {
            conectar();
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en el metodo persistirEntidad() de la clase DAO: " + e);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            desconectar();
        }
    }

    /*
     * Metodo que va a heredar sus clases hijas la cual realiza la modificacion
     * del object Entity a la base de datos.
     */
    protected void actualizarEntidad(T object) {
        try {
            conectar();
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en el metodo actualizarEntidad() en la clase DAO: " + e);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            desconectar();
        }
    }

    /*
     * Metodo que va a heredar sus clases hijas la cual realiza la eliminacion
     * del object Entity a la base de datos.
     */
    protected void borrarEntidad(T object) {
        try {
            conectar();
            em.getTransaction().begin();
            /**
             * Aplicamos un merge en la eliminacion para evitar un conflicto muy
             * comun con JPA la cual seria que al intentar eliminar un obect
             * Entity la entidad que se esta tratando de borrar no está
             * administrada por el EntityManager
             */
            object = em.merge(object);
            /**
             * El método merge() toma como parámetro una instancia de la entidad
             * que quieres fusionar. El método busca la instancia de la entidad
             * en la base de datos. Si la encuentra, la actualiza con los datos
             * de la instancia que pasaste como parámetro. Si no la encuentra,
             * la crea. El método devuelve la instancia fusionada. En este caso,
             * el método merge() fusionará la instancia object con la instancia
             * gestionada de la entidad. Esto hará que JPA se dé cuenta de que
             * la entidad ya existe en la base de datos y, por lo tanto, sabrá
             * cómo eliminarla.
             */
            em.remove(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en el metodo borrarEntidad de la clase DAO: " + e);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            desconectar();
        }
    }
    /**
     * En esta base de datos se aplico un "rollback". El rollback garantiza que
     * la base de datos no quede en un estado inconsistente si ocurre un error
     * durante una transacción. Por ejemplo, se refiere a una operación en una
     * base de datos que revierte una transacción a su estado previo, anulando
     * todos los cambios que se han realizado en el transcurso de la
     * transacción.
     */
}
