/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDeDatos;

import entidades.Cliente;
import java.util.List;

/**
 *
 * @author criss
 */
public class ClienteDAO extends DAO<Cliente> {

    @Override
    public void persistirEntidad(Cliente object) {
        super.persistirEntidad(object); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void actualizarEntidad(Cliente object) {
        super.actualizarEntidad(object); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void borrarEntidad(Cliente object) {
        super.borrarEntidad(object); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public List<Cliente> listaCliente() {
        try {
            conectar();
            return (List<Cliente>) em.createQuery("Select f From Cliente f").getResultList();
        } catch (Exception e) {
            System.out.println("Error metodo listaCliente() de la clase ClienteDAO");
        } finally {
            desconectar();
        }
        return null;
    }

    public List<Cliente> barraBusqueda(String busqueda) {
        try {
            conectar();
            return (List<Cliente>) em.createQuery("Select f From Cliente f Where f.nombre LIKE :busqueda or f.apellido LIKE :busqueda").setParameter("busqueda", "%" + busqueda + "%").getResultList();
        } catch (Exception e) {
            System.out.println("Error en el metodo barraBusqueda en la clase ClienteDAO");
        } finally {
            desconectar();
        }
        return null;
    }

    public Cliente buscarClienteID(int id) {
        try {
            conectar();
            return em.find(Cliente.class, id);
        } catch (Exception e) {
            System.out.println("Error en el metodo buscarClienteID() de la clase ClienteDAO");
        } finally {
            desconectar();
        }
        return null;
    }

}
