/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import baseDeDatos.ProveedorDAO;
import entidades.Proveedor;
import java.util.List;
import raven.alerts.MessageAlerts;

/**
 *
 * @author criss
 */
public class ProveedorServices {

    public void persistirProveedor(String nombre, String notas) {
        if (nombre.isEmpty()) {
            MessageAlerts.getInstance().showMessage("Se produjo un error", "El Proveedor no puede tener la celda del nombre vacia", MessageAlerts.MessageType.ERROR);
            return;
        }
        try {
            new ProveedorDAO().persistirEntidad(new Proveedor(nombre, notas));
            MessageAlerts.getInstance().showMessage("Se agrego correctamente", "El Proveedor fue agregado correctamente a la base de datos", MessageAlerts.MessageType.SUCCESS);
        } catch (Exception e) {
            System.out.println("Error en el metodo persistirProveedor() en la clase proveedorService");
        }
    }

    public void modificarProveedor(int id, String nombre, String notas) {
        if (nombre.isEmpty()) {
            MessageAlerts.getInstance().showMessage("Se produjo un error", "El Proveedor no puede tener la celda del nombre vacia", MessageAlerts.MessageType.ERROR);
            return;
        }
        try {
            new ProveedorDAO().actualizarEntidad(new Proveedor(id, nombre, notas));
            MessageAlerts.getInstance().showMessage("Se modifico correctamente", "El proveedore fue modificado correctamente", MessageAlerts.MessageType.SUCCESS);
        } catch (Exception e) {
            System.out.println("Error en el metodo modificarProveedor() en la clase proveedorService");
        }
    }

    public void borrarProveedor(Proveedor aux) {
        try {
            new ProveedorDAO().borrarEntidad(aux);
            System.out.println("Se agrego correctamente el proveedor a la base de datos");
        } catch (Exception e) {
            System.out.println("Error en el metodo borrarProveedor() de la clase proveedorServices");
        }
    }

    public Proveedor buscarProveedorPorId(int id) {
        try {
            return new ProveedorDAO().buscarProveedorPorID(id);
        } catch (Exception e) {
            System.out.println("Error en el metodo buscarProveedorPorId() en la clase proveedorService");
            return null;
        }
    }

    public List<Proveedor> listaProveedores() {
        try {
            return new ProveedorDAO().listaProveedores();
        } catch (Exception e) {
            System.out.println("Error en el metodo listaProveedores() en la clase proveedorService");
            return null;
        }
    }

    public List<Proveedor> barraBusqueda(String busqueda) {
        try {
            return new ProveedorDAO().barraBusqueda(busqueda);
        } catch (Exception e) {
            System.out.println("Error en el metodo barraBusqueda() de la clase proveedorService");
            return null;
        }
    }
}
