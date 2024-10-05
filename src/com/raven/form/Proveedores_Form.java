package com.raven.form;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.raven.component.Form;
import com.raven.crud.ProductosAsociados;
import com.raven.crud.ProveedoresAgregarBaseDatos1;
import com.raven.table.CheckBoxTableHeaderRenderer;
import com.raven.table.TableHeaderAlignment;
import entidades.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import pdf.ProductosAsociadosPDF;
import raven.alerts.MessageAlerts;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import services.ClienteServices;
import services.ProveedorServices;

public class Proveedores_Form extends Form {
    
    public Proveedores_Form() {
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
        jButton3 = new javax.swing.JButton();
        jTextField = new javax.swing.JTextField();
        jLabel = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Estado", "#", "Nombre", "Productos", "Notas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
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
            jTable.getColumnModel().getColumn(2).setMaxWidth(150);
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

        jLabel.setText("Ingrese el nombre del proveedor");

        jButton4.setText("Productos Asociados");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jScrollPane)
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
                        .addComponent(jButton4)
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
                    .addComponent(jButton4))
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

    //JButton para abrir una ventana y guardar un proveedor a la base de datos
    @SuppressWarnings("empty-statement")
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            ProveedoresAgregarBaseDatos1 agregar = new ProveedoresAgregarBaseDatos1();
            ProveedorServices ps = new ProveedorServices();
            DefaultOption option = new DefaultOption() {
                @Override
                public boolean closeWhenClickOutside() {
                    return true;
                }
            };
            String actions[] = new String[]{"Cancelar", "Guardar"};
            GlassPanePopup.showPopup(new SimplePopupBorder(agregar, "Guardar Proveedor", actions, (pc, i) -> {
                if (i == 1) {
                    ps.persistirProveedor(agregar.retornarProveedorAgregar().getNombre(), agregar.retornarProveedorAgregar().getNotas());
                    loadData();
                    pc.closePopup();
                } else {
                    pc.closePopup();
                }
            }), option);
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    //JButon para modificar un provedor de la base de datos 
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            ProveedoresAgregarBaseDatos1 ProveedorAgregarBaseDatos = new ProveedoresAgregarBaseDatos1();
            ClienteServices cs = new ClienteServices();
            ProveedorServices ps = new ProveedorServices();
            List<Proveedor> list = Seleccionarproveedor();
            if (!list.isEmpty()) {
                if (list.size() == 1) {
                    //Con esto obtendremos al cliente en la posicion que selecciono el usuario para luego abrir una ventana emergente para su modificacion
                    Proveedor aux = list.get(0);
                    //Metodo probisorio para modificar
                    ProveedorAgregarBaseDatos.modificacionPrueba(ps.buscarProveedorPorId(aux.getId()));
                    //Creamos nuevamente la ventana emergente para mostrar los datos
                    DefaultOption option = new DefaultOption() {
                        @Override
                        public boolean closeWhenClickOutside() {
                            return true;
                        }
                    };
                    String actions[] = new String[]{"Cancelar", "Modificar"};
                    GlassPanePopup.showPopup(new SimplePopupBorder(ProveedorAgregarBaseDatos, "Modificar proveedor", actions, (pc, i) -> {
                        if (i == 1) {
                            ps.modificarProveedor(ProveedorAgregarBaseDatos.retornarProveedor().getId(), ProveedorAgregarBaseDatos.retornarProveedor().getNombre(), ProveedorAgregarBaseDatos.retornarProveedor().getNotas());
                            loadData();
                            pc.closePopup();
                        } else {
                            pc.closePopup();
                        }
                    }), option);
                } else {
                    MessageAlerts.getInstance().showMessage("Atencion", "Solamente puede modificar un proveedor a la vez", MessageAlerts.MessageType.DEFAULT);
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
        List<Proveedor> list = Seleccionarproveedor();
        ProveedorServices ps = new ProveedorServices();
        if (!list.isEmpty()) {
            DefaultOption option = new DefaultOption() {
                @Override
                public boolean closeWhenClickOutside() {
                    return true;
                }
            };
            String actions[] = new String[]{"Cancelar", "Eliminar"};
            JLabel label = new JLabel("Estas seguro que deseas eliminar de forma permanente a estos proveedores: " + list);
            label.setBorder(new EmptyBorder(0, 25, 0, 25));
            GlassPanePopup.showPopup(new SimplePopupBorder(label, "Confirmar eliminacion", actions, (pc, i) -> {
                if (i == 1) {
                    for (Proveedor aux : list) {
                        ps.borrarProveedor(aux);
                    }
                    MessageAlerts.getInstance().showMessage("Se elimino correctamente", "El proveedor fue eliminado correctamente de la base de datos", MessageAlerts.MessageType.SUCCESS);
                    loadData();
                    pc.closePopup();
                } else {
                    pc.closePopup();
                }
            }), option);
        } else {
            MessageAlerts.getInstance().showMessage("Error", "Seleccione un proveedor para su eliminacion", MessageAlerts.MessageType.WARNING);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //jTextField la cual buscaremos el cliente por nombre o apellido
    private void jTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldKeyReleased
        search(jTextField.getText().trim());
    }//GEN-LAST:event_jTextFieldKeyReleased
    //JButton para ver con mas detalle los productos asociados
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ProductosAsociados pa = new ProductosAsociados();
        ClienteServices cs = new ClienteServices();
        ProveedorServices ps = new ProveedorServices();
        List<Proveedor> list = Seleccionarproveedor();
        if (!list.isEmpty()) {
            if (list.size() == 1) {
                //Con esto obtendremos al cliente en la posicion que selecciono el usuario para luego abrir una ventana emergente para su modificacion
                Proveedor aux = list.get(0);
                //Metodo probisorio para modificar
                pa.modificacionPrueba(ps.buscarProveedorPorId(aux.getId()));
                //Creamos nuevamente la ventana emergente para mostrar los datos
                DefaultOption option = new DefaultOption() {
                    @Override
                    public boolean closeWhenClickOutside() {
                        return true;
                    }
                };
                String actions[] = new String[]{"Cancelar", "Impirmir PDF"};
                GlassPanePopup.showPopup(new SimplePopupBorder(pa, "Productos asociados", actions, (pc, i) -> {
                    if (i == 1) {
                        ProductosAsociadosPDF pdf = new ProductosAsociadosPDF();
                        pdf.pdfPorPaciente(aux.getId());
                        pc.closePopup();
                    } else {
                        pc.closePopup();
                    }
                }), option);
            } else {
                MessageAlerts.getInstance().showMessage("Atencion", "Solamente puede ver los productos asociados de un proveedor a la vez", MessageAlerts.MessageType.DEFAULT);
            }
        } else {
            MessageAlerts.getInstance().showMessage("Error", "Seleccione un proveedor para mostrar la informacion solicitada", MessageAlerts.MessageType.WARNING);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    //Esta es la logica para que se aplique cuando se selecciona un proveedor o varios o ninguno.
    private List<Proveedor> Seleccionarproveedor() {
        try {
            List<Proveedor> list = new ArrayList<>();
            for (int i = 0; i < jTable.getRowCount(); i++) {
                if ((boolean) jTable.getValueAt(i, 0)) {
                    Proveedor data = (Proveedor) jTable.getValueAt(i, 2);
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
            ProveedorServices ps = new ProveedorServices();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            if (jTable.isEditing()) {
                jTable.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<Proveedor> list = ps.listaProveedores();
            for (Proveedor p : list) {
//                model.addRow(p.toTableRow(jTable.getRowCount() + 1));
                model.addRow(p.toTableRow(p.getId()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error metodo loadDATA() clase proveedor_Form");
        }
    }

    //Metodo la cual busca el cliente en el jTextField
    public void search(String search) {
        try {
            ProveedorServices ps = new ProveedorServices();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            if (jTable.isEditing()) {
                jTable.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<Proveedor> list = ps.barraBusqueda(search);
            for (Proveedor p : list) {
                model.addRow(p.toTableRow(jTable.getRowCount() + 1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error metodo loadDATA() clase proveedor_Form");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField;
    // End of variables declaration//GEN-END:variables
}
