/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import baseDeDatos.ProductoDAO;
import entidades.ModelProfile;
import entidades.Productos;
import entidades.Proveedor;
import java.util.Date;

/**
 *
 * @author criss
 */
public class ProductoServices {

    public void persistirProducto(String variedad, String nombre, Date fechaIngreso, String marca, String tipoProducto, String contenido, int stock, double precioCosto, double precioventa, double ganancias, double porcentajeGanancias, Proveedor proveedor, byte[] imagen, String descripcion) {
        try {
            ProductoDAO dao = new ProductoDAO();
            dao.persistirEntidad(new Productos(variedad, nombre, fechaIngreso, marca, tipoProducto, contenido, stock, precioCosto, precioventa, ganancias, porcentajeGanancias, imagen, proveedor, descripcion));
            System.out.println("Se agrego correctamente");
        } catch (Exception e) {
            System.out.println("Error en el metodo persistirProducto() de la clase ProductoServices");
        }
    }

    public void modificarProducto(int id, String variedad, String nombre, Date fechaIngreso, String marca, String tipoProducto, String contenido, int stock, double precioCosto, double precioventa, double ganancias, double porcentajeGanancias, Proveedor proveedor, String descripcion, ModelProfile ModelProfile) {
        try {
            ProductoDAO dao = new ProductoDAO();
        } catch (Exception e) {
            System.out.println("Error en el metodo modificarProducto() de la clase ProductoServices");
        }
    }

    public void eliminarProducto(Productos aux) {
        try {
            ProductoDAO dao = new ProductoDAO();
            dao.borrarEntidad(aux);
            System.out.println("Se elimino correctamente el producto");
        } catch (Exception e) {
            System.out.println("Error en el metodo eliminarProducto() de la clase ProductoServices");
        }
    }
}
