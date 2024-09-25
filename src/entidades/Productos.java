/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    
    private Proveedor proveedor;
    private String descripcion;

//    public Object[] toTableRow(int rowNum) {
//        DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
//        NumberFormat nf = new DecimalFormat("$ #,##0.##");
//        return new Object[]{false, rowNum, this, date == null ? "" : df.format(date), nf.format(salary), positions, description};
//    }
}
