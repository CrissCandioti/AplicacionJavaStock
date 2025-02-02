package com.raven.form;

import com.formdev.flatlaf.FlatClientProperties;
import com.raven.component.Form;
import com.raven.crud.NotasBaseDatos;
import com.raven.crud.UsuariosAgregarBaseDatos;
import com.raven.table.CheckBoxTableHeaderRenderer;
import com.raven.table.TableHeaderAlignment;
import entidades.Cliente;
import entidades.Notas;
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
import services.NotaServices;

public class EditNotas_Form extends Form {

    public EditNotas_Form() {
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
        jButton5 = new javax.swing.JButton();

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Estado", "#", "Fecha", "Nota"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
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
                .addGap(45, 497, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addGap(45, 45, 45))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
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

   //JButon para modificar una nota de la base de datos 
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            NotasBaseDatos UsuariosAgregarBaseDatos = new NotasBaseDatos();
            NotaServices cs = new NotaServices();
            List<Notas> list = Seleccionarusuario();
            if (!list.isEmpty()) {
                if (list.size() == 1) {
                    //Con esto obtendremos al cliente en la posicion que selecciono el usuario para luego abrir una ventana emergente para su modificacion
                    Notas aux = list.get(0);
                    //Metodo probisorio para modificar
                    UsuariosAgregarBaseDatos.modificacionPrueba(cs.buscarNotaPorID(aux.getId()));
                    //Creamos nuevamente la ventana emergente para mostrar los datos
                    DefaultOption option = new DefaultOption() {
                        @Override
                        public boolean closeWhenClickOutside() {
                            return true;
                        }
                    };
                    String actions[] = new String[]{"Cancelar", "Modificar"};
                    GlassPanePopup.showPopup(new SimplePopupBorder(UsuariosAgregarBaseDatos, "Modificar nota", actions, (pc, i) -> {
                        if (i == 1) {
                            if (UsuariosAgregarBaseDatos.retornarCliente() == null) {
                                MessageAlerts.getInstance().showMessage("Se produjo un error", "La nota no puedo modificarse, verifique y vuelva a intentarlo", MessageAlerts.MessageType.ERROR);
                            } else {
//                                cs.modificarCliente(UsuariosAgregarBaseDatos.retornarCliente().getId(), UsuariosAgregarBaseDatos.retornarCliente().getNombre(), UsuariosAgregarBaseDatos.retornarCliente().getApellido(), UsuariosAgregarBaseDatos.retornarCliente().getDocumento(), UsuariosAgregarBaseDatos.retornarCliente().getEmail(), UsuariosAgregarBaseDatos.retornarCliente().getWhatsapp(), UsuariosAgregarBaseDatos.retornarCliente().getLocalidad(), UsuariosAgregarBaseDatos.retornarCliente().getDireccion(), UsuariosAgregarBaseDatos.retornarCliente().getNotas());
                                cs.modificarNota(UsuariosAgregarBaseDatos.retornarCliente().getId(),UsuariosAgregarBaseDatos.retornarCliente().getFechaMensaje(), UsuariosAgregarBaseDatos.retornarCliente().getNota());
                                MessageAlerts.getInstance().showMessage("Se modifico correctamente", "La nota fue modificada correctamente", MessageAlerts.MessageType.SUCCESS);
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
    //JButton para eliminar la nota de la base de datos
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        List<Notas> list = Seleccionarusuario();
        NotaServices cs = new NotaServices();
        if (!list.isEmpty()) {
            DefaultOption option = new DefaultOption() {
                @Override
                public boolean closeWhenClickOutside() {
                    return true;
                }
            };
            String actions[] = new String[]{"Cancelar", "Eliminar"};
            JLabel label = new JLabel("Estas seguro que deseas eliminar de forma permanente a estas notas: " + list);
            label.setBorder(new EmptyBorder(0, 25, 0, 25));
            GlassPanePopup.showPopup(new SimplePopupBorder(label, "Confirmar eliminacion", actions, (pc, i) -> {
                if (i == 1) {
                    for (Notas aux : list) {
                        cs.borrarNota(aux);
                    }
                    MessageAlerts.getInstance().showMessage("Se elimino correctamente", "Las notas fueron eliminadas correctamente de la base de datos", MessageAlerts.MessageType.SUCCESS);
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

//JButton creado para recargar la tabla con los nuevos datos (si ocurre un problema al ingresar un nuevo usuario y no se muestra este boton hara ese trabajo) 
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        loadData();
    }//GEN-LAST:event_jButton5ActionPerformed

    //Esta es la logica para que se aplique cuando se selecciona un cliente o varios o ninguno.
    private List<Notas> Seleccionarusuario() {
        try {
            List<Notas> list = new ArrayList<>();
            for (int i = 0; i < jTable.getRowCount(); i++) {
                if ((boolean) jTable.getValueAt(i, 0)) {
                    Notas data = (Notas) jTable.getValueAt(i, 2);
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
            NotaServices cs = new NotaServices();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            if (jTable.isEditing()) {
                jTable.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<Notas> list = cs.listaNotas();

            // Configurar scroll horizontal y vertical
            jTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            jScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            jScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

            // Agregar los datos a la tabla
            for (Notas c : list) {
                model.addRow(c.toTableRow(c.getId()));
            }

            // Ajustar ancho de columnas basado en el contenido
            for (int column = 0; column < jTable.getColumnCount(); column++) {
                int maxWidth = 0;
                // Revisar el ancho del encabezado
                String headerValue = jTable.getColumnName(column);
                maxWidth = Math.max(maxWidth, headerValue.length() * 12); // Aumentado factor de multiplicación

                // Revisar el ancho del contenido
                for (int row = 0; row < jTable.getRowCount(); row++) {
                    Object value = jTable.getValueAt(row, column);
                    if (value != null) {
                        int width = String.valueOf(value).length() * 16; // Aumentado factor de multiplicación
                        maxWidth = Math.max(maxWidth, width);
                    }
                }
                // Establecer un ancho mínimo y máximo más amplio
                maxWidth = Math.max(75, Math.min(maxWidth + 30, 400));
                jTable.getColumnModel().getColumn(column).setPreferredWidth(maxWidth);
            }

            // Asegurar que la tabla se actualice visualmente
            jTable.revalidate();
            jTable.repaint();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de las notas, verifique la conexion a la base de datos");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
