/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDeDatos;

import entidades.Compra;
import java.util.List;

/**
 *
 * @author criss
 */
public final class CompraDAO extends DAO<Compra> {

    @Override
    public void persistirEntidad(Compra object) {
        super.persistirEntidad(object); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void actualizarEntidad(Compra object) {
        super.actualizarEntidad(object); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void borrarEntidad(Compra object) {
        super.borrarEntidad(object); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    /**
     * El JOIN FETCH se utiliza para que JPA haga una unión con la lista de
     * productos de la compra, cargando todo en una única consulta. Esto
     * previene el comportamiento perezoso (lazy loading) de las relaciones, que
     * puede causar que la lista de productos no se cargue correctamente en
     * algunos contextos.
     */
    /**
     * DISTINCT asegura que cada instancia de Compra aparezca solo una vez en la
     * lista de resultados, eliminando las repeticiones causadas por el JOIN.
     */
    public List<Compra> listaCompra() {
        try {
            conectar();
            List<Compra> compras = em.createQuery("SELECT DISTINCT c FROM Compra c JOIN FETCH c.listaProductos", Compra.class).getResultList();
            return compras;
        } catch (Exception e) {
            System.out.println("Error en el metodo listaCompra de la clase CompraDAO");
        } finally {
            desconectar();
        }
        return null;
    }

    public List<Compra> listaDeCompraDeXCliente(int id) {
        try {
            conectar();
            List<Compra> compras = em.createQuery("SELECT DISTINCT c FROM Compra c JOIN FETCH c.listaProductos WHERE c.cliente.id = :id", Compra.class)
                    .setParameter("id", id)
                    .getResultList();
            return compras;
        } catch (Exception e) {
            System.out.println("Error en el metodo listaDeProductosDeXProveedor() de la clase CompraDAO");
        } finally {
            desconectar();
        }
        return null;
    }

}
