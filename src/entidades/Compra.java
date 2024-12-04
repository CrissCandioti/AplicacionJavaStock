/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author criss
 */
@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    @ManyToOne
    @JoinTable(
            name = "compra_cliente", // Nombre de la tabla de relación
            joinColumns = @JoinColumn(name = "compra_id"), // Columna de compra en la tabla de relación
            inverseJoinColumns = @JoinColumn(name = "cliente_id") // Columna de cliente en la tabla de relación
    )
    private Cliente cliente;
    @OneToMany
    @JoinTable(
            name = "compra_productos", // Nombre de la tabla de relación
            joinColumns = @JoinColumn(name = "compra_id"), // Columna de compra en la tabla de relación
            inverseJoinColumns = @JoinColumn(name = "productos_id") // Columna de productos en la tabla de relación
    )

    private List<Productos> listaProductos;
    private List<Integer> cantidadComprada;
    private String detalles;
    private double total;

    public Compra() {
    }

    public Compra(Date date, Cliente cliente, List<Productos> listaProductos, String detalles, double total) {
        this.date = date;
        this.cliente = cliente;
        this.listaProductos = listaProductos;
        this.detalles = detalles;
        this.total = total;
    }

    public Compra(int id, Date date, Cliente cliente, List<Productos> listaProductos, String detalles, double total) {
        this.id = id;
        this.date = date;
        this.cliente = cliente;
        this.listaProductos = listaProductos;
        this.detalles = detalles;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Productos> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<Integer> getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(List<Integer> cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", date=" + date + ", cliente=" + cliente + ", listaProductos=" + listaProductos + ", detalles=" + detalles + ", total=" + total + '}';
    }

    public Object[] toTableRow(int rowNum) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            return new Object[]{rowNum, dateFormat.format(date), listaProductos, total, detalles};
        } catch (Exception e) {
            System.out.println("Error metodo toTableRow de la clase cliente");
        }
        return null;
    }

}
