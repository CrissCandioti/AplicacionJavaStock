/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import baseDeDatos.ProveedorDAO;
import entidades.Proveedor;
import java.util.List;

/**
 *
 * @author criss
 */
public class ProveedorServices {

    public void persistirProveedor(String nombre, String notas) {
        try {
            ProveedorDAO dao = new ProveedorDAO();
            dao.persistirEntidad(new Proveedor(nombre, notas));
            System.out.println("Se agrego correctamente el proveedor a la base de datos");
        } catch (Exception e) {
            System.out.println("Error en el metodo persistirProveedor() en la clase proveedorService");
        }
    }

    public void modificarProveedor(int id, String nombre, String notas) {
        try {
            ProveedorDAO dao = new ProveedorDAO();
            dao.actualizarEntidad(new Proveedor(id, nombre, notas));
            System.out.println("Se modifico correctamente el proveedor a la base de datos");
        } catch (Exception e) {
            System.out.println("Error en el metodo modificarProveedor() en la clase proveedorService");
        }
    }

    public void borrarProveedor(Proveedor aux) {
        try {
            ProveedorDAO dao = new ProveedorDAO();
            System.out.println("Se agrego correctamente el proveedor a la base de datos");
            dao.borrarEntidad(aux);
        } catch (Exception e) {
            System.out.println("Error en el metodo borrarProveedor() de la clase proveedorServices");
        }
    }

    public Proveedor buscarProveedorPorId(int id) {
        try {
            ProveedorDAO dao = new ProveedorDAO();
            return dao.buscarProveedorPorID(id);
        } catch (Exception e) {
            System.out.println("Error en el metodo buscarProveedorPorId() en la clase proveedorService");
        }
        return null;
    }

    public List<Proveedor> listaProveedores() {
        try {
            ProveedorDAO dao = new ProveedorDAO();
            return dao.listaProveedores();
        } catch (Exception e) {
            System.out.println("Error en el metodo listaProveedores() en la clase proveedorService");
        }
        return null;
    }

    public List<Proveedor> barraBusqueda(String busqueda) {
        try {
            ProveedorDAO dao = new ProveedorDAO();
            return dao.barraBusqueda(busqueda);
        } catch (Exception e) {
            System.out.println("Error en el metodo barraBusqueda() de la clase proveedorService");
        }
        return null;
    }
}
