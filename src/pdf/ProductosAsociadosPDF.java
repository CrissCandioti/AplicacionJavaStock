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
import entidades.Proveedor;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import raven.alerts.MessageAlerts;
import services.ProductoServices;
import services.ProveedorServices;

/**
 *
 * @author criss
 */
public class ProductosAsociadosPDF {

    public void pdfPorPaciente(int id) {
        try {
            ProductoServices pros = new ProductoServices();
            ProveedorServices ps = new ProveedorServices();
            Proveedor aux = ps.buscarProveedorPorId(id);
            String index = pros.listaDeProductosDeXProveedor(id).toString();

            //Logica para guardar-----------------------------------------------
            // Usamos JFileChooser para seleccionar la ubicación y el nombre del archivo
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar PDF del producto asociado");
            fileChooser.setSelectedFile(new File("Producto_Asociado.pdf")); // Nombre por defecto

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
            header.scaleToFit(300, 300); // Reducido de 650,1000 a 300,300
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add(new Chunk("Angel Tienda Holística y Esotérica ©\n\n",
                    FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY)));
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Proveedor \n\n");

            Paragraph texto = new Paragraph();
            texto.setAlignment(Paragraph.ALIGN_LEFT);

            Chunk CODIGO = new Chunk("CODIGO:", FontFactory.getFont("Tahoma", 10, Font.BOLD | Font.UNDERLINE, BaseColor.DARK_GRAY));
            Chunk NOMBRE = new Chunk("NOMBRE:", FontFactory.getFont("Tahoma", 10, Font.BOLD | Font.UNDERLINE, BaseColor.DARK_GRAY));
            Chunk PRODUCTOS = new Chunk("PRODUCTOS:", FontFactory.getFont("Tahoma", 10, Font.BOLD | Font.UNDERLINE, BaseColor.DARK_GRAY));
            Chunk NOTAS = new Chunk("NOTAS:", FontFactory.getFont("Tahoma", 10, Font.BOLD | Font.UNDERLINE, BaseColor.DARK_GRAY));
//-------------------------------------------------------------------------------------------------------
            texto.add(CODIGO);
            texto.add(" " + aux.getId() + "\n\n");

            texto.add(NOMBRE);
            texto.add(" " + aux.getNombre() + "\n\n");

            texto.add(PRODUCTOS);
            texto.add(" " + index + "\n\n");

            texto.add(NOTAS);
            texto.add(" " + aux.getNotas() + "\n\n");
//-------------------------------------------------------------------------------------------------------
            documento.open();
            documento.add(header);
            documento.add(parrafo);
            documento.add(texto);

            documento.close();
            MessageAlerts.getInstance().showMessage("EL PDF se creó correctamente", "El PDF se genero en: " + finalFileName, MessageAlerts.MessageType.SUCCESS);
        } catch (Exception e) {
            MessageAlerts.getInstance().showMessage("Error al crear el PDF", "Se produjo un error al intentar crear el reporte", MessageAlerts.MessageType.ERROR);
        }
    }

    public void pdfTablaProveedores() {
        try {
            ProductoServices pros = new ProductoServices();
            ProveedorServices ps = new ProveedorServices();
            String index = null;
            //Logica para guardar-----------------------------------------------
            // Usamos JFileChooser para seleccionar la ubicación y el nombre del archivo
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar PDF de la tabla proveedores");
            fileChooser.setSelectedFile(new File("Tabla_Proveedores.pdf")); // Nombre por defecto

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
            header.scaleToFit(300, 300); // Reducido de 900,1000 a 300,300
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add(new Chunk("Angel Tienda Holística y Esotérica ©\n\n",
                    FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY)));
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Proveedores \n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100); // Usar todo el ancho disponible

            // Establecer anchos relativos de las columnas
            float[] anchos = {10f, 20f, 50f, 20f};
            tabla.setWidths(anchos);

            // Estilo para encabezados
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);

            tabla.addCell(new Paragraph("Código", headerFont));
            tabla.addCell(new Paragraph("Nombre", headerFont));
            tabla.addCell(new Paragraph("Productos", headerFont));
            tabla.addCell(new Paragraph("Notas", headerFont));

            // Estilo para el contenido
            Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLACK);

            for (Proveedor aux : ps.listaProveedores()) {
                index = pros.listaDeProductosDeXProveedor(aux.getId()).toString();
                tabla.addCell(new Paragraph(String.valueOf(aux.getId()), contentFont));
                tabla.addCell(new Paragraph(aux.getNombre(), contentFont));
                tabla.addCell(new Paragraph(index, contentFont));
                tabla.addCell(new Paragraph(aux.getNotas(), contentFont));
            }
            documento.add(tabla);
            documento.close();
            MessageAlerts.getInstance().showMessage("EL PDF se creo correctamente", "El PDF de los proveedores se genero en: " + finalFileName, MessageAlerts.MessageType.SUCCESS);
        } catch (Exception e) {
            MessageAlerts.getInstance().showMessage("Error al crear el PDF", "Se produjo un error al intentar crear el reporte", MessageAlerts.MessageType.ERROR);
        }
    }

}
