/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.crud;

import entidades.Cliente;
import entidades.Compra;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.CompraServices;

/**
 *
 * @author criss
 */
public class HistorialCliente extends javax.swing.JPanel {

    /**
     * Creates new form HistorialCliente
     */
    public HistorialCliente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabelNombreCliente = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Cliente:");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Fecha y Hora", "Contenido", "Total", "Detalles"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jLabelNombreCliente.setText("Cliente en tabla");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelNombreCliente)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelNombreCliente))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    //Metodo para setear los valores
    public void historialCompraSeteoValores(Cliente aux) {
        jLabelNombreCliente.setText(aux.getNombre() + " " + aux.getApellido());
        loadData(aux.getId());
    }

    //Metodo la cual carga la tabla
    public void loadData(int id) {
        try {
            CompraServices cs = new CompraServices();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            if (jTable.isEditing()) {
                jTable.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<Compra> list = cs.listaCompraPorCliente(id);

            // Configurar scroll horizontal
            jTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            jScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            
            // Agregar los datos a la tabla
            for (Compra c : list) {
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
            JOptionPane.showMessageDialog(this, "Error al cargar el historial de compras: " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNombreCliente;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
