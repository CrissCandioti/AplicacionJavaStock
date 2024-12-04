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
import entidades.Cliente;
import entidades.Compra;
import entidades.Productos;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import raven.alerts.MessageAlerts;
import services.CompraServices;

/**
 *
 * @author criss
 */
public class ClienteCompraPDF {

    //Metodo para imprimir el pdf de compras del cliente seleccionado
    public void pdfPresupuesto(Cliente aux) {
        try {
            CompraServices cs = new CompraServices();
            DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy HH:mm:ss");
            //Logica para guardar-----------------------------------------------
            // Usamos JFileChooser para seleccionar la ubicación y el nombre del archivo
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar PDF del presupuesto");
            fileChooser.setSelectedFile(new File("HistorialDeCompraDelCliente.pdf")); // Nombre por defecto

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
            header.scaleToFit(150, 150); // Reducido de 650,1000 a 150,150
            header.setAlignment(Chunk.ALIGN_CENTER);
            documento.add(header);

            // Agregar espacio entre fecha y título
            documento.add(new Paragraph("\n"));

            // Título
            Paragraph titulo = new Paragraph();
            titulo.setAlignment(Paragraph.ALIGN_CENTER);
            titulo.add(new Chunk("Angel Tienda Holística y Esotérica ©\n\n",
                    FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY)));
            titulo.add(new Chunk("Historial de compra del cliente\n\n",
                    FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY)));
            documento.add(titulo);

            // Agregar nombre del cliente
            Paragraph totalParrafo = new Paragraph();
            totalParrafo.setAlignment(Paragraph.ALIGN_LEFT);
            totalParrafo.add(new Chunk("Nombre del cliente: " + aux.getNombre() + " " + aux.getApellido(),
                    FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.BLACK)));
            documento.add(totalParrafo);

            // Agregar espacio entre nombre del cliente y tabla
            documento.add(new Paragraph("\n"));

            // Crear tabla de productos
            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);

            // Establecer anchos relativos de las columnas (total debe sumar 100)
            float[] anchos = {35f, 35f, 10f, 20f}; // Stock ahora ocupa solo 10%
            tabla.setWidths(anchos);

            // Encabezados de tabla
            tabla.addCell(new Paragraph("Fecha y Hora", FontFactory.getFont("Tahoma", 12, Font.BOLD)));
            tabla.addCell(new Paragraph("Contenido", FontFactory.getFont("Tahoma", 12, Font.BOLD)));
            tabla.addCell(new Paragraph("Total", FontFactory.getFont("Tahoma", 12, Font.BOLD)));
            tabla.addCell(new Paragraph("Detalles", FontFactory.getFont("Tahoma", 12, Font.BOLD)));

            // Agregar compra
            for (Compra compra : cs.listaCompraPorCliente(aux.getId())) {
                tabla.addCell(df.format(compra.getDate()));

                // Crear celda para lista de productos
                StringBuilder productosStr = new StringBuilder();
                int index = 0;
                for (Productos prod : compra.getListaProductos()) {
                    productosStr.append(prod.getNombre())
                            .append(" (")
                            .append(compra.getCantidadComprada().get(index))
                            .append(" unidades)\n");
                    index++;
                }
                tabla.addCell(productosStr.toString());

                tabla.addCell("$" + String.format("%.2f", compra.getTotal()));
                tabla.addCell(compra.getDetalles());
            }
            documento.add(tabla);

            documento.close();
            MessageAlerts.getInstance().showMessage("PDF Generado", "El PDF del historial de compra se generó en la ubicación seleccionada: " + finalFileName, MessageAlerts.MessageType.SUCCESS);

        } catch (Exception e) {
            MessageAlerts.getInstance().showMessage("Error", "Error al generar PDF: " + e.getMessage(), MessageAlerts.MessageType.ERROR);
        }
    }
}
