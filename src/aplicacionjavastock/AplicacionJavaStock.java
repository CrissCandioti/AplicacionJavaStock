/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplicacionjavastock;

import baseDeDatos.CompraDAO;
import entidades.Compra;
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
        System.out.println(dao.barraBusquedaDeCompras("cris"));
    }

}
