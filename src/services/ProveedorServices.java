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

    public void persistirProveedor(String nombre) {
        try {
            ProveedorDAO dao = new ProveedorDAO();
        } catch (Exception e) {
            System.out.println("Error en el metodo persistirProveedor() en la clase proveedorService");
        }
    }

    public void modificarProveedor(int id, String nombre) {
        try {
            ProveedorDAO dao = new ProveedorDAO();
        } catch (Exception e) {
            System.out.println("Error en el metodo modificarProveedor() en la clase proveedorService");
        }
    }

    public void borrarProveedor(Proveedor aux) {
        try {
            ProveedorDAO dao = new ProveedorDAO();
        } catch (Exception e) {
            System.out.println("");
        }
    }

    public Proveedor buscarProveedorPorId(int id) {
        try {
            ProveedorDAO dao = new ProveedorDAO();
        } catch (Exception e) {
            System.out.println("Error en el metodo buscarProveedorPorId() en la clase proveedorService");
        }
        return null;
    }

    public List<Proveedor> listaProveedores() {
        try {
            ProveedorDAO dao = new ProveedorDAO();
        } catch (Exception e) {
            System.out.println("Error en el metodo listaProveedores() en la clase proveedorService");
        }
        return null;
    }
}
