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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import pdf.ClientePDF;
import raven.alerts.MessageAlerts;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import services.ClienteServices;

public class Compra_Form extends Form {

    public Compra_Form() {
        initComponents();
        init();
        fechaYHora();
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
        jTextField = new javax.swing.JTextField();
        jLabel = new javax.swing.JLabel();
        jButtonPDFTabla = new javax.swing.JButton();
        jButtonExcelTabla = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelVerFechaYHora = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();

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

        jTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldKeyReleased(evt);
            }
        });

        jLabel.setText("Ingrese el cliente");

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

        jLabel1.setText("Fecha y Hora:");

        jLabelVerFechaYHora.setText("Ver fecha y hora");

        jLabel2.setText("Ingrese el producto");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonExcelTabla)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonPDFTabla))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 376, Short.MAX_VALUE)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelVerFechaYHora))
                                    .addGroup(jPanelLayout.createSequentialGroup()
                                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jComboBox2, 0, 200, Short.MAX_VALUE)
                                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addGap(45, 45, 45))))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelVerFechaYHora))
                .addGap(18, 18, 18)
                .addComponent(jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPDFTabla)
                    .addComponent(jButtonExcelTabla))
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

   //jTextField la cual buscaremos el cliente por nombre o apellido
    private void jTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldKeyReleased
        search(jTextField.getText().trim());
    }//GEN-LAST:event_jTextFieldKeyReleased

    private void jButtonPDFTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPDFTablaActionPerformed
        ClientePDF pdf = new ClientePDF();
        pdf.pdfTablaProveedores();
    }//GEN-LAST:event_jButtonPDFTablaActionPerformed

    private void jButtonExcelTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcelTablaActionPerformed
        ClientesExcel ce = new ClientesExcel();
        ce.TablaClientesExcelReporte();
    }//GEN-LAST:event_jButtonExcelTablaActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

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
            for (Cliente c : list) {
//                model.addRow(c.toTableRow(jTable.getRowCount() + 1));
                model.addRow(c.toTableRow(c.getId()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error metodo loadDATA() clase usuario_Form");
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

    //Metodo para la fecha y hora del producto
    public void fechaYHora() {
        try {
            //Se crea un timer para que el tiempo se actualice en tiempo real
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtener la fecha y la hora actual
                    Date now = new Date();
                    // Formatear la fecha y hora
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    //Se setea el date con el formato de la fecha y hora creado
                    String tiempoFormateado = sdf.format(now);
                    // Establecer el texto del JLabel
                    jLabelVerFechaYHora.setText(tiempoFormateado);
                }
            });
            timer.start();  // Iniciar el timer para que empiece a actualizarse
        } catch (Exception e) {
            System.out.println("Error en la hora");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonExcelTabla;
    private javax.swing.JButton jButtonPDFTabla;
    private javax.swing.JComboBox<Cliente> jComboBox1;
    private javax.swing.JComboBox<Productos> jComboBox2;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelVerFechaYHora;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
