/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplicacionjavastock;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author criss
 */
public class AplicacionJavaStock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        create();
    }

    //Metodo para crear el Excel
    private static void create() {
        //Creamos un archivo en Excel
        Workbook book = new XSSFWorkbook();
        //Creamos una nueva pestaña
        Sheet sheet = book.createSheet("hola java");//A esta pestaña le damos un nombre
        //Le agregamos contenido a nuestro excel
        //Necesariamente necesitamos crear una fila y dentro de esa fila crear columnas para colocar los valores
        //Creamos la fila primero
        Row row = sheet.createRow(0);//Y le indicamos el valor de la fila
        //Ya que tenemos la fila creada, creamos la celda
        row.createCell(0).setCellValue("Hola joni");//Le indicamos la posicion de la celda en este caso cero y el siguiente 1, asi susesivamente
        row.createCell(1).setCellValue(7.5);//Valos double
        row.createCell(2).setCellValue(true);//Valor boolean

        //Podemos crear la celda separado para mejor diseño e informacion
        Cell celda = row.createCell(3);
        //Podemos agregar una formula a una celda
        celda.setCellFormula(String.format("1+1", ""));//El primer dato es la formula y el otro son los campos

        //Creamos otra fila
        Row rowuno = sheet.createRow(1);
        //Creamos las celdas rapidamente
        rowuno.createCell(0).setCellValue(7);
        rowuno.createCell(1).setCellValue(8);

        //Creamos una celda por separado y la agregamos a la fila
        Cell celdados = rowuno.createCell(2);
//      celdados.setCellFormula(String.format("A2+B2", ""));
        //Si los valores son dinamicos constantemente
        celdados.setCellFormula(String.format("A%d+B%d", 2,2));//El signo de porcentajo indica que va a recibir el parametro
        try {
            //Ya que creamos los archivos ahora lo guardamos
            FileOutputStream fileout = new FileOutputStream("Excel.xlsx");//Le agregamos el nombre y ademas la extension
            //Impactamos directamente en el archivo excel creado
            book.write(fileout);
            //Cerramos el archivo
            fileout.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AplicacionJavaStock.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AplicacionJavaStock.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
