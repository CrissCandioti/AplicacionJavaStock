/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDeDatos;

import entidades.Productos;
import java.util.List;

/**
 *
 * @author criss
 */
public final class ProductoDAO extends DAO<Productos> {

    @Override
    public void persistirEntidad(Productos object) {
        super.persistirEntidad(object); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void actualizarEntidad(Productos object) {
        super.actualizarEntidad(object); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void borrarEntidad(Productos object) {
        super.borrarEntidad(object); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public List<Productos> listaProductos() {
        try {
            conectar();
            return (List<Productos>) em.createQuery("Select f From Productos f").getResultList();
        } catch (Exception e) {
            System.out.println("Error en el metodo listaProductos() de la clase productosDAO");
        } finally {
            desconectar();
        }
        return null;
    }

    public Productos buscarProductoPorID(int id) {
        try {
            conectar();
            return em.find(Productos.class, id);
        } catch (Exception e) {
            System.out.println("Error en el metodo buscarProductoPorID de la clase ProductoDAO");
        } finally {
            desconectar();
        }
        return null;
    }

    public List<Productos> barraBusquedaProductos(String busqueda) {
        try {
            conectar();
            return (List<Productos>) em.createQuery("Select f From Productos f Where f.nombre LIKE :busqueda").setParameter("busqueda", "%" + busqueda + "%").getResultList();
        } catch (Exception e) {
            System.out.println("Error en el metodo barraBusquedaProductos de la clase ProductosDAO");
        } finally {
            desconectar();
        }
        return null;
    }

    public List<Productos> listaDeProductosDeXProveedor(int id) {
        try {
            conectar();
        } catch (Exception e) {
            System.out.println("Error en el metodo listaDeProductosDeXProveedor() de la clase ProductoDAO");
        } finally {
            desconectar();
        }
        return null;
    }
}
