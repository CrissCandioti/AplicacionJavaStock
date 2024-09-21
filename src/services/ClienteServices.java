/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import baseDeDatos.ClienteDAO;
import entidades.Cliente;
import java.util.List;

/**
 *
 * @author criss
 */
public class ClienteServices {

    public List<Cliente> listaCliente() {
        try {
            ClienteDAO dao = new ClienteDAO();
            return dao.listaCliente();
        } catch (Exception e) {
            System.out.println("Error metodo listaCliente() en la clase ClienteService");
        }
        return null;
    }

    public List<Cliente> busquedaCliente(String search) {
        try {
            ClienteDAO dao = new ClienteDAO();
            return dao.barraBusqueda(search);
        } catch (Exception e) {
            System.out.println("Error metodo busquedaCliente en la clase clienteService");
        }
        return null;
    }
}
