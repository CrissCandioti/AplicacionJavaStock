/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDeDatos;

import entidades.Notas;
import java.util.List;

/**
 *
 * @author criss
 */
public final class NotaDAO extends DAO<Notas> {

    @Override
    public void persistirEntidad(Notas object) {
        super.persistirEntidad(object); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void actualizarEntidad(Notas object) {
        super.actualizarEntidad(object); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void borrarEntidad(Notas object) {
        super.borrarEntidad(object); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public List<Notas> listaNotas() {
        try {
            conectar();
            return (List<Notas>) em.createQuery("Select f From Notas f").getResultList();
        } catch (Exception e) {
            System.out.println("Error en el metodo listaNotas() en la clase NotaDAO");
        } finally {
            desconectar();
        }
        return null;
    }

    public Notas buscarNotaPorID(int id) {
        try {
            conectar();
            return em.find(Notas.class, id);
        } catch (Exception e) {
            System.out.println("Error en el metodo buscarNotaPorID de la clase NotaDAO");
        } finally {
            desconectar();
        }
        return null;
    }

}
