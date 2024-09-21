package com.raven.form;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.raven.component.Form;
import com.raven.crud.HistorialCliente;
import com.raven.crud.UsuariosAgregarBaseDatos;
import com.raven.table.CheckBoxTableHeaderRenderer;
import com.raven.table.TableHeaderAlignment;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import raven.alerts.MessageAlerts;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;

public class Usuarios_Form extends Form {

    public Usuarios_Form() {
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
        testData();

    }

    private void testData() {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();

        model.addRow(new Object[]{true, "1", "Leslie", "Petreli", "13123321", "l@hotmail.com", "03424123321", "ST", "ST 4321", "Exellente clienta"});
        model.addRow(new Object[]{true, "2", "Marco", "MERLO", "13123321", "l@hotmail.com", "03424123321", "ST", "ST 4321", "Exellente clienta"});
        model.addRow(new Object[]{true, "3", "Polo", "MARON", "13123321", "l@hotmail.com", "03424123321", "ST", "ST 4321", "Exellente clienta"});
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
        jButton4 = new javax.swing.JButton();
        jLabel = new javax.swing.JLabel();

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

        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Historial");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel.setText("Ingrese el nombre del cliente");

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

    @SuppressWarnings("empty-statement")
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        UsuariosAgregarBaseDatos agregar = new UsuariosAgregarBaseDatos();
        DefaultOption option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }
        };
        String actions[] = new String[]{"Cancelar", "Guardar"};
        GlassPanePopup.showPopup(new SimplePopupBorder(agregar, "Guardar cliente", actions, (pc, i) -> {
            if (i == 1) {
                MessageAlerts.getInstance().showMessage("Se agrego correctamente", "El cliente fue agregado correctamente a la base de datos", MessageAlerts.MessageType.SUCCESS);
            } else {
                pc.closePopup();
            }
        }), option);
    }//GEN-LAST:event_jButton3ActionPerformed
//Este es el action listener para el boton modificar
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        UsuariosAgregarBaseDatos UsuariosAgregarBaseDatos = new UsuariosAgregarBaseDatos();
        UsuariosAgregarBaseDatos agregar = new UsuariosAgregarBaseDatos();
        List<Object> list = Seleccionarusuario();
        if (!list.isEmpty()) {
            if (list.size() == 1) {
                //Con esto obtendremos al cliente en la posicion que selecciono el usuario para luego abrir una ventana emergente para su modificacion
                Object data = list.get(0);
                //Metodo probisorio para modificar
                UsuariosAgregarBaseDatos.modificacionPrueba(data);
                //Creamos nuevamente la ventana emergente para mostrar los datos
                DefaultOption option = new DefaultOption() {
                    @Override
                    public boolean closeWhenClickOutside() {
                        return true;
                    }
                };
                String actions[] = new String[]{"Cancelar", "Modificar"};
                GlassPanePopup.showPopup(new SimplePopupBorder(agregar, "Modificar cliente", actions, (pc, i) -> {
                    if (i == 1) {
                        MessageAlerts.getInstance().showMessage("Se agrego correctamente", "El cliente fue agregado correctamente a la base de datos", MessageAlerts.MessageType.SUCCESS);
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        List<Object> list = Seleccionarusuario();
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
//                    for (Object aux : list) {
//                        llamamos luego al metodo que va a eliminr por id dentro del bucle para eliminar uno por uno a esos clientes
//                    }
                    MessageAlerts.getInstance().showMessage("Se elimino correctamente de la base de datos", "El cliente fue agregado correctamente a la base de datos", MessageAlerts.MessageType.SUCCESS);
                    pc.closePopup();
                } else {
                    pc.closePopup();
                }
            }), option);
        } else {
            MessageAlerts.getInstance().showMessage("Error", "Seleccione un cliente para su eliminacion", MessageAlerts.MessageType.WARNING);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        HistorialCliente historialcliente = new HistorialCliente();
        List<Object> list = Seleccionarusuario();
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
    }//GEN-LAST:event_jButton4ActionPerformed
//Esta es la logica para que se aplique cuando se selecciona un cliente o varios o ninguno.

    private List<Object> Seleccionarusuario() {
        try {
            List<Object> list = new ArrayList<>();
            for (int i = 0; i < jTable.getRowCount(); i++) {
                if ((boolean) jTable.getValueAt(i, 0)) {
                    Object data = (Object) jTable.getValueAt(i, 2);
                    list.add(data);
                }
            }
            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error lista");
        }
        return null;
    }

    private void cargarTablaClientes() {
        try {
//En el proyecto servicioSacerdotal en la clase ConsultaGuardinaes tenemos un ejemplo de como llenar una tabla.
//O sino mirar el video Java Swing and MySQL | Select, Insert, Delete, Update and Desing using FlatLaf - Part #3 en el minuto 3:02 para otro ejemplo.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error cargar tabla metodo: cargarTablaClientes() ; clase Usuarios_Form");
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
