/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excel;

import entidades.Cliente;
import entidades.Compra;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import raven.alerts.MessageAlerts;
import services.ClienteServices;
import services.CompraServices;

/**
 *
 * @author criss
 */
public class HistorialCompraClienteExcel {

    //Metodo creado para crear el excel del historial del clientes
    public void HistorialCompraClienteExcel(Cliente data) {
        //Conexion a services
        CompraServices cs = new CompraServices();
        List<Compra> compras = cs.listaCompraPorCliente(data.getId());
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        //Creamos el archivo Excel
        Workbook book = new XSSFWorkbook();
        //Creamos la pestaña
        Sheet sheet = book.createSheet("HistorialCompra");

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
            celdaTitulo.setCellValue("Historial de compra del cliente: " + data.getNombre() + " " + data.getApellido());
            //Indicamos la combinacion de las celdas
            sheet.addMergedRegion(new CellRangeAddress(1, 3, 1, 3));

            //Continuamos con los titulos que va a contener los reportes
            String[] cabecera = new String[]{"Fecha y Hora", "Productos", "Total", "Detalles"};
            //Creamos el estilo para las celdas del encabezado
            CellStyle headerSyle = book.createCellStyle();
            headerSyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());//Color de relleno
            headerSyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);//Que el relleno sea solido
            //Le estamos agregando la cuadricula a estos bordes
            headerSyle.setBorderBottom(BorderStyle.THIN);
            headerSyle.setBorderLeft(BorderStyle.THIN);
            headerSyle.setBorderRight(BorderStyle.THIN);
            headerSyle.setBorderBottom(BorderStyle.THIN);

            //Le agregamos una fuente a nuestra cabecera
            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerSyle.setFont(font);

            //Agregamos una nueva fila para nuestros encabezados
            Row filaEncabezados = sheet.createRow(5); //Seleccionamos la fila donde se va a ubicar nuestra cabecera
            //Imprimimos el valor de nuestra cabecera a nuestras celdas
            for (int i = 0; i < cabecera.length; i++) {
                //Le agregamos los estilos de la celda por separado
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                //Agregamos el estilo a la celda
                celdaEnzabezado.setCellStyle(headerSyle);
                //Agregamos el arreglo String
                celdaEnzabezado.setCellValue(cabecera[i]);
            }

            //Creamos el estilo para las celdas del contenido
            CellStyle headerSyleContenido = book.createCellStyle();
            //Le estamos agregando la cuadricula a estos bordes
            headerSyleContenido.setBorderBottom(BorderStyle.THIN);
            headerSyleContenido.setBorderLeft(BorderStyle.THIN);
            headerSyleContenido.setBorderRight(BorderStyle.THIN);
            headerSyleContenido.setBorderBottom(BorderStyle.THIN);

            // Inicializamos el contador de filas a partir de donde comenzarán los datos
            int filaDatos = 6; // La fila donde comienzan los datos

            // Contenido de nuestro reporte
            for (Compra compra : compras) {
                Row fila = sheet.createRow(filaDatos++);
                
                // Fecha y hora
                Cell celdaFecha = fila.createCell(0);
                celdaFecha.setCellStyle(headerSyleContenido);
                celdaFecha.setCellValue(df.format(compra.getDate()));
                
                // Productos y cantidades
                Cell celdaProductos = fila.createCell(1);
                celdaProductos.setCellStyle(headerSyleContenido);
                StringBuilder productos = new StringBuilder();
                for (int i = 0; i < compra.getListaProductos().size(); i++) {
                    productos.append(compra.getListaProductos().get(i).getNombre())
                            .append(" (")
                            .append(compra.getCantidadComprada().get(i))
                            .append(" unidades)\n");
                }
                celdaProductos.setCellValue(productos.toString());
                
                // Total
                Cell celdaTotal = fila.createCell(2);
                celdaTotal.setCellStyle(headerSyleContenido);
                celdaTotal.setCellValue("$" + String.format("%.2f", compra.getTotal()));
                
                // Detalles
                Cell celdaDetalles = fila.createCell(3);
                celdaDetalles.setCellStyle(headerSyleContenido);
                celdaDetalles.setCellValue(compra.getDetalles());
            }

            // Ajustar el ancho de las columnas automáticamente
            for (int i = 0; i < cabecera.length; i++) {
                sheet.autoSizeColumn(i);
            }

            //Empezamos a generar el reporte.
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar Archivo Excel");
            fileChooser.setSelectedFile(new File("HistorialCompra_" + data.getNombre() + "_" + data.getApellido() + ".xlsx"));

            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                String finalFileName = fileToSave.getAbsolutePath();

                if (fileToSave.exists()) {
                    int overwrite = JOptionPane.showConfirmDialog(null,
                            "El archivo ya existe. ¿Quieres sobrescribirlo?", "Confirmar",
                            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (overwrite != JOptionPane.YES_OPTION) {
                        return;
                    }
                }

                try (FileOutputStream fileOut = new FileOutputStream(finalFileName)) {
                    book.write(fileOut);
                    MessageAlerts.getInstance().showMessage("Excel creado correctamente", "El Excel se generó en: " + finalFileName, MessageAlerts.MessageType.SUCCESS);
                } catch (IOException ex) {
                    MessageAlerts.getInstance().showMessage("Error al crear Excel", "El archivo Excel que intenta sobrescribir está abierto. Ciérrelo e intente nuevamente", MessageAlerts.MessageType.ERROR);
                }
            } else {
                System.out.println("Operación de guardado cancelada por el usuario.");
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClientesExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClientesExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
