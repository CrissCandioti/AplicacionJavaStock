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
import raven.alerts.MessageAlerts;

/**
 *
 * @author criss
 */
public class CompraServices {

    public void persistirEntidad(Date date, Cliente aux, List<Productos> listaProductos, List<Integer> cantidadComprada, String detalles, double total) {
        try {
            if (listaProductos.isEmpty()) {
                MessageAlerts.getInstance().showMessage("Error al realizar la compra", "La lista de productos se encuentra vacia", MessageAlerts.MessageType.ERROR);
                return;
            }
            if (detalles.isEmpty()) {
                detalles = "Ver detalles";
            }
            new CompraDAO().persistirEntidad(new Compra(date, aux, listaProductos, cantidadComprada, detalles, total));
            MessageAlerts.getInstance().showMessage("Compra exitosa", "La compra fue realizada correctamente a continuacion se imprimira el recibo", MessageAlerts.MessageType.SUCCESS);
            stockProductosRestar(listaProductos);
        } catch (Exception e) {
            System.out.println("Error en la clase persistirEntidad de la clase CompraDAO");
        }
    }

    public void actualizarEntidad(int id, Date date, Cliente aux, List<Productos> listaProductos, String detalles, double total) {
        try {
            new CompraDAO().actualizarEntidad(new Compra(id, date, aux, listaProductos, detalles, total));
            System.out.println("Se actualizo con exitos");
        } catch (Exception e) {
            System.out.println("Error en el metodo actualizarEntidad() de la clase CompraServices");
        }
    }

    public void borrarEntidad(Compra aux) {
        try {
            new CompraDAO().borrarEntidad(aux);
            System.out.println("Se elimino correctamente la compra");
        } catch (Exception e) {
            System.out.println("Error en el metodo BorrarEntidad de la clase CompraServices");
        }
    }

    public List<Compra> listaCompra() {
        try {
            return new CompraDAO().listaCompra();
        } catch (Exception e) {
            System.out.println("Error en el metodo listaCompra de la clase ComprServices");
            return null;
        }
    }

    public List<Compra> listaCompraPorCliente(int id) {
        try {
            return new CompraDAO().listaDeCompraDeXCliente(id);
        } catch (Exception e) {
            System.out.println("Error en el metodo listaCompraPorCliente de la clase ComprServices");
            return null;
        }
    }

    public Compra compraPorID(int id) {
        try {
            return new CompraDAO().compraPorID(id);
        } catch (Exception e) {
            System.out.println("Error en la compraPorID de la compraServices");
            return null;
        }
    }

    //Metodo la cualme descuente el stock de lo comprado a la base de datos
    public void stockProductosRestar(List<Productos> listaProductos) {
        try {
            ProductoServices ps = new ProductoServices();
            for (Productos aux : listaProductos) {
                Productos index = ps.buscarProductoPorID(aux.getId());
                index.setStock(index.getStock() - aux.getStock());
                ps.modificarStock(index);
            }
        } catch (Exception e) {
            System.out.println("Error en la lista de productos del metodo stockProductosRestar de la clase Compra_Form");
        }
    }
}
