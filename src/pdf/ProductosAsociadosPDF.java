/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import entidades.Proveedor;
import java.io.File;
import java.io.FileOutputStream;
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
            int contador = 0;

            com.itextpdf.text.Document documento = new com.itextpdf.text.Document();
            String ruta = System.getProperty("user.home");// Se encarga de obtener la ubicación del directorio de inicio del usuario actual del sistema. 
            String nombrePDF = "/OneDrive/Escritorio/Reporte_Proveedores.pdf";// Se construye la direccion donde se va a generar y el nombre del PDF.
            /**
             * El bucle while se encarga de comprobar si un PDF con el mismo
             * nombre ya existe. Si existe un PDF con ese nombre, se incrementa
             * el contador y se agrega ese contador al nombre.
             */
            while (new File(ruta + nombrePDF).exists()) {
                contador++;
                nombrePDF = "/OneDrive/Escritorio/Reporte_Proveedores(" + contador + ").pdf";
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
            MessageAlerts.getInstance().showMessage("EL PDF se creo correctamente", "El PDF del proveedor se genero en el escritorio", MessageAlerts.MessageType.SUCCESS);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al crear el PDF" + e);
        }
    }

}
