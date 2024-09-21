/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplicacionjavastock;

import baseDeDatos.ClienteDAO;
import entidades.Cliente;

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
                Cliente c = new Cliente("s", "S", 0, "S", "S", "D", "S", "S");
        ClienteDAO dao = new ClienteDAO();
        dao.persistirEntidad(c);
    }
    
}
