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
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private int documento;
    private String email;
    private String whatsapp;
    private String localidad;
    private String direccion;
    private String notas;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, int documento, String email, String whatsapp, String localidad, String direccion, String notas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.email = email;
        this.whatsapp = whatsapp;
        this.localidad = localidad;
        this.direccion = direccion;
        this.notas = notas;
    }

    public Cliente(int id, String nombre, String apellido, int documento, String email, String whatsapp, String localidad, String direccion, String notas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.email = email;
        this.whatsapp = whatsapp;
        this.localidad = localidad;
        this.direccion = direccion;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Object[] toTableRow(int rowNum) {
        try {
            return new Object[]{false, rowNum, this, apellido, documento, email, whatsapp, localidad, notas};
        } catch (Exception e) {
            System.out.println("Error metodo toTableRow de la clase cliente");
        }
        return null;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
