package com.raven.form;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.raven.component.Form;
import com.raven.crud.HistorialCliente;
import com.raven.crud.ProductosAgregarBaseDatos;
import com.raven.table.CheckBoxTableHeaderRenderer;
import com.raven.table.TableHeaderAlignment;
import com.raven.theme.ProfileTableRenderer;
import entidades.Productos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import raven.alerts.MessageAlerts;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import services.ClienteServices;
import services.ProductoServices;

public class Producto_Form extends Form {

    public Producto_Form() {
        initComponents();
        init();
    }

    private void init() {
        jTable.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");

        jTable.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:70;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");

        jScrollPane.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
                + "background:$Table.background;");

        jLabel.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +5;");

        jTextField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar");
        jTextField.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("com/raven/icon/search.svg"));

        jTextField.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;");

        jTable.getColumnModel().getColumn(0).setHeaderRenderer(new CheckBoxTableHeaderRenderer(jTable, 0));
        jTable.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(jTable));
        jTable.getColumnModel().getColumn(2).setCellRenderer(new ProfileTableRenderer(jTable));
        loadData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField = new javax.swing.JTextField();
        jButtonVer = new javax.swing.JButton();
        jLabel = new javax.swing.JLabel();

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Estado", "#", "Nombre y Variedad", "Fecha ingreso", "Marca", "Tipo producto", "Contenido", "Stock", "Precio costo", "Precio venta", "Ganancias", "Porcentaje ganancia", "Proveedor", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setMaxWidth(30);
            jTable.getColumnModel().getColumn(1).setMaxWidth(30);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(200);
        }

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldKeyReleased(evt);
            }
        });

        jButtonVer.setText("Ver");
        jButtonVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerActionPerformed(evt);
            }
        });

        jLabel.setText("Ingrese el nombre del producto");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addGap(100, 100, 100))
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonVer)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(45, 45, 45))))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVer))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    //JButton para abrir una ventana y guardar un producto a la base de datos
    @SuppressWarnings("empty-statement")
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ProductosAgregarBaseDatos agregar = new ProductosAgregarBaseDatos();
        agregar.loadData();
        ProductoServices ps = new ProductoServices();
        DefaultOption option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }
        };
        String actions[] = new String[]{"Cancelar", "Guardar"};
        GlassPanePopup.showPopup(new SimplePopupBorder(agregar, "Guardar producto", actions, (pc, i) -> {
            if (i == 1) {
                ps.persistirProducto(agregar.retornarParaGuardar().getVariedad(), agregar.retornarParaGuardar().getNombre(), agregar.retornarParaGuardar().getFechaIngreso(), agregar.retornarParaGuardar().getMarca(), agregar.retornarParaGuardar().getTipoProducto(), agregar.retornarParaGuardar().getContenido(), agregar.retornarParaGuardar().getStock(), agregar.retornarParaGuardar().getPrecioCosto(), agregar.retornarParaGuardar().getPrecioventa(), agregar.retornarParaGuardar().getPrecioCosto(), agregar.retornarParaGuardar().getPrecioventa(), agregar.retornarParaGuardar().getProveedor(), agregar.retornarParaGuardar().getImagen(), agregar.retornarParaGuardar().getDescripcion());
                MessageAlerts.getInstance().showMessage("Se agrego correctamente", "El producto fue agregado correctamente a la base de datos", MessageAlerts.MessageType.SUCCESS);
                loadData();
                pc.closePopup();
            } else {
                pc.closePopup();
            }
        }), option);
    }//GEN-LAST:event_jButton3ActionPerformed
    //JButon para modificar un producto de la base de datos 
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ProductosAgregarBaseDatos ProductosAgregarBaseDatos = new ProductosAgregarBaseDatos();
        ProductoServices ps = new ProductoServices();
        List<Productos> list = Seleccionarusuario();
        if (!list.isEmpty()) {
            if (list.size() == 1) {
                //Con esto obtendremos al cliente en la posicion que selecciono el usuario para luego abrir una ventana emergente para su modificacion
                Productos aux = list.get(0);
                //Metodo probisorio para modificar
                ProductosAgregarBaseDatos.modificarPrueba(ps.buscarProductoPorID(aux.getId()));
                //Creamos nuevamente la ventana emergente para mostrar los datos
                DefaultOption option = new DefaultOption() {
                    @Override
                    public boolean closeWhenClickOutside() {
                        return true;
                    }
                };
                String actions[] = new String[]{"Cancelar", "Modificar"};
                GlassPanePopup.showPopup(new SimplePopupBorder(ProductosAgregarBaseDatos, "Modificar producto", actions, (pc, i) -> {
                    if (i == 1) {
                        //Este condicional if me ayuda para que el usuario no elimine la imagen y la deje vacia
                        if (ProductosAgregarBaseDatos.retornarProductoModificado() != null) {
                            System.out.println(ProductosAgregarBaseDatos.retornarProductoModificado());
//                            ps.modificarProducto(ProductosAgregarBaseDatos.retornarProductoModificado().getId(), ProductosAgregarBaseDatos.retornarProductoModificado().getVariedad(), ProductosAgregarBaseDatos.retornarProductoModificado().getNombre(), ProductosAgregarBaseDatos.retornarProductoModificado().getFechaIngreso(), ProductosAgregarBaseDatos.retornarProductoModificado().getMarca(), ProductosAgregarBaseDatos.retornarProductoModificado().getTipoProducto(), ProductosAgregarBaseDatos.retornarProductoModificado().getContenido(), ProductosAgregarBaseDatos.retornarProductoModificado().getStock(), ProductosAgregarBaseDatos.retornarProductoModificado().getPrecioCosto(), ProductosAgregarBaseDatos.retornarProductoModificado().getPrecioventa(), ProductosAgregarBaseDatos.retornarProductoModificado().getGanancias(), ProductosAgregarBaseDatos.retornarProductoModificado().getPorcentajeGanancias(), ProductosAgregarBaseDatos.retornarProductoModificado().getProveedor(), ProductosAgregarBaseDatos.retornarProductoModificado().getDescripcion(), ProductosAgregarBaseDatos.retornarProductoModificado().getImagen());
                            MessageAlerts.getInstance().showMessage("Se modifico correctamente", "El producto fue modificado correctamente", MessageAlerts.MessageType.SUCCESS);
                        } else {
                            MessageAlerts.getInstance().showMessage("Error", "Verificar que la imagen no este vacia", MessageAlerts.MessageType.ERROR);
                        }
                        loadData();
                        pc.closePopup();
                    } else {
                        pc.closePopup();
                    }
                }), option);
            } else {
                MessageAlerts.getInstance().showMessage("Atencion", "Solamente puede modificar un producto a la vez", MessageAlerts.MessageType.DEFAULT);
            }
        } else {
            MessageAlerts.getInstance().showMessage("Error", "Seleccione un producto para su modificacion", MessageAlerts.MessageType.WARNING);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    //JButton para eliminar el produto de la base de datos
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        List<Productos> list = Seleccionarusuario();
        ClienteServices cs = new ClienteServices();
        ProductoServices ps = new ProductoServices();
        if (!list.isEmpty()) {
            DefaultOption option = new DefaultOption() {
                @Override
                public boolean closeWhenClickOutside() {
                    return true;
                }
            };
            String actions[] = new String[]{"Cancelar", "Eliminar"};
            JLabel label = new JLabel("Estas seguro que deseas eliminar de forma permanente a estos productos: " + list);
            label.setBorder(new EmptyBorder(0, 25, 0, 25));
            GlassPanePopup.showPopup(new SimplePopupBorder(label, "Confirmar eliminacion", actions, (pc, i) -> {
                if (i == 1) {
                    for (Productos aux : list) {
                        ps.eliminarProducto(aux);
                    }
                    MessageAlerts.getInstance().showMessage("Se elimino correctamente", "El producto fue eliminado correctamente de la base de datos", MessageAlerts.MessageType.SUCCESS);
                    loadData();
                    pc.closePopup();
                } else {
                    pc.closePopup();
                }
            }), option);
        } else {
            MessageAlerts.getInstance().showMessage("Error", "Seleccione un producto para su eliminacion", MessageAlerts.MessageType.WARNING);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    //JButton para acceder al historial del producto
    private void jButtonVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerActionPerformed
        HistorialCliente historialcliente = new HistorialCliente();
        List<Productos> list = Seleccionarusuario();
        if (!list.isEmpty()) {
            if (list.size() == 1) {
                //Con esto obtendremos al cliente en la posicion que selecciono el usuario para luego abrir una ventana emergente para ver su historial
                Object data = list.get(0);
                //Metodo probisorio para ver su historial
                historialcliente.historialCompraSeteoValores(data);
                //Creamos nuevamente la ventana emergente para mostrar los datos
                DefaultOption option = new DefaultOption() {
                    @Override
                    public boolean closeWhenClickOutside() {
                        return true;
                    }
                };
                String actions[] = new String[]{"Cancelar"};
                GlassPanePopup.showPopup(new SimplePopupBorder(historialcliente, "Historial de compras del cliente", actions, (pc, i) -> {
                    if (i == 0) {
                        pc.closePopup();
                    }
                }), option);
            } else {
                MessageAlerts.getInstance().showMessage("Atencion", "Solamente puede ver el historial de compras de un solo cliente", MessageAlerts.MessageType.DEFAULT);
            }
        } else {
            MessageAlerts.getInstance().showMessage("Error", "Seleccione un cliente para ver su historial", MessageAlerts.MessageType.WARNING);
        }
    }//GEN-LAST:event_jButtonVerActionPerformed
    //jTextField la cual buscaremos el producto por su nombre
    private void jTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldKeyReleased
        search(jTextField.getText().trim());
    }//GEN-LAST:event_jTextFieldKeyReleased

    //Esta es la logica para que se aplique cuando se selecciona un producto o varios o ninguno.
    private List<Productos> Seleccionarusuario() {
        try {
            ProductoServices ps = new ProductoServices();
            List<Productos> list = new ArrayList<>();
            for (int i = 0; i < jTable.getRowCount(); i++) {
                if ((boolean) jTable.getValueAt(i, 0)) {
                    Object aux = jTable.getValueAt(i, 1);
                    String index = aux.toString();
                    int id = Integer.parseInt(index);
                    Productos data = ps.buscarProductoPorID(id);
                    list.add(data);
                }
            }
            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en el metodo Seleccionarusuario() de la clase Producto_Form");
            System.out.println(e.fillInStackTrace());
        }
        return null;
    }

    //Metodo la cual carga la tabla
    public void loadData() {
        try {
            ProductoServices ps = new ProductoServices();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            if (jTable.isEditing()) {
                jTable.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<Productos> list = ps.listaProductos();
            for (Productos p : list) {
//                model.addRow(p.toTableRow(jTable.getRowCount() + 1));
                model.addRow(p.toTableRow(p.getId()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error metodo loadDATA() clase producto_Form");
        }
    }

    //Metodo la cual busca el prodcuto en el jTextField
    public void search(String search) {
        try {
            ProductoServices ps = new ProductoServices();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            if (jTable.isEditing()) {
                jTable.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<Productos> list = ps.barraBusquedaProductos(search);
            for (Productos p : list) {
                model.addRow(p.toTableRow(jTable.getRowCount() + 1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error metodo loadDATA() clase productos_Form");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonVer;
    private javax.swing.JLabel jLabel;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField;
    // End of variables declaration//GEN-END:variables
}
