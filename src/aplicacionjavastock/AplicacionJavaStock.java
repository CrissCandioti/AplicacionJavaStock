/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplicacionjavastock;

import baseDeDatos.CompraDAO;
import entidades.Cliente;
import entidades.Compra;
import entidades.Productos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import services.ClienteServices;
import services.ProductoServices;

/**
 *
 * @author criss
 */
public class AplicacionJavaStock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ClienteServices cs = new ClienteServices();
        ProductoServices ps = new ProductoServices();
        CompraDAO dao = new CompraDAO();
//        Cliente aux = cs.buscarClienteID(13);
//        List<Productos> listaProductos = new ArrayList<>();
//        Productos index = ps.buscarProductoPorID(9);
//        Productos index2 = ps.buscarProductoPorID(5);
//        Productos index3 = ps.buscarProductoPorID(4);
//        listaProductos.add(index);
//        listaProductos.add(index2);
//        listaProductos.add(index3);
//        int total = 500;
//        Date now = new Date();
//        String detalles = "Que grande el pibe";
//        Compra compra = new Compra(now, aux, listaProductos, detalles, total);
//        dao.persistirEntidad(compra);
          System.out.println(dao.listaDeCompraDeXCliente(13));
    }

}
