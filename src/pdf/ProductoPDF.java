/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entidades.Productos;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import raven.alerts.MessageAlerts;
import services.ProductoServices;

/**
 *
 * @author Fabian A. Candioti
 */
public class ProductoPDF {

    public void pdfPorProducto(int id) {
        try {
            ProductoServices ps = new ProductoServices();
            Productos aux = ps.buscarProductoPorID(id);
            byte[] imagenBytes = aux.getImagen(); // Suponiendo que este método devuelve el arreglo de bytes
            // Crear una imagen a partir de los bytes
            Image imagen = Image.getInstance(imagenBytes);
            // Ajustar el tamaño y alineación de la imagen
            imagen.scaleToFit(200, 200);
            imagen.setAlignment(Chunk.ALIGN_CENTER);
            //Logica para guardar-----------------------------------------------
            // Usamos JFileChooser para seleccionar la ubicación y el nombre del archivo
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar PDF del producto asociado");
            fileChooser.setSelectedFile(new File("Producto.pdf")); // Nombre por defecto

            // Mostrar el diálogo de guardar
            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection != JFileChooser.APPROVE_OPTION) {
                System.out.println("Operación de guardado cancelada por el usuario.");
                return; // Salir si el usuario cancela
            }

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
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(finalFileName));
            //Logica para guardar-----------------------------------------------
            //-------------------------------------------------------------------------------------------------------
            Image header = Image.getInstance("src/com/raven/icon/inicio.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Angel Tienda Holística y Esotérica © \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Producto \n\n");

            Paragraph texto = new Paragraph();
            texto.setAlignment(Paragraph.ALIGN_LEFT);

            Chunk CODIGO = new Chunk("CODIGO:", FontFactory.getFont("Tahoma", 10, Font.BOLD | Font.UNDERLINE, BaseColor.DARK_GRAY));
            Chunk VARIEDAD = new Chunk("VARIEDAD:", FontFactory.getFont("Tahoma", 10, Font.BOLD | Font.UNDERLINE, BaseColor.DARK_GRAY));
            Chunk NOMBRE = new Chunk("NOMBRE:", FontFactory.getFont("Tahoma", 10, Font.BOLD | Font.UNDERLINE, BaseColor.DARK_GRAY));
            Chunk MARCA = new Chunk("MARCA:", FontFactory.getFont("Tahoma", 10, Font.BOLD | Font.UNDERLINE, BaseColor.DARK_GRAY));
            Chunk TIPOPRODUCTO = new Chunk("TIPO PRODUCTO:", FontFactory.getFont("Tahoma", 10, Font.BOLD | Font.UNDERLINE, BaseColor.DARK_GRAY));
            Chunk CONTENIDO = new Chunk("TCONTENIDO:", FontFactory.getFont("Tahoma", 10, Font.BOLD | Font.UNDERLINE, BaseColor.DARK_GRAY));
            Chunk STOCK = new Chunk("STOCK:", FontFactory.getFont("Tahoma", 10, Font.BOLD | Font.UNDERLINE, BaseColor.DARK_GRAY));
            Chunk PRECIOCOSTO = new Chunk("PRECIO COSTO:", FontFactory.getFont("Tahoma", 10, Font.BOLD | Font.UNDERLINE, BaseColor.DARK_GRAY));
            Chunk PRECIOVENTA = new Chunk("PRECIO VENTA:", FontFactory.getFont("Tahoma", 10, Font.BOLD | Font.UNDERLINE, BaseColor.DARK_GRAY));
            Chunk GANANCIAS = new Chunk("GANANCIAS:", FontFactory.getFont("Tahoma", 10, Font.BOLD | Font.UNDERLINE, BaseColor.DARK_GRAY));
            Chunk PORCENTAJEGANANCIA = new Chunk("PORCENTAJE GANANCIA:", FontFactory.getFont("Tahoma", 10, Font.BOLD | Font.UNDERLINE, BaseColor.DARK_GRAY));
            Chunk PROVEEDOR = new Chunk("PROVEEDOR:", FontFactory.getFont("Tahoma", 10, Font.BOLD | Font.UNDERLINE, BaseColor.DARK_GRAY));
            Chunk DESCRIPCION = new Chunk("DESCRIPCION:", FontFactory.getFont("Tahoma", 10, Font.BOLD | Font.UNDERLINE, BaseColor.DARK_GRAY));
//-------------------------------------------------------------------------------------------------------
            texto.add(CODIGO);
            texto.add(" " + aux.getId() + "\n\n");

            texto.add(VARIEDAD);
            texto.add(" " + aux.getVariedad() + "\n\n");

            texto.add(NOMBRE);
            texto.add(" " + aux.getNombre() + "\n\n");

            texto.add(MARCA);
            texto.add(" " + aux.getMarca() + "\n\n");

            texto.add(TIPOPRODUCTO);
            texto.add(" " + aux.getTipoProducto() + "\n\n");

            texto.add(CONTENIDO);
            texto.add(" " + aux.getContenido() + "\n\n");

            texto.add(STOCK);
            texto.add(" " + aux.getStock() + "\n\n");

            texto.add(PRECIOCOSTO);
            texto.add(" " + aux.getPrecioCosto() + "\n\n");

            texto.add(PRECIOVENTA);
            texto.add(" " + aux.getPrecioventa() + "\n\n");

            texto.add(GANANCIAS);
            texto.add(" " + aux.getGanancias() + "\n\n");

            texto.add(PORCENTAJEGANANCIA);
            texto.add(" " + aux.getPorcentajeGanancias() + "\n\n");

            texto.add(PROVEEDOR);
            texto.add(" " + aux.getProveedor().toString() + "\n\n");

            texto.add(DESCRIPCION);
            texto.add(" " + aux.getDescripcion() + "\n\n");
//-------------------------------------------------------------------------------------------------------
            documento.open();
            documento.add(header);
            documento.add(parrafo);
            documento.add(imagen);
            documento.add(texto);

            documento.close();
            MessageAlerts.getInstance().showMessage("EL PDF se creó correctamente", "El PDF se genero en: " + finalFileName, MessageAlerts.MessageType.SUCCESS);
        } catch (Exception e) {
            MessageAlerts.getInstance().showMessage("Error al crear el PDF", "Se produjo un error al intentar crear el reporte", MessageAlerts.MessageType.ERROR);
        }
    }

    public void pdfTablaProductos() {
        try {

            ProductoServices pros = new ProductoServices();
            //Logica para guardar-----------------------------------------------
            // Usamos JFileChooser para seleccionar la ubicación y el nombre del archivo
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar PDF de la tabla productos");
            fileChooser.setSelectedFile(new File("Tabla_Productos.pdf")); // Nombre por defecto

            // Mostrar el diálogo de guardar
            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection != JFileChooser.APPROVE_OPTION) {
                System.out.println("Operación de guardado cancelada por el usuario.");
                return; // Salir si el usuario cancela
            }

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
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(finalFileName));
            //Logica para guardar-----------------------------------------------
            Image header = Image.getInstance("src/com/raven/icon/inicio.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Angel Tienda Holística y Esotérica © \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Productos \n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(14);
            tabla.addCell("Codigo");
            tabla.addCell("Variedad");
            tabla.addCell("Nombre");
            tabla.addCell("FechaIngreso");

            for (Productos aux : pros.listaProductos()) {
                DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
                tabla.addCell(String.valueOf(aux.getId()));
                tabla.addCell(aux.getVariedad());
                tabla.addCell(aux.getNombre());
                tabla.addCell(df.format(aux.getFechaIngreso()));
                tabla.addCell(aux.getMarca());
                tabla.addCell(aux.getTipoProducto());
                tabla.addCell(aux.getContenido());
                tabla.addCell(String.valueOf(aux.getStock()));
                tabla.addCell(String.valueOf(aux.getPrecioCosto()));
                tabla.addCell(String.valueOf(aux.getPrecioventa()));
                tabla.addCell(String.valueOf(aux.getGanancias()));
                tabla.addCell(String.valueOf(aux.getPorcentajeGanancias()));
                tabla.addCell(aux.getProveedor().toString());
                tabla.addCell(aux.getDescripcion());
            }
            documento.add(tabla);
            documento.close();
            MessageAlerts.getInstance().showMessage("EL PDF se creo correctamente", "El PDF de la tabla de los productos se genero correctamente en: " + finalFileName, MessageAlerts.MessageType.SUCCESS);
        } catch (Exception e) {
            MessageAlerts.getInstance().showMessage("Error al crear el PDF", "Se produjo un error al intentar crear el reporte", MessageAlerts.MessageType.ERROR);
        }
    }

}
