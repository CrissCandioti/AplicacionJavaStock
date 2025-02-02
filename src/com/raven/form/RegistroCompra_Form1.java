package com.raven.form;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.raven.component.Form;
import com.raven.crud.HistorialCliente;
import com.raven.crud.UsuariosAgregarBaseDatos;
import com.raven.table.CheckBoxTableHeaderRenderer;
import com.raven.table.TableHeaderAlignment;
import entidades.Cliente;
import excel.ClientesExcel;
import excel.HistorialCompraClienteExcel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import pdf.ClienteCompraPDF;
import pdf.ClientePDF;
import raven.alerts.MessageAlerts;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import services.ClienteServices;

public class RegistroCompra_Form1 extends Form {

    public RegistroCompra_Form1() {
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
                + "rowHeight:30;"
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
        jTextField = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel = new javax.swing.JLabel();
        jButtonPDFTabla = new javax.swing.JButton();
        jButtonExcelTabla = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Estado", "#", "Nombre", "Apellido", "N° Documento", "Email", "N° Whats App", "Localidad", "Direccion", "Notas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false
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

        jTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldKeyReleased(evt);
            }
        });

        jButton4.setText("Historial");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel.setText("Ingrese el nombre del cliente");

        jButtonPDFTabla.setText("PDF Tabla");
        jButtonPDFTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPDFTablaActionPerformed(evt);
            }
        });

        jButtonExcelTabla.setText("Excel Tabla");
        jButtonExcelTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcelTablaActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/arrow-clockwise.png"))); // NOI18N
        jButton5.setText("Refrescar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonExcelTabla)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonPDFTabla)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
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
                    .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPDFTabla)
                    .addComponent(jButtonExcelTabla)
                    .addComponent(jButton5))
                .addContainerGap())
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

    //JButon para modificar un cliente de la base de datos 
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            UsuariosAgregarBaseDatos UsuariosAgregarBaseDatos = new UsuariosAgregarBaseDatos();
            ClienteServices cs = new ClienteServices();
            List<Cliente> list = Seleccionarusuario();
            if (!list.isEmpty()) {
                if (list.size() == 1) {
                    //Con esto obtendremos al cliente en la posicion que selecciono el usuario para luego abrir una ventana emergente para su modificacion
                    Cliente aux = list.get(0);
                    //Metodo probisorio para modificar
                    UsuariosAgregarBaseDatos.modificacionPrueba(cs.buscarClienteID(aux.getId()));
                    //Creamos nuevamente la ventana emergente para mostrar los datos
                    DefaultOption option = new DefaultOption() {
                        @Override
                        public boolean closeWhenClickOutside() {
                            return true;
                        }
                    };
                    String actions[] = new String[]{"Cancelar", "Modificar"};
                    GlassPanePopup.showPopup(new SimplePopupBorder(UsuariosAgregarBaseDatos, "Modificar cliente", actions, (pc, i) -> {
                        if (i == 1) {
                            if (UsuariosAgregarBaseDatos.retornarCliente() == null) {
                                MessageAlerts.getInstance().showMessage("Se produjo un error", "El cliente no puede tener la celda del documento vacia o con letras", MessageAlerts.MessageType.ERROR);
                            } else {
                                cs.modificarCliente(UsuariosAgregarBaseDatos.retornarCliente().getId(), UsuariosAgregarBaseDatos.retornarCliente().getNombre(), UsuariosAgregarBaseDatos.retornarCliente().getApellido(), UsuariosAgregarBaseDatos.retornarCliente().getDocumento(), UsuariosAgregarBaseDatos.retornarCliente().getEmail(), UsuariosAgregarBaseDatos.retornarCliente().getWhatsapp(), UsuariosAgregarBaseDatos.retornarCliente().getLocalidad(), UsuariosAgregarBaseDatos.retornarCliente().getDireccion(), UsuariosAgregarBaseDatos.retornarCliente().getNotas());
                                MessageAlerts.getInstance().showMessage("Se modifico correctamente", "El cliente fue modificado correctamente", MessageAlerts.MessageType.SUCCESS);
                                loadData();
                                pc.closePopup();
                            }
                        } else {
                            pc.closePopup();
                        }
                    }), option);
                } else {
                    MessageAlerts.getInstance().showMessage("Atencion", "Solamente puede modificar un cliente a la vez", MessageAlerts.MessageType.DEFAULT);
                }
            } else {
                MessageAlerts.getInstance().showMessage("Error", "Seleccione un cliente para su modificacion", MessageAlerts.MessageType.WARNING);
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    //JButton para eliminar el cliente de la base de datos
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        List<Cliente> list = Seleccionarusuario();
        ClienteServices cs = new ClienteServices();
        if (!list.isEmpty()) {
            DefaultOption option = new DefaultOption() {
                @Override
                public boolean closeWhenClickOutside() {
                    return true;
                }
            };
            String actions[] = new String[]{"Cancelar", "Eliminar"};
            JLabel label = new JLabel("Estas seguro que deseas eliminar de forma permanente a estos clientes: " + list);
            label.setBorder(new EmptyBorder(0, 25, 0, 25));
            GlassPanePopup.showPopup(new SimplePopupBorder(label, "Confirmar eliminacion", actions, (pc, i) -> {
                if (i == 1) {
                    for (Cliente aux : list) {
                        cs.borrarCliente(aux);
                    }
                    MessageAlerts.getInstance().showMessage("Se elimino correctamente", "El cliente fue eliminado correctamente de la base de datos", MessageAlerts.MessageType.SUCCESS);
                    loadData();
                    pc.closePopup();
                } else {
                    pc.closePopup();
                }
            }), option);
        } else {
            MessageAlerts.getInstance().showMessage("Error", "Seleccione un cliente para su eliminacion", MessageAlerts.MessageType.WARNING);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    //JButton para acceder al historial de compra del cliente
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        HistorialCliente historialcliente = new HistorialCliente();
        List<Cliente> list = Seleccionarusuario();
        if (!list.isEmpty()) {
            if (list.size() == 1) {
                //Con esto obtendremos al cliente en la posicion que selecciono el usuario para luego abrir una ventana emergente para ver su historial
                Cliente data = list.get(0);
                //Metodo probisorio para ver su historial
                historialcliente.historialCompraSeteoValores(data);
                //Creamos nuevamente la ventana emergente para mostrar los datos
                DefaultOption option = new DefaultOption() {
                    @Override
                    public boolean closeWhenClickOutside() {
                        return true;
                    }
                };
                String actions[] = new String[]{"Cancelar", "Imprimir PDF", "Imprimir Excel"};
                GlassPanePopup.showPopup(new SimplePopupBorder(historialcliente, "Historial de compras del cliente", actions, (pc, i) -> {
                    if (i == 0) {
                        pc.closePopup();
                    } else if (i == 1) {
                        ClienteCompraPDF pdf = new ClienteCompraPDF();
                        pdf.pdfPresupuesto(data);
                    } else if (i == 2) {
                        HistorialCompraClienteExcel hcc = new HistorialCompraClienteExcel();
                        hcc.HistorialCompraClienteExcel(data);
                    }
                }), option);
            } else {
                MessageAlerts.getInstance().showMessage("Atencion", "Solamente puede ver el historial de compras de un solo cliente", MessageAlerts.MessageType.DEFAULT);
            }
        } else {
            MessageAlerts.getInstance().showMessage("Error", "Seleccione un cliente para ver su historial", MessageAlerts.MessageType.WARNING);
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    //jTextField la cual buscaremos el cliente por nombre o apellido
    private void jTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldKeyReleased
        search(jTextField.getText().trim());
    }//GEN-LAST:event_jTextFieldKeyReleased
    //JButton para crear el PDF
    private void jButtonPDFTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPDFTablaActionPerformed
        ClientePDF pdf = new ClientePDF();
        pdf.pdfTablaProveedores();
    }//GEN-LAST:event_jButtonPDFTablaActionPerformed
    //JButton para crear el Excel
    private void jButtonExcelTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcelTablaActionPerformed
        ClientesExcel ce = new ClientesExcel();
        ce.TablaClientesExcelReporte();
    }//GEN-LAST:event_jButtonExcelTablaActionPerformed
//JButton creado para recargar la tabla con los nuevos datos (si ocurre un problema al ingresar un nuevo usuario y no se muestra este boton hara ese trabajo) 
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        loadData();
    }//GEN-LAST:event_jButton5ActionPerformed

    //Esta es la logica para que se aplique cuando se selecciona un cliente o varios o ninguno.
    private List<Cliente> Seleccionarusuario() {
        try {
            List<Cliente> list = new ArrayList<>();
            for (int i = 0; i < jTable.getRowCount(); i++) {
                if ((boolean) jTable.getValueAt(i, 0)) {
                    Cliente data = (Cliente) jTable.getValueAt(i, 2);
                    list.add(data);
                }
            }
            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error lista");
        }
        return null;
    }

    //Metodo la cual carga la tabla
    public void loadData() {
        try {
            ClienteServices cs = new ClienteServices();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            if (jTable.isEditing()) {
                jTable.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<Cliente> list = cs.listaCliente();

            // Configurar scroll horizontal
            jTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            jScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

            // Agregar los datos a la tabla
            for (Cliente c : list) {
                model.addRow(c.toTableRow(c.getId()));
            }

            // Ajustar ancho de columnas basado en el contenido
            for (int column = 0; column < jTable.getColumnCount(); column++) {
                int maxWidth = 0;
                // Revisar el ancho del encabezado
                String headerValue = jTable.getColumnName(column);
                maxWidth = Math.max(maxWidth, headerValue.length() * 10);

                // Revisar el ancho del contenido
                for (int row = 0; row < jTable.getRowCount(); row++) {
                    Object value = jTable.getValueAt(row, column);
                    if (value != null) {
                        int width = String.valueOf(value).length() * 10;
                        maxWidth = Math.max(maxWidth, width);
                    }
                }
                // Establecer un ancho mínimo y máximo razonable
                maxWidth = Math.max(50, Math.min(maxWidth + 20, 300));
                jTable.getColumnModel().getColumn(column).setPreferredWidth(maxWidth);
            }

            // Asegurar que la tabla se actualice visualmente
            jTable.revalidate();
            jTable.repaint();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de compras, verifique la conexion a la base de datos ");
        }
    }

    //Metodo la cual busca el cliente en el jTextField
    public void search(String search) {
        try {
            ClienteServices cs = new ClienteServices();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            if (jTable.isEditing()) {
                jTable.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<Cliente> list = cs.busquedaCliente(search);
            for (Cliente c : list) {
                model.addRow(c.toTableRow(jTable.getRowCount() + 1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error metodo loadDATA() clase usuario_Form");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonExcelTabla;
    private javax.swing.JButton jButtonPDFTabla;
    private javax.swing.JLabel jLabel;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField;
    // End of variables declaration//GEN-END:variables
}
