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
   
    public void pdfTablaProveedores() {
        try {

            ClienteServices cs = new ClienteServices();

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

            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(finalFileName));

            Image header = Image.getInstance("src/com/raven/icon/inicio.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Angel Tienda Holística y Esotérica © \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Clientes \n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(9);
            tabla.addCell("Codigo");
            tabla.addCell("Nombre");
            tabla.addCell("Apellido");
            tabla.addCell("N° Documento");
            tabla.addCell("Email");
            tabla.addCell("N° WhatsApp");
            tabla.addCell("Localidad");
            tabla.addCell("Direccion");
            tabla.addCell("Notas");

            for (Cliente aux : cs.listaCliente()) {
                tabla.addCell(String.valueOf(aux.getId()));
                tabla.addCell(aux.getNombre());
                tabla.addCell(aux.getApellido());
                tabla.addCell(String.valueOf(aux.getDocumento()));
                tabla.addCell(aux.getEmail());
                tabla.addCell(aux.getWhatsapp());
                tabla.addCell(aux.getLocalidad());
                tabla.addCell(aux.getDireccion());
                tabla.addCell(aux.getNotas());
            }

            documento.add(tabla);
            documento.close();
            MessageAlerts.getInstance().showMessage("EL PDF se creó correctamente", "El PDF de los clientes se generó en la ubicación seleccionada", MessageAlerts.MessageType.SUCCESS);
        } catch (Exception e) {
            MessageAlerts.getInstance().showMessage("Error al crear el PDF", "Se produjo un error al intentar crear el reporte", MessageAlerts.MessageType.ERROR);
        }
    }

}
