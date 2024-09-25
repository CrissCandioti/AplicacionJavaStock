/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author criss
 */
@Entity
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String notas;

    public Proveedor() {
    }

    public Proveedor(String nombre, String notas) {
        this.nombre = nombre;
        this.notas = notas;
    }

    public Proveedor(int id, String nombre, String notas) {
        this.id = id;
        this.nombre = nombre;
        this.notas = notas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return nombre;
    }

    //No olvidar en este metodo en la frase "Aqui van los productos", vamos a agregar una logica que traiga los productos por medio del id
    public Object[] toTableRow(int rowNum) {
        try {
            return new Object[]{false, rowNum, this, "Aqui van los productos", notas};
        } catch (Exception e) {
            System.out.println("Error metodo toTableRow de la clase proveedor");
        }
        return null;
    }

}
