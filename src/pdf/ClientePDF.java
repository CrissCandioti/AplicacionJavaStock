/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdf;

import javax.swing.*;
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
import java.io.File;
import java.io.FileOutputStream;
import raven.alerts.MessageAlerts;
import services.ClienteServices;

/**
 *
 * @author criss
 */
public class ClientePDF {

    //Metodo para crear la tabla de los cliente
    public void pdfTablaProveedores() {
        try {
            ClienteServices cs = new ClienteServices();
            //Logica para guardar-----------------------------------------------
            // Usamos JFileChooser para seleccionar la ubicación y el nombre del archivo
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar PDF de Clientes");
            fileChooser.setSelectedFile(new File("Tabla_Clientes.pdf")); // Nombre por defecto

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
            header.scaleToFit(150, 150); // Reducido de 900,1000 a 300,300
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add(new Chunk("Angel Tienda Holística y Esotérica ©\n\n",
                    FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY)));
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Clientes \n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            // Crear tabla con 9 columnas
            PdfPTable tabla = new PdfPTable(9);
            tabla.setWidthPercentage(100); // Usar todo el ancho disponible

            // Definir anchos relativos de las columnas (debe sumar 100)
            float[] anchos = {8f, 12f, 12f, 12f, 15f, 10f, 10f, 11f, 10f};
            tabla.setWidths(anchos);

            // Estilo para encabezados
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, BaseColor.BLACK);

            // Agregar encabezados
            tabla.addCell(new Paragraph("Código", headerFont));
            tabla.addCell(new Paragraph("Nombre", headerFont));
            tabla.addCell(new Paragraph("Apellido", headerFont));
            tabla.addCell(new Paragraph("N° Documento", headerFont));
            tabla.addCell(new Paragraph("Email", headerFont));
            tabla.addCell(new Paragraph("N° WhatsApp", headerFont));
            tabla.addCell(new Paragraph("Localidad", headerFont));
            tabla.addCell(new Paragraph("Dirección", headerFont));
            tabla.addCell(new Paragraph("Notas", headerFont));

            // Estilo para el contenido
            Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 9, BaseColor.BLACK);

            // Agregar datos
            for (Cliente aux : cs.listaCliente()) {
                tabla.addCell(new Paragraph(String.valueOf(aux.getId()), contentFont));
                tabla.addCell(new Paragraph(aux.getNombre(), contentFont));
                tabla.addCell(new Paragraph(aux.getApellido(), contentFont));
                tabla.addCell(new Paragraph(String.valueOf(aux.getDocumento()), contentFont));
                tabla.addCell(new Paragraph(aux.getEmail(), contentFont));
                tabla.addCell(new Paragraph(aux.getWhatsapp(), contentFont));
                tabla.addCell(new Paragraph(aux.getLocalidad(), contentFont));
                tabla.addCell(new Paragraph(aux.getDireccion(), contentFont));
                tabla.addCell(new Paragraph(aux.getNotas(), contentFont));
            }

            documento.add(tabla);
            documento.close();
            MessageAlerts.getInstance().showMessage("EL PDF se creó correctamente", "El PDF de los clientes se generó en la ubicación seleccionada: " + finalFileName, MessageAlerts.MessageType.SUCCESS);
        } catch (Exception e) {
            MessageAlerts.getInstance().showMessage("Error al crear el PDF", "Se produjo un error al intentar crear el reporte", MessageAlerts.MessageType.ERROR);
        }
    }

}
