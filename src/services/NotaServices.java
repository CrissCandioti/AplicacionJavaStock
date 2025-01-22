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
            NotaDAO dao = new NotaDAO();
            Notas n = new Notas(fecha, nota);
            dao.persistirEntidad(n);
            System.out.println("Se agrego correctamente la nota a la base de datos");
        } catch (Exception e) {
            System.out.println("Error en el metodo persistirNota de la clase NotaSerivces");
        }
    }

    public void modificarNota(int id, String fecha, String nota) {
        try {
            NotaDAO dao = new NotaDAO();
            Notas n = new Notas(id, fecha, nota);
            dao.actualizarEntidad(n);
            System.out.println("Se actualizo correctamente la nota");
        } catch (Exception e) {
            System.out.println("Error al modificar la nota");
        }
    }

    public void borrarNota(Notas aux) {
        try {
            NotaDAO dao = new NotaDAO();
            dao.borrarEntidad(aux);
            System.out.println("Se elimino con exito la nota");
        } catch (Exception e) {
            System.out.println("Error al eliminar la nota");
        }
    }

    public List<Notas> listaNotas() {
        try {
            NotaDAO dao = new NotaDAO();
            return dao.listaNotas();
        } catch (Exception e) {
            System.out.println("Error en el metodo listaNota de la clase NotaSerivces");
        }
        return null;
    }

    public Notas buscarNotaPorID(int id) {
        try {
            NotaDAO dao = new NotaDAO();
            return dao.buscarNotaPorID(id);
        } catch (Exception e) {
            System.out.println("Error en el metodo buscarNotaPorID del metodo notaServices()");
        }
        return null;
    }

}
