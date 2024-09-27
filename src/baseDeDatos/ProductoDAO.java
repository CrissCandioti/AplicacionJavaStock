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

}
