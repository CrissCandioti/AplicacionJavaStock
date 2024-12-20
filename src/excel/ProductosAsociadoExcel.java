/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excel;

import entidades.Proveedor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import services.ProductoServices;
import services.ProveedorServices;

/**
 *
 * @author criss
 */
public class ProductosAsociadoExcel {

    //Metodo para construir el excel del JButton de productosAsociados ubicado en proveedores
    public void productoAsociadoExcel(int id) {

        //Conexion a services
        ProductoServices pros = new ProductoServices();
        ProveedorServices ps = new ProveedorServices();
        Proveedor aux = ps.buscarProveedorPorId(id);
        String index = pros.listaDeProductosDeXProveedor(id).toString();
        //Creamos el archivo Excel
        Workbook book = new XSSFWorkbook();
        //Creamos la pestaña
        Sheet sheet = book.createSheet("ProductosAsociados");

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
            celdaTitulo.setCellValue("Reporte del Proveedor");
            //Indicamos la combinacion de las celdas
            sheet.addMergedRegion(new CellRangeAddress(1, 3, 1, 3));
            /*El primer parametro indica la fila donde inicia
            La segunda indica la ultima fila que va a ocupar
            La tercera la primera columna que va a utilizar
            La cuarta la ultima columna que va a utilizar
             */

            //Continuamos con los titulos que va a contener los reportes
            String[] cabecera = new String[]{"Codigo", "Nombre", "Productos", "Notas"};
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

            //CeldaNombre
            Cell celdaNombre = row1.createCell(1);
            celdaNombre.setCellStyle(headerSyleContenido);
            celdaNombre.setCellValue(aux.getNombre());

            //CeldaProducto
            Cell celdaApellido = row1.createCell(2);
            celdaApellido.setCellStyle(headerSyleContenido);
            celdaApellido.setCellValue(index);

            //CeldaNotas
            Cell celdaNotas = row1.createCell(3);
            celdaNotas.setCellStyle(headerSyleContenido);
            celdaNotas.setCellValue(aux.getNotas());
            //Contenido de nuestro reporte

            //Empezamos a generar el reporte.
            // Usamos JFileChooser para seleccionar la ubicación y el nombre del archivo
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar Archivo Excel");
            fileChooser.setSelectedFile(new File("ReporteProveedor.xlsx")); // Nombre por defecto

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
                    MessageAlerts.getInstance().showMessage("EL Excel no se pudo crear", "Este error se produjo debido a que el excel que se desea sobreescribir esta abierto. Cierrelo e intente nuevamente ", MessageAlerts.MessageType.ERROR);
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

    //Metodo para construir el excel del JButton de la tabla excel ubicado en proveedores
    public void TablaProveedoresExcelReporte() {

        //Conexion a services
        ProductoServices pros = new ProductoServices();
        ProveedorServices ps = new ProveedorServices();
        String index = null;
        List<Proveedor> listaProductos = ps.listaProveedores();
        //Creamos el archivo Excel
        Workbook book = new XSSFWorkbook();
        //Creamos la pestaña
        Sheet sheet = book.createSheet("TablaProveedores");

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
            celdaTitulo.setCellValue("Tabla de los Proveedores");
            //Indicamos la combinacion de las celdas
            sheet.addMergedRegion(new CellRangeAddress(1, 3, 1, 3));
            /*El primer parametro indica la fila donde inicia
            La segunda indica la ultima fila que va a ocupar
            La tercera la primera columna que va a utilizar
            La cuarta la ultima columna que va a utilizar
             */

            //Continuamos con los titulos que va a contener los reportes
            String[] cabecera = new String[]{"Codigo", "Nombre", "Productos", "Notas"};
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

            //Contenido de nuestro reporte
            // Inicializamos el contador de filas a partir de donde comenzarán los datos
            int folaDatos = 6; // La fila donde comienzas a agregar datos

            // Contenido de nuestro reporte
            for (Proveedor aux : listaProductos) {
                Row filaDatos = sheet.createRow(folaDatos++); // Crear nueva fila y luego incrementar filaDatos
                for (int i = 0; i < 4; i++) {//El 9 es por la cantidad de valores de la entidad
                    Cell celdaDatos = filaDatos.createCell(i);
                    celdaDatos.setCellStyle(headerSyleContenido);
                    index = pros.listaDeProductosDeXProveedor(aux.getId()).toString();
                    // Asigna los valores correspondientes según el índice
                    switch (i) {
                        case 0:
                            celdaDatos.setCellValue(aux.getId());
                            break;
                        case 1:
                            celdaDatos.setCellValue(aux.getNombre());
                            break;
                        case 2:
                            celdaDatos.setCellValue(index);
                            break;
                        case 3:
                            celdaDatos.setCellValue(aux.getNotas());
                            break;
                    }
                }
            }
            //Empezamos a generar el reporte.
            // Usamos JFileChooser para seleccionar la ubicación y el nombre del archivo
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar Archivo Excel");
            fileChooser.setSelectedFile(new File("ReporteProveedores.xlsx")); // Nombre por defecto

            // Mostrar el diálogo de guardar
            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                String finalFileName = fileToSave.getAbsolutePath();

                // Verifica si el archivo ya existe
                //Aplicamos la misma logica para la ventana de los form. En usuario Form se muestra correctamente
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
                    MessageAlerts.getInstance().showMessage("EL Excel no se pudo crear", "Este error se produjo debido a que el excel que se desea sobreescribir esta abierto. Cierrelo e intente nuevamente ", MessageAlerts.MessageType.ERROR);
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
