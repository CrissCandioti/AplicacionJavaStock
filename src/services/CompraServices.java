/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import baseDeDatos.CompraDAO;
import entidades.Cliente;
import entidades.Compra;
import entidades.Productos;
import java.util.Date;
import java.util.List;

/**
 *
 * @author criss
 */
public class CompraServices {

    public void persistirEntidad(Date date, Cliente aux, List<Productos> listaProductos, String detalles, double total) {
        try {
            CompraDAO dao = new CompraDAO();
            Compra index = new Compra(date, aux, listaProductos, detalles, total);
            dao.persistirEntidad(index);
            System.out.println("La compra se realizo con exito");
        } catch (Exception e) {
            System.out.println("Error en la clase persistirEntidad de la clase CompraDAO");
        }
    }

    public void actualizarEntidad(int id, Date date, Cliente aux, List<Productos> listaProductos, String detalles, double total) {
        try {
            CompraDAO dao = new CompraDAO();
            Compra index = new Compra(id, date, aux, listaProductos, detalles, total);
            dao.actualizarEntidad(index);
            System.out.println("Se actualizo con exitos");
        } catch (Exception e) {
            System.out.println("Error en el metodo actualizarEntidad() de la clase CompraServices");
        }
    }

    public void borrarEntidad(Compra aux) {
        try {
            CompraDAO dao = new CompraDAO();
            dao.borrarEntidad(aux);
            System.out.println("Se elimino correctamente la compra");
        } catch (Exception e) {
            System.out.println("Error en el metodo BorrarEntidad de la clase CompraServices");
        }
    }

    public List<Compra> listaCompra() {
        try {
            CompraDAO dao = new CompraDAO();
            return dao.listaCompra();
        } catch (Exception e) {
            System.out.println("Error en el metodo listaCompra de la clase ComprServices");
        }
        return null;
    }

    public List<Compra> listaCompraPorCliente(int id) {
        try {
            CompraDAO dao = new CompraDAO();
            return dao.listaDeCompraDeXCliente(id);
        } catch (Exception e) {
            System.out.println("Error en el metodo listaCompraPorCliente de la clase ComprServices");
        }
        return null;
    }

    public Compra compraPorID(int id) {
        try {
            CompraDAO dao = new CompraDAO();
            return dao.compraPorID(id);
        } catch (Exception e) {
            System.out.println("Error en la compraPorID de la compraServices");
        }
        return null;
    }
}
