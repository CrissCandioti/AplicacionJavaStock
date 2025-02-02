/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 *
 * @author criss
 */
@Entity
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String variedad;
    private String nombre;
    private Date fechaIngreso;
    private String marca;
    private String tipoProducto;
    private String contenido;
    private int stock;
    private double precioCosto;
    private double precioventa;
    private double ganancias;
    private double porcentajeGanancias;
    @Lob
    private byte[] imagen;
    @ManyToOne
    @JoinTable(
            name = "productos_proveedor", // Nombre de la tabla de relación
            joinColumns = @JoinColumn(name = "productos_id"), // Columna de productos en la tabla de relación
            inverseJoinColumns = @JoinColumn(name = "proveedor_id") // Columna de proveedor en la tabla de relación
    )
    private Proveedor proveedor;
    private String descripcion;

    public Productos() {
    }

    public Productos(int id, String nombre, String contenido, int stock, double precioventa) {
        this.id = id;
        this.nombre = nombre;
        this.contenido = contenido;
        this.stock = stock;
        this.precioventa = precioventa;
    }

    public Productos(String variedad, String nombre, Date fechaIngreso, String marca, String tipoProducto, String contenido, int stock, double precioCosto, double precioventa, double ganancias, double porcentajeGanancias, byte[] imagen, Proveedor proveedor, String descripcion) {
        this.variedad = variedad;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.marca = marca;
        this.tipoProducto = tipoProducto;
        this.contenido = contenido;
        this.stock = stock;
        this.precioCosto = precioCosto;
        this.precioventa = precioventa;
        this.ganancias = ganancias;
        this.porcentajeGanancias = porcentajeGanancias;
        this.imagen = imagen;
        this.proveedor = proveedor;
        this.descripcion = descripcion;
    }

    public Productos(int id, String variedad, String nombre, Date fechaIngreso, String marca, String tipoProducto, String contenido, int stock, double precioCosto, double precioventa, double ganancias, double porcentajeGanancias, byte[] imagen, Proveedor proveedor, String descripcion) {
        this.id = id;
        this.variedad = variedad;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.marca = marca;
        this.tipoProducto = tipoProducto;
        this.contenido = contenido;
        this.stock = stock;
        this.precioCosto = precioCosto;
        this.precioventa = precioventa;
        this.ganancias = ganancias;
        this.porcentajeGanancias = porcentajeGanancias;
        this.imagen = imagen;
        this.proveedor = proveedor;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVariedad() {
        return variedad;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }

    public double getGanancias() {
        return ganancias;
    }

    public void setGanancias(double ganancias) {
        this.ganancias = ganancias;
    }

    public double getPorcentajeGanancias() {
        return porcentajeGanancias;
    }

    public void setPorcentajeGanancias(double porcentajeGanancias) {
        this.porcentajeGanancias = porcentajeGanancias;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public Object[] toTableRow(int rowNum) {
        DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
        return new Object[]{false, rowNum, this, fechaIngreso == null ? "" : df.format(fechaIngreso), marca, tipoProducto, contenido, stock, precioCosto, precioventa, ganancias, porcentajeGanancias, proveedor, descripcion};
    }

    public Object[] toTableRowCompraForm(int rowNum) {
        return new Object[]{false, rowNum, this, contenido, stock, precioventa};
    }
}
