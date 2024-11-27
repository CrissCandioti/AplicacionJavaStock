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

    //Metodo la cual crea el pdf del producto
    public void pdfPorProducto(int id) {
        try {
            ProductoServices ps = new ProductoServices();
            Productos aux = ps.buscarProductoPorID(id);
            byte[] imagenBytes = aux.getImagen(); // Suponiendo que este método devuelve el arreglo de bytes
            // Crear una imagen a partir de los bytes
            Image imagen = Image.getInstance(imagenBytes);
            // Ajustar el tamaño y alineación de la imagen
            imagen.scaleToFit(150, 150); // Reducido de 200x200 a 150x150
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
            header.scaleToFit(300, 300); // Reducido de 650x1000 a 300x300
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

    //Metodo la cual crea una tabla con todos los productos
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
            // Crear documento en orientación horizontal
            Document documento = new Document(com.itextpdf.text.PageSize.A4.rotate());
            PdfWriter.getInstance(documento, new FileOutputStream(finalFileName));
            //Logica para guardar-----------------------------------------------
            Image header = Image.getInstance("src/com/raven/icon/inicio.png");
            header.scaleToFit(200, 200); // Reducido de 900x1000 a 200x200
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
            tabla.setWidthPercentage(100); // Usar todo el ancho disponible
            
            // Estilo para encabezados
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, BaseColor.BLACK);
            
            tabla.addCell(new Paragraph("Código", headerFont));
            tabla.addCell(new Paragraph("Variedad", headerFont));
            tabla.addCell(new Paragraph("Nombre", headerFont));
            tabla.addCell(new Paragraph("Fecha Ingreso", headerFont));
            tabla.addCell(new Paragraph("Marca", headerFont));
            tabla.addCell(new Paragraph("Tipo Producto", headerFont));
            tabla.addCell(new Paragraph("Contenido", headerFont));
            tabla.addCell(new Paragraph("Stock", headerFont));
            tabla.addCell(new Paragraph("Precio Costo", headerFont));
            tabla.addCell(new Paragraph("Precio Venta", headerFont));
            tabla.addCell(new Paragraph("Ganancias", headerFont));
            tabla.addCell(new Paragraph("% Ganancia", headerFont));
            tabla.addCell(new Paragraph("Proveedor", headerFont));
            tabla.addCell(new Paragraph("Descripción", headerFont));

            // Estilo para el contenido
            Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 9, BaseColor.BLACK);

            for (Productos aux : pros.listaProductos()) {
                DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
                tabla.addCell(new Paragraph(String.valueOf(aux.getId()), contentFont));
                tabla.addCell(new Paragraph(aux.getVariedad(), contentFont));
                tabla.addCell(new Paragraph(aux.getNombre(), contentFont));
                tabla.addCell(new Paragraph(df.format(aux.getFechaIngreso()), contentFont));
                tabla.addCell(new Paragraph(aux.getMarca(), contentFont));
                tabla.addCell(new Paragraph(aux.getTipoProducto(), contentFont));
                tabla.addCell(new Paragraph(aux.getContenido(), contentFont));
                tabla.addCell(new Paragraph(String.valueOf(aux.getStock()), contentFont));
                tabla.addCell(new Paragraph(String.valueOf(aux.getPrecioCosto()), contentFont));
                tabla.addCell(new Paragraph(String.valueOf(aux.getPrecioventa()), contentFont));
                tabla.addCell(new Paragraph(String.valueOf(aux.getGanancias()), contentFont));
                tabla.addCell(new Paragraph(String.valueOf(aux.getPorcentajeGanancias()), contentFont));
                tabla.addCell(new Paragraph(aux.getProveedor().toString(), contentFont));
                tabla.addCell(new Paragraph(aux.getDescripcion(), contentFont));
            }
            documento.add(tabla);
            documento.close();
            MessageAlerts.getInstance().showMessage("EL PDF se creó correctamente", "El PDF de la tabla de los productos se generó correctamente en: " + finalFileName, MessageAlerts.MessageType.SUCCESS);
        } catch (Exception e) {
            MessageAlerts.getInstance().showMessage("Error al crear el PDF", "Se produjo un error al intentar crear el reporte", MessageAlerts.MessageType.ERROR);
        }
    }

}
