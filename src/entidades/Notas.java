/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author criss
 */
public class Notas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fechaMensaje;
    private String nota;

    public Notas() {
    }

    public Notas(String fechaMensaje, String nota) {
        this.fechaMensaje = fechaMensaje;
        this.nota = nota;
    }

    public Notas(int id, String fechaMensaje, String nota) {
        this.id = id;
        this.fechaMensaje = fechaMensaje;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaMensaje() {
        return fechaMensaje;
    }

    public void setFechaMensaje(String fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Notas{" + "id=" + id + ", fechaMensaje=" + fechaMensaje + ", nota=" + nota + '}';
    }

}
