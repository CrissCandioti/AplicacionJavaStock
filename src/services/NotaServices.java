/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import baseDeDatos.NotaDAO;
import entidades.Notas;
import java.util.List;

/**
 *
 * @author criss
 */
public class NotaServices {

    public void persistirNota(String fecha, String nota) {
        try {
            new NotaDAO().persistirEntidad(new Notas(fecha, nota));
            System.out.println("Se agrego correctamente la nota a la base de datos");
        } catch (Exception e) {
            System.out.println("Error en el metodo persistirNota de la clase NotaSerivces");
        }
    }

    public void modificarNota(int id, String fecha, String nota) {
        try {
            new NotaDAO().actualizarEntidad(new Notas(id, fecha, nota));
            System.out.println("Se actualizo correctamente la nota");
        } catch (Exception e) {
            System.out.println("Error al modificar la nota");
        }
    }

    public void borrarNota(Notas aux) {
        try {
            new NotaDAO().borrarEntidad(aux);
            System.out.println("Se elimino con exito la nota");
        } catch (Exception e) {
            System.out.println("Error al eliminar la nota");
        }
    }

    public List<Notas> listaNotas() {
        try {
            return new NotaDAO().listaNotas();
        } catch (Exception e) {
            System.out.println("Error en el metodo listaNota de la clase NotaSerivces");
            return null;
        }
    }

    public Notas buscarNotaPorID(int id) {
        try {
            return new NotaDAO().buscarNotaPorID(id);
        } catch (Exception e) {
            System.out.println("Error en el metodo buscarNotaPorID del metodo notaServices()");
            return null;
        }
    }

}
