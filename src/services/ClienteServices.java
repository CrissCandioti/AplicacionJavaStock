/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import baseDeDatos.ClienteDAO;
import entidades.Cliente;
import java.util.List;
import raven.alerts.MessageAlerts;

/**
 *
 * @author criss
 */
public class ClienteServices {

    public void persistirCliente(String nombre, String apellido, int documento, String email, String whatsapp, String localidad, String direccion, String nota) {
        try {
            ClienteDAO dao = new ClienteDAO();
            if (nombre.isEmpty()) {
                MessageAlerts.getInstance().showMessage("Se produjo un error", "El cliente no puede tener la celda del nombre vacio", MessageAlerts.MessageType.ERROR);
                return;
            }
            if (apellido.isEmpty()) {
                MessageAlerts.getInstance().showMessage("Se produjo un error", "El cliente no puede tener la celda del apellido vacio", MessageAlerts.MessageType.ERROR);
                return;
            }
            if (email.isEmpty()) {
                MessageAlerts.getInstance().showMessage("Se produjo un error", "El cliente no puede tener la celda del email vacia", MessageAlerts.MessageType.ERROR);
                return;
            }
            if (whatsapp.isEmpty()) {
                MessageAlerts.getInstance().showMessage("Se produjo un error", "El cliente no puede tener la celda del Whats app vacia", MessageAlerts.MessageType.ERROR);
                return;
            }
            if (localidad.isEmpty()) {
                MessageAlerts.getInstance().showMessage("Se produjo un error", "El cliente no puede tener la celda de la localidad vacia", MessageAlerts.MessageType.ERROR);
                return;
            }
            if (direccion.isEmpty()) {
                MessageAlerts.getInstance().showMessage("Se produjo un error", "El cliente no puede tener la celda de la direccion vacia", MessageAlerts.MessageType.ERROR);
                return;
            }
            if (nota.isEmpty()) {
                MessageAlerts.getInstance().showMessage("Se produjo un error", "El cliente no puede tener la celda de las notas vacia", MessageAlerts.MessageType.ERROR);
                return;
            }
            Cliente c = new Cliente(nombre, apellido, documento, email, whatsapp, localidad, direccion, nota);
            dao.persistirEntidad(c);
            MessageAlerts.getInstance().showMessage("Se agrego correctamente", "El cliente fue agregado correctamente a la base de datos", MessageAlerts.MessageType.SUCCESS);
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
