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
import java.util.List;

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

    public void modificarProducto(int id, String variedad, String nombre, Date fechaIngreso, String marca, String tipoProducto, String contenido, int stock, double precioCosto, double precioventa, double ganancias, double porcentajeGanancias, Proveedor proveedor, String descripcion, byte[] imagen) {
        try {
            ProductoDAO dao = new ProductoDAO();
            Productos p = new Productos(id, variedad, nombre, fechaIngreso, marca, tipoProducto, contenido, stock, precioCosto, precioventa, ganancias, porcentajeGanancias, imagen, proveedor, descripcion);
            dao.actualizarEntidad(p);
            System.out.println("Se agrego correctamente en la base de datos");
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

    public List<Productos> listaProductos() {
        try {
            ProductoDAO dao = new ProductoDAO();
            return dao.listaProductos();
        } catch (Exception e) {
            System.out.println("Error en el metodo listaProductos() de la clase productosSerivces");
        }
        return null;
    }

    public List<Productos> barraBusquedaProductos(String busqueda) {
        try {
            ProductoDAO dao = new ProductoDAO();
            return dao.barraBusquedaProductos(busqueda);
        } catch (Exception e) {
            System.out.println("Error en el metodo barraBusquedaProductos de la clase ProductoServices");
        }
        return null;
    }

    public Productos buscarProductoPorID(int id) {
        try {
            ProductoDAO dao = new ProductoDAO();
            return dao.buscarProductoPorID(id);
        } catch (Exception e) {
            System.out.println("Error en el metodo buscarProductoPorID de la clase ProductoServices");
        }
        return null;
    }
}
