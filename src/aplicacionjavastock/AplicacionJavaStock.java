/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplicacionjavastock;

import baseDeDatos.CompraDAO;
import entidades.Cliente;
import entidades.Compra;
import entidades.Productos;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import services.ClienteServices;
import services.CompraServices;
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
        CompraServices cs = new CompraServices();
        ClienteServices css = new ClienteServices();
        ProductoServices ps = new ProductoServices();
        CompraDAO dao = new CompraDAO();
        Cliente c = css.buscarClienteID(1);
        Productos p = ps.buscarProductoPorID(1);
        List<Productos> listap= new ArrayList<>();
        listap.add(p);
        Date now = new Date();
        List<Integer> cantidad = new ArrayList<>();
        cantidad.add(30);
        Compra cc = new Compra(now, c, listap, "hola", 1);
        cc.setCantidadComprada(cantidad);
        dao.persistirEntidad(cc);
    }

}
