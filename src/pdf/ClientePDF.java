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
            parrafo.add("Angel Tienda Holistica y Esoterica © \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Clientes \n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(4);
            tabla.addCell("Codigo");
            tabla.addCell("Nombre");
            tabla.addCell("Productos");
            tabla.addCell("Notas");

            for (Cliente aux : cs.listaCliente()) {
                tabla.addCell(String.valueOf(aux.getId()));
                tabla.addCell(aux.getNombre());
                tabla.addCell(index);
                tabla.addCell(aux.getNotas());
            }
            documento.add(tabla);
            documento.close();
            MessageAlerts.getInstance().showMessage("EL PDF se creo correctamente", "El PDF de los proveedores se genero en el escritorio", MessageAlerts.MessageType.SUCCESS);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al crear el PDF" + e);
        }
    }

}
