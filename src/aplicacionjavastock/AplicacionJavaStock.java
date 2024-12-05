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
    }

}
