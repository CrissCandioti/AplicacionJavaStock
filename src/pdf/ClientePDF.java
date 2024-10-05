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
import entidades.Proveedor;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
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

            int contador = 0;
            Document documento = new Document();
            //------------------------------------------------------------------------------------------------------
            String ruta = System.getProperty("user.home"); // Se encarga de obtener la ubicación del directorio de inicio del usuario actual del sistema. 
            String nombrePDF = "/OneDrive/Escritorio/Tabla_Clientes.pdf"; // Se construye la direccion donde se va a generar y el nombre del PDF.
            /**
             * El bucle while se encarga de comprobar si un PDF con el mismo
             * nombre ya existe. Si existe un PDF con ese nombre, se incrementa
             * el contador y se agrega ese contador al nombre.
             */
            while (new File(ruta + nombrePDF).exists()) {
                contador++;
                nombrePDF = "/OneDrive/Escritorio/Tabla_Clientes(" + contador + ").pdf";
            }
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + nombrePDF));
            //-------------------------------------------------------------------------------------------------------
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
            tabla.addCell("Documento");
            tabla.addCell("Email");
            tabla.addCell("WhatsApp");
            tabla.addCell("Localidad");
            tabla.addCell("Direccion");
            tabla.addCell("Notas");

            for (Cliente aux : cs.listaCliente()) {
                tabla.addCell(String.valueOf(aux.getId()));
                tabla.addCell(aux.getNombre());
                tabla.addCell(aux.getApellido());
                tabla.addCell(aux.getNotas());
                tabla.addCell(String.valueOf(aux.getDocumento()));
                tabla.addCell(aux.getEmail());
                tabla.addCell(aux.getWhatsapp());
                tabla.addCell(aux.getLocalidad());
                tabla.addCell(aux.getDireccion());
                tabla.addCell(aux.getNotas());
            }
            documento.add(tabla);
            documento.close();
            MessageAlerts.getInstance().showMessage("EL PDF se creo correctamente", "El PDF de los clientes se genero en el escritorio", MessageAlerts.MessageType.SUCCESS);
        } catch (Exception e) {
            MessageAlerts.getInstance().showMessage("Error al crear el PDF", "Se produjo un error al intentar crear el reporte", MessageAlerts.MessageType.ERROR);
        }
    }

}
