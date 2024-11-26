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
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            documento.add(header);

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
            titulo.add(new Chunk("Angel Tienda Holística y Esotérica ©\n",
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
            MessageAlerts.getInstance().showMessage("PDF Generado", "El PDF del presupuesto se ha generado exitosamente", MessageAlerts.MessageType.SUCCESS);

        } catch (Exception e) {
            MessageAlerts.getInstance().showMessage("Error", "Error al generar PDF: " + e.getMessage(), MessageAlerts.MessageType.ERROR);
        }
    }
}
