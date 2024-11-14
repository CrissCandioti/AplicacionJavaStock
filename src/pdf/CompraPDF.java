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
import entidades.Compra;
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
    public void pdfPresupuesto(Date fechaYHora, List<Productos> listaProductos, int total) {
        try {
            DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
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
            //Logica para guardar-----------------------------------------------
            //-------------------------------------------------------------------------------------------------------
            Image header = Image.getInstance("src/com/raven/icon/inicio.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Angel Tienda Holística y Esotérica © \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Presupuesto \n\n");

            Paragraph texto = new Paragraph();
            texto.setAlignment(Paragraph.ALIGN_LEFT);

            Chunk CODIGO = new Chunk("Fecha y Hora:", FontFactory.getFont("Tahoma", 10, Font.BOLD | Font.UNDERLINE, BaseColor.DARK_GRAY));
            Chunk TOTAL = new Chunk("TOTAL:", FontFactory.getFont("Tahoma", 10, Font.BOLD | Font.UNDERLINE, BaseColor.DARK_GRAY));
//-------------------------------------------------------------------------------------------------------
            texto.add(CODIGO);
            texto.add(" " + df.format(fechaYHora) + "\n\n");

            texto.add(TOTAL);
            texto.add(" " + total + "\n\n");

//-------------------------------------------------------------------------------------------------------
//TABLA
//-------------------------------------------------------------------------------------------------------
            PdfPTable tabla = new PdfPTable(14);
            tabla.addCell("Codigo");
            tabla.addCell("Variedad");
            tabla.addCell("Nombre");
            tabla.addCell("FechaIngreso");

            for (Productos aux : listaProductos) {
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
//-------------------------------------------------------------------------------------------------------
            documento.open();
            documento.add(header);
            documento.add(parrafo);
            documento.add(texto);
            documento.add(tabla);

            documento.close();
            MessageAlerts.getInstance().showMessage("EL PDF se creó correctamente", "El PDF se genero en: " + finalFileName, MessageAlerts.MessageType.SUCCESS);
        } catch (Exception e) {
            MessageAlerts.getInstance().showMessage("Error al crear el PDF", "Se produjo un error al intentar crear el reporte", MessageAlerts.MessageType.ERROR);
        }
    }
}
