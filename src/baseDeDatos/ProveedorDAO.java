/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDeDatos;

import entidades.Proveedor;
import java.util.List;

/**
 *
 * @author criss
 */
public final class ProveedorDAO extends DAO<Proveedor> {

    @Override
    public void persistirEntidad(Proveedor object) {
        super.persistirEntidad(object); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void actualizarEntidad(Proveedor object) {
        super.actualizarEntidad(object); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void borrarEntidad(Proveedor object) {
        super.borrarEntidad(object); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public Proveedor buscarProveedorPorID(int id) {
        try {
            conectar();
            return em.find(Proveedor.class, id);
        } catch (Exception e) {
            System.out.println("Error en el metodo buscarProveedorPorID() en la clase proveedorDAO");
        } finally {
            desconectar();
        }
        return null;
    }

    public List<Proveedor> listaProveedores() {
        try {
            conectar();
            return (List<Proveedor>) em.createQuery("Select f From Proveedor f").getResultList();
        } catch (Exception e) {
            System.out.println("Error en el metodo listaProveedores() en la clase ProveedorDAO");
        } finally {
            desconectar();
        }
        return null;
    }

}
