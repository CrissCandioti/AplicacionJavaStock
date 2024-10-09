/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excel;

import entidades.Productos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import services.ProductoServices;

/**
 *
 * @author criss
 */
public class ProductoExcel {
    //Metodo creado para crear el PDF de un producto

    public void excelProductoSeleccionado(int id) {

        //Conexion a services
        ProductoServices ps = new ProductoServices();
        Productos aux = ps.buscarProductoPorID(id);
        //Creamos el archivo Excel
        Workbook book = new XSSFWorkbook();
        //Creamos la pestaña
        Sheet sheet = book.createSheet("Producto");

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
            celdaTitulo.setCellValue("Reporte del Producto");
            //Indicamos la combinacion de las celdas
            sheet.addMergedRegion(new CellRangeAddress(1, 3, 1, 3));
            /*El primer parametro indica la fila donde inicia
            La segunda indica la ultima fila que va a ocupar
            La tercera la primera columna que va a utilizar
            La cuarta la ultima columna que va a utilizar
             */

            //Continuamos con los titulos que va a contener los reportes
            String[] cabecera = new String[]{"Codigo", "Variedad", "Nombre", "Fecha de ingreso", "Marca", "Tipo de producto", "Contenido", "Stock", "Precio costo", "Precio venta", "Ganancia", "Porcentaje ganancia", "Proveedor", "Descripcion"};
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
            //Agregamos el contenido a la tabla desde nuestra base de datos

            Row row1 = sheet.createRow(6);
            //Celda Codigo
            Cell celdaCodigo = row1.createCell(0);
            celdaCodigo.setCellStyle(headerSyleContenido);
            celdaCodigo.setCellValue(aux.getId());

            //Celda Variedad
            Cell celdaVariedad = row1.createCell(1);
            celdaVariedad.setCellStyle(headerSyleContenido);
            celdaCodigo.setCellValue(aux.getVariedad());

            //CeldaNombre
            Cell celdaNombre = row1.createCell(2);
            celdaNombre.setCellStyle(headerSyleContenido);
            celdaNombre.setCellValue(aux.getNombre());

            //CeldaFechaIngreso
            Cell celdaFechaIngreso = row1.createCell(3);
            celdaFechaIngreso.setCellStyle(headerSyleContenido);
            celdaFechaIngreso.setCellValue(aux.getFechaIngreso());

            //CeldaMarca
            Cell celdaMarca = row1.createCell(4);
            celdaMarca.setCellStyle(headerSyleContenido);
            celdaMarca.setCellValue(aux.getMarca());

            //CeldaTipoProducto
            Cell celdaTipoProducto = row1.createCell(5);
            celdaTipoProducto.setCellStyle(headerSyleContenido);
            celdaTipoProducto.setCellValue(aux.getTipoProducto());

            //CeldaContenido
            Cell celdaContenido = row1.createCell(6);
            celdaContenido.setCellStyle(headerSyleContenido);
            celdaContenido.setCellValue(aux.getContenido());

            //CeldaStock
            Cell celdaStock = row1.createCell(7);
            celdaStock.setCellStyle(headerSyleContenido);
            celdaStock.setCellValue(aux.getStock());

            //CeldaPrecioCosto
            Cell celdaPrecioCosto = row1.createCell(8);
            celdaPrecioCosto.setCellStyle(headerSyleContenido);
            celdaPrecioCosto.setCellValue(aux.getPrecioCosto());

            //CeldaPrecioVenta
            Cell celdaPrecioVenta = row1.createCell(9);
            celdaPrecioVenta.setCellStyle(headerSyleContenido);
            celdaPrecioVenta.setCellValue(aux.getTipoProducto());

            //CeldaGanancia
            Cell celdaGanancia = row1.createCell(10);
            celdaGanancia.setCellStyle(headerSyleContenido);
            celdaGanancia.setCellValue(aux.getGanancias());

            //CeldaPorcentajeGanancia
            Cell celdaPorcentajeGanancia = row1.createCell(11);
            celdaPorcentajeGanancia.setCellStyle(headerSyleContenido);
            celdaPorcentajeGanancia.setCellValue(aux.getPorcentajeGanancias());

            //CeldaProveedor
            Cell celdaProveedor = row1.createCell(12);
            celdaProveedor.setCellStyle(headerSyleContenido);
            celdaProveedor.setCellValue(aux.getProveedor().toString());

            //CeldaDescripcion
            Cell celdaDescripcion = row1.createCell(13);
            celdaDescripcion.setCellStyle(headerSyleContenido);
            celdaDescripcion.setCellValue(aux.getDescripcion());

            //CeldaImagen
            Cell celdaImagen = row1.createCell(14);
            celdaImagen.setCellStyle(headerSyleContenido);
            celdaImagen.setCellValue(aux.getDescripcion());
            //Contenido de nuestro reporte
            //Empezamos a generar el reporte.
            // Usamos JFileChooser para seleccionar la ubicación y el nombre del archivo
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar Archivo Excel");
            fileChooser.setSelectedFile(new File("ReporteProducto.xlsx")); // Nombre por defecto

            // Mostrar el diálogo de guardar
            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                String finalFileName = fileToSave.getAbsolutePath();

                // Verifica si el archivo ya existe
                if (fileToSave.exists()) {
                    int overwrite = JOptionPane.showConfirmDialog(null,
                            "El archivo ya existe. ¿Quieres sobrescribirlo?", "Confirmar",
                            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (overwrite != JOptionPane.YES_OPTION) {
                        return; // Si el usuario elige no sobrescribir, salimos
                    }
                }

                try (FileOutputStream fileOut = new FileOutputStream(finalFileName)) {
                    book.write(fileOut);
                    MessageAlerts.getInstance().showMessage("EL Excel se creó correctamente", "El Excel se genero en: " + finalFileName, MessageAlerts.MessageType.SUCCESS);
                } catch (IOException ex) {
                    Logger.getLogger(ClientesExcel.class.getName()).log(Level.SEVERE, null, ex);
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
