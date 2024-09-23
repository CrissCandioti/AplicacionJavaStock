/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import baseDeDatos.ClienteDAO;
import entidades.Cliente;
import java.util.List;

/**
 *
 * @author criss
 */
public class ClienteServices {

    public void persistirCliente(String nombre, String apellido, int documento, String email, String whatsapp, String localidad, String direccion, String nota) {
        try {
            Cliente c = new Cliente(nombre, apellido, documento, email, whatsapp, localidad, direccion, nota);
            ClienteDAO dao = new ClienteDAO();
            dao.persistirEntidad(c);
            System.out.println("Se agrego con exito el cliente");
        } catch (Exception e) {
            System.out.println("Error en el metodo persistirCLiente() de la clase ClienteServices");
        }
    }

    public void borrarCliente(Cliente aux) {
        try {
            ClienteDAO dao = new ClienteDAO();
            dao.borrarEntidad(aux);
            System.out.println("Se borro con exito el cliente");
        } catch (Exception e) {
            System.out.println("Error en el metodo borrarCliente de la clase ClienteServices");
        }
    }

    public void modificarCliente(int id, String nombre, String apellido, int documento, String email, String whatsapp, String localidad, String direccion, String nota) {
        try {
            Cliente c = new Cliente(id, nombre, apellido, documento, email, whatsapp, localidad, direccion, nota);
            ClienteDAO dao = new ClienteDAO();
            dao.actualizarEntidad(c);
            System.out.println("Se modifico con exitos el cliente");
        } catch (Exception e) {
            System.out.println("Error en el metodo modificarCliente() en la clase ClienteServices");
        }
    }

    public List<Cliente> listaCliente() {
        try {
            ClienteDAO dao = new ClienteDAO();
            return dao.listaCliente();
        } catch (Exception e) {
            System.out.println("Error metodo listaCliente() en la clase ClienteService");
        }
        return null;
    }

    public List<Cliente> busquedaCliente(String search) {
        try {
            ClienteDAO dao = new ClienteDAO();
            return dao.barraBusqueda(search);
        } catch (Exception e) {
            System.out.println("Error metodo busquedaCliente en la clase clienteService");
        }
        return null;
    }

    public Cliente buscarClienteID(int id) {
        try {
            ClienteDAO dao = new ClienteDAO();
            return dao.buscarClienteID(id);
        } catch (Exception e) {
            System.out.println("Error en el metodo busarClienteID de la clase ClienteServices");
        }
        return null;
    }
}
