/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.crud;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;
import entidades.ModelProfile;
import entidades.Productos;
import entidades.Proveedor;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javaswingdev.picturebox.DefaultPictureBoxRender;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import jnafilechooser.api.JnaFileChooser;
import net.coobird.thumbnailator.Thumbnails;
import services.ProveedorServices;

/**
 *
 * @author Cristian Candioti
 */
public class ProductosAgregarBaseDatos extends javax.swing.JPanel {

    /**
     * Creates new form UsuariosAgregarBaseDatos
     */
    public ProductosAgregarBaseDatos() {
        initComponents();
        jTextFieldID.setVisible(false);
        datePicker.setCloseAfterSelected(true);
        datePicker.setEditor(jFormattedTextFieldFecha);
        pictureBox.setPictureBoxRender(new DefaultPictureBoxRender() {
            @Override
            public Shape render(Rectangle rectangle) {
                return createRound(rectangle, UIScale.scale(10));
            }
        });
        pictureBox.setImage(null);
        jPanelImagenProducto.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:0,0,0,0,$Component.borderColor,,10;"
                + "background:$TextArea.background;");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datePicker = new raven.datetime.component.date.DatePicker();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldContenido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldVariedad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreadescipcion = new javax.swing.JTextArea();
        jFormattedTextFieldFecha = new javax.swing.JFormattedTextField();
        jFormattedTextFieldPrecioCosto = new javax.swing.JFormattedTextField();
        jFormattedTextFieldPrecioVenta = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldStock = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldMarca = new javax.swing.JTextField();
        jTextFieldTipoProducto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBoxProveedor = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jPanelImagenProducto = new javax.swing.JPanel();
        pictureBox = new javaswingdev.picturebox.PictureBox();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonAgregarImagen = new javax.swing.JButton();
        jButtonBorrarImagen = new javax.swing.JButton();
        jTextFieldID = new javax.swing.JTextField();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Nombre");

        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Fecha");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Contenido");

        jTextFieldContenido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldContenidoActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Variedad");

        jTextFieldVariedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldVariedadActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Precio costo");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Precio venta");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Descripcion");

        jTextAreadescipcion.setColumns(20);
        jTextAreadescipcion.setLineWrap(true);
        jTextAreadescipcion.setRows(5);
        jTextAreadescipcion.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextAreadescipcion);

        jFormattedTextFieldPrecioCosto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));

        jFormattedTextFieldPrecioVenta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Stock");

        jTextFieldStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStockActionPerformed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Marca");

        jTextFieldMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMarcaActionPerformed(evt);
            }
        });

        jTextFieldTipoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTipoProductoActionPerformed(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("Tipo producto");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Proveedor");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel14.setText("Imagen producto");

        jPanelImagenProducto.setLayout(new java.awt.BorderLayout());

        jToolBar1.setRollover(true);
        jToolBar1.setOpaque(false);

        jButtonAgregarImagen.setText("Agregar");
        jButtonAgregarImagen.setFocusable(false);
        jButtonAgregarImagen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAgregarImagen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAgregarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarImagenActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonAgregarImagen);

        jButtonBorrarImagen.setForeground(new java.awt.Color(255, 0, 0));
        jButtonBorrarImagen.setText("Borrar");
        jButtonBorrarImagen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBorrarImagen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonBorrarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarImagenActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonBorrarImagen);

        javax.swing.GroupLayout pictureBoxLayout = new javax.swing.GroupLayout(pictureBox);
        pictureBox.setLayout(pictureBoxLayout);
        pictureBoxLayout.setHorizontalGroup(
            pictureBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pictureBoxLayout.createSequentialGroup()
                .addGap(0, 152, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pictureBoxLayout.setVerticalGroup(
            pictureBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pictureBoxLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );

        jPanelImagenProducto.add(pictureBox, java.awt.BorderLayout.CENTER);

        jTextFieldID.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldContenido)
                    .addComponent(jFormattedTextFieldFecha)
                    .addComponent(jTextFieldTipoProducto)
                    .addComponent(jComboBoxProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldStock)
                    .addComponent(jFormattedTextFieldPrecioCosto)
                    .addComponent(jFormattedTextFieldPrecioVenta)
                    .addComponent(jTextFieldMarca)
                    .addComponent(jTextFieldVariedad)
                    .addComponent(jTextFieldNombre)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanelImagenProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jFormattedTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldVariedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jFormattedTextFieldPrecioCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jFormattedTextFieldPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jComboBoxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jPanelImagenProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(1, 1, 1)
                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jTextFieldContenidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldContenidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldContenidoActionPerformed

    private void jTextFieldVariedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVariedadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVariedadActionPerformed

    private void jTextFieldStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldStockActionPerformed

    private void jTextFieldMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMarcaActionPerformed

    private void jTextFieldTipoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTipoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTipoProductoActionPerformed
//Jbutton para cargar la imagen que selecciona el ususario
    private void jButtonAgregarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarImagenActionPerformed
        JnaFileChooser ch = new JnaFileChooser();
        ch.addFilter("Image", "png", "jpg");
        boolean act = ch.showOpenDialog(SwingUtilities.getWindowAncestor(this));
        if (act) {
            File file = ch.getSelectedFile();
            pictureBox.setImage(new ImageIcon(file.getAbsolutePath()));
            profile = new ModelProfile(file);
        }
    }//GEN-LAST:event_jButtonAgregarImagenActionPerformed

    //Se crea una variable que representa la imagen
    private ModelProfile profile;

    private void jButtonBorrarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarImagenActionPerformed
        pictureBox.setImage(null);
        profile = null;
    }//GEN-LAST:event_jButtonBorrarImagenActionPerformed

    //Metodo para retornar el producto para ser guardado en la base de datos
    public Productos retornarParaGuardar() {
        try {
            String nombre = jTextFieldNombre.getText();
            //Se obtiene el localDate
            LocalDate localDate = datePicker.getSelectedDate();
            //se crea la variable dandole un valor null.
            Date date = null;
            //Se verifica si no es nulo y procede a convertir si tiene un valor
            if (localDate != null) {
                //Se crea un objeto Instant que representa el inicio del día (medianoche) en la zona horaria por defecto del sistema.
                Instant instant = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
                //Se convierte el Instant a un objeto Date utilizando el método Date.from()
                date = Date.from(instant);
            }
            String contenido = jTextFieldContenido.getText();
            String variedad = jTextFieldVariedad.getText();
            double precioCosto = Double.parseDouble(jFormattedTextFieldPrecioCosto.getValue().toString());
            double precioVenta = Double.parseDouble(jFormattedTextFieldPrecioVenta.getValue().toString());
            int stock = Integer.parseInt(jTextFieldStock.getText());
            String marca = jTextFieldMarca.getText();
            String tipoProducto = jTextFieldTipoProducto.getText();
            Proveedor positions = (Proveedor) jComboBoxProveedor.getSelectedItem();
            //Se trae la imagen
            byte[] imagen = getByteImage(profile.getPath());
            String descipcion = jTextAreadescipcion.getText();
            return new Productos(variedad, nombre, date, marca, tipoProducto, contenido, stock, precioCosto, precioVenta, precioCosto, precioVenta, imagen, positions, descipcion);
        } catch (Exception e) {
        }
        return null;
    }

    //Metodo para cargar los datos en el comboBox
    public void loadData() {
        try {
            ProveedorServices services = new ProveedorServices();
            for (Proveedor pos : services.listaProveedores()) {
                jComboBoxProveedor.addItem(pos);
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo loadData() de la clase productoAgregarBaseDeDatos");
        }
    }

    //Metodo creado para convertir en byte la imagen seleccionada por el usuario
    private byte[] getByteImage(File file) throws IOException {
        BufferedImage image = Thumbnails.of(file)
                .width(500)
                .outputQuality(0.7f)
                .asBufferedImage();
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", out);
            byte[] data = out.toByteArray();
            return data;
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    //Este metodo sirve para traer el producto seleccionado por el usuario y setear sus valores para mostrarlos en las celdas
    public void modificarPrueba(Productos aux) {
        try {
            ProveedorServices ps = new ProveedorServices();
            jTextFieldID.setText(String.valueOf(aux.getId()));
            jTextFieldNombre.setText(aux.getNombre());
            jTextFieldVariedad.setText(aux.getVariedad());
            jTextFieldMarca.setText(aux.getMarca());
            jTextFieldTipoProducto.setText(aux.getTipoProducto());
            jTextAreadescipcion.setText(aux.getDescripcion());
            jTextFieldContenido.setText(aux.getContenido());
            // Crear un objeto Date con el dato del producto
            Date date = aux.getFechaIngreso();
            // Convertir Instant a LocalDate
            LocalDate localDate = date.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            datePicker.setSelectedDate(localDate);
            jFormattedTextFieldPrecioCosto.setText(String.valueOf(aux.getPrecioCosto()));
            jFormattedTextFieldPrecioVenta.setText(String.valueOf(aux.getPrecioventa()));
            jTextFieldStock.setText(String.valueOf(aux.getStock()));
            //logica para setear el comboBox
            Proveedor index = ps.buscarProveedorPorId(aux.getId());
            ProveedorServices services = new ProveedorServices();
            for (Proveedor pos : services.listaProveedores()) {
                jComboBoxProveedor.addItem(pos);
                if (aux.getId() == pos.getId()) {
                    jComboBoxProveedor.setSelectedItem(pos);
                }
            }
            //Metodo para setear la imagen
            profile = new ModelProfile(aux.getImagen());
            pictureBox.setImage(profile.getIcon());
        } catch (Exception e) {
            System.out.println("Error en el metodo modificarPrueba de la clase ProductosAgregarBaseDatos");
        }
    }

    //Metodo para retornar el producto modificado
    public Productos retornarProductoModificado() {
        try {
            Productos aux = new Productos();
            aux.setId(Integer.parseInt(jTextFieldID.getText()));
            aux.setVariedad(jTextFieldVariedad.getText());
            aux.setNombre(jTextFieldNombre.getText());
            //Para la fecha
            LocalDate localDate = datePicker.getSelectedDate();
            Date date = null;
            if (localDate != null) {
                Instant instant = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
                date = Date.from(instant);
            }
            aux.setFechaIngreso(date);
            aux.setMarca(jTextFieldMarca.getText());
            aux.setTipoProducto(jTextFieldTipoProducto.getText());
            aux.setContenido(jTextFieldContenido.getText());
            aux.setStock(Integer.parseInt(jTextFieldStock.getText()));
            aux.setPrecioCosto(Double.parseDouble(jFormattedTextFieldPrecioCosto.getValue().toString()));
            aux.setPrecioventa(Double.parseDouble(jFormattedTextFieldPrecioVenta.getValue().toString()));
            
            return aux;
        } catch (Exception e) {
            System.out.println("Error en el metodo retornarProductoModificado() de la clase ProductosAgregarBaseDatos");
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.datetime.component.date.DatePicker datePicker;
    private javax.swing.JButton jButtonAgregarImagen;
    private javax.swing.JButton jButtonBorrarImagen;
    private javax.swing.JComboBox<Proveedor> jComboBoxProveedor;
    private javax.swing.JFormattedTextField jFormattedTextFieldFecha;
    private javax.swing.JFormattedTextField jFormattedTextFieldPrecioCosto;
    private javax.swing.JFormattedTextField jFormattedTextFieldPrecioVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanelImagenProducto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreadescipcion;
    private javax.swing.JTextField jTextFieldContenido;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldMarca;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldStock;
    private javax.swing.JTextField jTextFieldTipoProducto;
    private javax.swing.JTextField jTextFieldVariedad;
    private javax.swing.JToolBar jToolBar1;
    private javaswingdev.picturebox.PictureBox pictureBox;
    // End of variables declaration//GEN-END:variables
}
