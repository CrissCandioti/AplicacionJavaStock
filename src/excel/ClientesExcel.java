/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author criss
 */
public class ClientesExcel {

    public static void main(String[] args) {
        // TODO code application logic here
        ClientesExcelReporte();
    }

    public static void ClientesExcelReporte() {

        //Creamos el archivo Excel
        Workbook book = new XSSFWorkbook();
        //Creamos la pestaña
        Sheet sheet = book.createSheet("Clientes");

        try {
            //Agregamos una imagen
            InputStream is = new FileInputStream("src\\com\\raven\\icon\\Logo Angel 1.png");
            //Traemos la imagen
            byte[] bytes = IOUtils.toByteArray(is);
            //Traemos el index de la imagen
            int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            //Cerramos el inputStream
            is.close();

            //Ahora agregamos esta imagen a nuestro archivo
            CreationHelper help = book.getCreationHelper();
            Drawing draw = sheet.createDrawingPatriarch();//Para poder cargar la imagen
            //Sacamos el ancho de esta imagen para colocarla de forma correcta
            ClientAnchor anchor = help.createClientAnchor();
            //Le vamos a indicar en donde se posiciona la imagen, en que columna
            anchor.setCol1(0);
            anchor.setRow1(1);

            //Para crear la imagen
            Picture pict = draw.createPicture(anchor, imgIndex);
            //Cambiamos el tamaño
            pict.resize(1, 3);//El parametro donde va a empezar; y cuanto va a consumir de espacio

            //Contenido de nuestro reporte
            //Estilo de nuestro titulo
            CellStyle tituloEstilo = book.createCellStyle();
            //Seteamos la ubicacion de nuestro titulo para que este centrado tanto verticalmente como horizontalmente
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            //Tipo de fuente
            Font fuenteTitulo = book.createFont();
            //Que tipo de fuente va hacer
            fuenteTitulo.setFontName("Arial");
            //Que sea negrita
            fuenteTitulo.setBold(true);
            //Indicamos el tamaño
            fuenteTitulo.setFontHeightInPoints((short) 14);//Acepta un tipo de dato short
            //Se lo asignamis al estilo
            tituloEstilo.setFont(fuenteTitulo);
            //Creamos la fila donde va a estar el titulo
            Row filaTitulo = sheet.createRow(1);
            //Rango de celdas combinadas
            Cell celdaTitulo = filaTitulo.createCell(1);
            //A la celda le agregamos el estilo
            celdaTitulo.setCellStyle(tituloEstilo);
            //Agregamos el contenido de esta celda
            celdaTitulo.setCellValue("Reporte del Cliente");
            //Indicamos la combinacion de las celdas
            sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 3));
            /*El primer parametro indica la fila donde inicia
            La segunda indica la ultima fila que va a ocupar
            La tercera la primera columna que va a utilizar
            La cuarta la ultima columna que va a utilizar
             */
            //Contenido de nuestro reporte

            //Empezamos a generar el reporte.
            FileOutputStream fileOut = new FileOutputStream("ReporteCliente.xlsx");
            book.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClientesExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClientesExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
