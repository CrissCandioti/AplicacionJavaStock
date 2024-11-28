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
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entidades.Cliente;
import entidades.Productos;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import raven.alerts.MessageAlerts;

/**
 *
 * @author criss
 */
public class CompraPDF {

    //Metodo para imprimir el pdf del presupuesto
    public void pdfPresupuesto(Date fechaYHora, List<Productos> listaProductos, double total) {
        try {
            DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy HH:mm:ss");
            //Logica para guardar-----------------------------------------------
            // Usamos JFileChooser para seleccionar la ubicación y el nombre del archivo
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar PDF del presupuesto");
            fileChooser.setSelectedFile(new File("Presupuesto.pdf")); // Nombre por defecto

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
            documento.open();

            // Agregar imagen de encabezado
            Image header = Image.getInstance("src/com/raven/icon/inicio.png");
            header.scaleToFit(300, 300); // Reducido de 650,1000 a 300,300
            header.setAlignment(Chunk.ALIGN_CENTER);
            documento.add(header);
            
            // Agregar espacio entre imagen y fecha
            documento.add(new Paragraph("\n"));

            // Agregar fecha en esquina superior derecha
            Paragraph fecha = new Paragraph();
            fecha.setAlignment(Paragraph.ALIGN_RIGHT);
            fecha.add(new Chunk("Fecha: " + df.format(fechaYHora),
                    FontFactory.getFont("Tahoma", 12, Font.NORMAL, BaseColor.BLACK)));
            documento.add(fecha);

            // Agregar espacio entre fecha y título
            documento.add(new Paragraph("\n"));

            // Título
            Paragraph titulo = new Paragraph();
            titulo.setAlignment(Paragraph.ALIGN_CENTER);
            titulo.add(new Chunk("Angel Tienda Holística y Esotérica ©\n\n",
                    FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY)));
            titulo.add(new Chunk("Presupuesto\n\n",
                    FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY)));
            documento.add(titulo);

            // Crear tabla de productos
            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);

            // Establecer anchos relativos de las columnas (total debe sumar 100)
            float[] anchos = {35f, 35f, 10f, 20f}; // Stock ahora ocupa solo 10%
            tabla.setWidths(anchos);

            // Encabezados de tabla
            tabla.addCell(new Paragraph("Nombre", FontFactory.getFont("Tahoma", 12, Font.BOLD)));
            tabla.addCell(new Paragraph("Contenido", FontFactory.getFont("Tahoma", 12, Font.BOLD)));
            tabla.addCell(new Paragraph("Stock", FontFactory.getFont("Tahoma", 12, Font.BOLD)));
            tabla.addCell(new Paragraph("Precio", FontFactory.getFont("Tahoma", 12, Font.BOLD)));

            // Agregar productos
            for (Productos producto : listaProductos) {
                tabla.addCell(producto.getNombre());
                tabla.addCell(producto.getContenido());
                tabla.addCell(String.valueOf(producto.getStock()));
                tabla.addCell("$" + String.format("%.2f", producto.getPrecioventa()));
            }
            documento.add(tabla);

            // Agregar total
            Paragraph totalParrafo = new Paragraph();
            totalParrafo.setAlignment(Paragraph.ALIGN_RIGHT);
            totalParrafo.add(new Chunk("\nTotal: $" + String.format("%.2f", total),
                    FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.BLACK)));
            documento.add(totalParrafo);

            documento.close();
            MessageAlerts.getInstance().showMessage("PDF Generado", "El PDF del presupuesto se generó en la ubicación seleccionada: " + finalFileName, MessageAlerts.MessageType.SUCCESS);

        } catch (Exception e) {
            MessageAlerts.getInstance().showMessage("Error", "Error al generar PDF: " + e.getMessage(), MessageAlerts.MessageType.ERROR);
        }
    }
    
    
    //Metodo la cual realiza la facturacion de la compra
    public void facturacionPDF(Cliente aux, Date fechaYHora, List<Productos> listaProductos, double total){
            try {
            DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy HH:mm:ss");
            //Logica para guardar-----------------------------------------------
            // Usamos JFileChooser para seleccionar la ubicación y el nombre del archivo
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar PDF de la facturacion de la compra");
            fileChooser.setSelectedFile(new File("Factura_Compra.pdf"));

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
            documento.open();

            // Agregar fecha en esquina superior derecha
            Paragraph fecha = new Paragraph();
            fecha.setAlignment(Paragraph.ALIGN_RIGHT);
            fecha.add(new Chunk("Fecha: " + df.format(fechaYHora),
                    FontFactory.getFont("Tahoma", 12, Font.NORMAL, BaseColor.BLACK)));
            documento.add(fecha);

            // Agregar espacio
            documento.add(new Paragraph("\n"));

            // Crear tabla para encabezado con logo y título
            PdfPTable headerTable = new PdfPTable(2);
            headerTable.setWidthPercentage(100);
            float[] headerWidths = {30f, 70f};
            headerTable.setWidths(headerWidths);

            // Agregar imagen en la primera celda
            Image header = Image.getInstance("src/com/raven/icon/inicio.png");
            header.scaleToFit(150, 150);
            PdfPCell imageCell = new PdfPCell(header);
            imageCell.setBorder(0);
            headerTable.addCell(imageCell);

            // Agregar título en la segunda celda
            Paragraph titulo = new Paragraph();
            titulo.setAlignment(Paragraph.ALIGN_LEFT);
            titulo.add(new Chunk("Angel Tienda Holística y Esotérica ©\n",
                    FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY)));
            titulo.add(new Chunk("Factura\n",
                    FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY)));
            PdfPCell titleCell = new PdfPCell(titulo);
            titleCell.setBorder(0);
            titleCell.setVerticalAlignment(5);
            headerTable.addCell(titleCell);
            documento.add(headerTable);

            // Agregar espacio
            documento.add(new Paragraph("\n"));

            // Información de contacto
            Paragraph infoContacto = new Paragraph();
            infoContacto.setAlignment(Paragraph.ALIGN_LEFT);
            infoContacto.add(new Chunk("Información de Contacto\n\n",
                    FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY)));
            infoContacto.add(new Chunk("Nombre y Apellido: " + aux.getNombre() + " " + aux.getApellido() + "\n",
                    FontFactory.getFont("Tahoma", 12, Font.NORMAL)));
            infoContacto.add(new Chunk("Documento: " + aux.getDocumento() + "\n",
                    FontFactory.getFont("Tahoma", 12, Font.NORMAL)));
            infoContacto.add(new Chunk("Correo Electrónico: " + aux.getEmail() + "\n",
                    FontFactory.getFont("Tahoma", 12, Font.NORMAL)));
            infoContacto.add(new Chunk("WhatsApp: " + aux.getWhatsapp() + "\n",
                    FontFactory.getFont("Tahoma", 12, Font.NORMAL)));
            infoContacto.add(new Chunk("Localidad: " + aux.getLocalidad() + "\n",
                    FontFactory.getFont("Tahoma", 12, Font.NORMAL)));
            infoContacto.add(new Chunk("Dirección: " + aux.getDireccion() + "\n\n",
                    FontFactory.getFont("Tahoma", 12, Font.NORMAL)));
            documento.add(infoContacto);

            // Crear tabla de productos
            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);

            // Establecer anchos relativos de las columnas (total debe sumar 100)
            float[] anchos = {35f, 35f, 10f, 20f}; // Stock ahora ocupa solo 10%
            tabla.setWidths(anchos);

            // Encabezados de tabla
            tabla.addCell(new Paragraph("Nombre", FontFactory.getFont("Tahoma", 12, Font.BOLD)));
            tabla.addCell(new Paragraph("Contenido", FontFactory.getFont("Tahoma", 12, Font.BOLD)));
            tabla.addCell(new Paragraph("Stock", FontFactory.getFont("Tahoma", 12, Font.BOLD)));
            tabla.addCell(new Paragraph("Precio", FontFactory.getFont("Tahoma", 12, Font.BOLD)));

            // Agregar productos
            for (Productos producto : listaProductos) {
                tabla.addCell(producto.getNombre());
                tabla.addCell(producto.getContenido());
                tabla.addCell(String.valueOf(producto.getStock()));
                tabla.addCell("$" + String.format("%.2f", producto.getPrecioventa()));
            }
            documento.add(tabla);

            // Agregar total
            Paragraph totalParrafo = new Paragraph();
            totalParrafo.setAlignment(Paragraph.ALIGN_RIGHT);
            totalParrafo.add(new Chunk("\nTotal: $" + String.format("%.2f", total),
                    FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.BLACK)));
            documento.add(totalParrafo);

            documento.close();
            MessageAlerts.getInstance().showMessage("PDF Generado", "El PDF de la factura se generó en la ubicación seleccionada: " + finalFileName, MessageAlerts.MessageType.SUCCESS);

        } catch (Exception e) {
            MessageAlerts.getInstance().showMessage("Error", "Error al generar PDF: " + e.getMessage(), MessageAlerts.MessageType.ERROR);
        }
    }
}
