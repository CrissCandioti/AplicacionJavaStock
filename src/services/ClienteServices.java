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
            new ClienteDAO().persistirEntidad(new Cliente(nombre, apellido, documento, email, whatsapp, localidad, direccion, nota));
        } catch (Exception e) {
            System.out.println("Error en el metodo persistirCLiente() de la clase ClienteServices");
        }
    }

    public void borrarCliente(Cliente aux) {
        try {
            new ClienteDAO().borrarEntidad(aux);
            System.out.println("Se borro con exito el cliente");
        } catch (Exception e) {
            System.out.println("Error en el metodo borrarCliente de la clase ClienteServices");
        }
    }

    public void modificarCliente(int id, String nombre, String apellido, int documento, String email, String whatsapp, String localidad, String direccion, String nota) {
        try {
            new ClienteDAO().actualizarEntidad(new Cliente(id, nombre, apellido, documento, email, whatsapp, localidad, direccion, nota));
            System.out.println("Se modifico con exitos el cliente");
        } catch (Exception e) {
            System.out.println("Error en el metodo modificarCliente() en la clase ClienteServices");
        }
    }

    public List<Cliente> listaCliente() {
        try {
            return new ClienteDAO().listaCliente();
        } catch (Exception e) {
            System.out.println("Error metodo listaCliente() en la clase ClienteService");
            return null;
        }
    }

    public List<Cliente> busquedaCliente(String search) {
        try {
            return new ClienteDAO().barraBusqueda(search);
        } catch (Exception e) {
            System.out.println("Error metodo busquedaCliente en la clase clienteService");
            return null;
        }
    }

    public Cliente buscarClienteID(int id) {
        try {
            return new ClienteDAO().buscarClienteID(id);
        } catch (Exception e) {
            System.out.println("Error en el metodo busarClienteID de la clase ClienteServices");
            return null;
        }
    }
}
