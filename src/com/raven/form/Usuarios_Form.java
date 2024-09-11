package com.raven.form;

import com.formdev.flatlaf.FlatClientProperties;
import com.raven.component.Form;
import javax.swing.table.DefaultTableModel;

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

        testData();
    }

    private void testData() {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();

        model.addRow(new Object[]{false, 1, "Hanna", "Chambers"});
        model.addRow(new Object[]{true, 2, "Hanna", "Chambers"});
        model.addRow(new Object[]{true, 3, "Hanna", "Chambers", "20-august-2020", "Saumerios", "Compra de todo"});
        model.addRow(new Object[]{true, 4, "Hanna", "Chambers", "20-august-2020", "Saumerios", "Compra de todo"});
        model.addRow(new Object[]{true, 5, "Hanna", "Chambers", "20-august-2020", "Saumerios", "Compra de todo"});
        model.addRow(new Object[]{true, 6, "Hanna", "Chambers", "20-august-2020", "Saumerios", "Compra de todo"});
        model.addRow(new Object[]{true, 7, "Hanna", "Chambers", "20-august-2020", "Saumerios", "Compra de todo"});
        model.addRow(new Object[]{true, 8, "Hanna", "Chambers", "20-august-2020", "Saumerios", "Compra de todo"});
        model.addRow(new Object[]{true, 9, "Hanna", "Chambers", "20-august-2020", "Saumerios", "Compra de todo"});
        model.addRow(new Object[]{true, 10, "Hanna", "Chambers", "20-august-2020", "Saumerios", "Compra de todo"});
        model.addRow(new Object[]{true, 11, "Hanna", "Chambers", "20-august-2020", "Saumerios", "Compra de todo"});
        model.addRow(new Object[]{true, 12, "Hanna", "Chambers", "20-august-2020", "Saumerios", "Compra de todo"});
        model.addRow(new Object[]{true, 13, "Hanna", "Chambers", "20-august-2020", "Saumerios", "Compra de todo"});
        model.addRow(new Object[]{true, 14, "Hanna", "Chambers", "20-august-2020", "Saumerios", "Compra de todo"});
        model.addRow(new Object[]{true, 15, "anna", "Chambers", "20-august-2020", "Saumerios", "Compra de todo"});
        model.addRow(new Object[]{true, 16, "anna", "Chambers", "20-august-2020", "Saumerios", "Compra de todo"});
        model.addRow(new Object[]{true, 17, "anna", "Chambers", "20-august-2020", "Saumerios", "Compra de todo"});
        model.addRow(new Object[]{true, 18, "anna", "Chambers", "20-august-2020", "Saumerios", "Compra de todo"});

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
        jTextField1 = new javax.swing.JTextField();

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Title 2", "Title 3", "Title 4"
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

        jButton1.setText("Eliminar");

        jButton2.setText("Modificar");

        jButton3.setText("Agregar");

        jTextField1.setText("Ingrese el nombre del cliente");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addGap(100, 100, 100))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(45, 45, 45))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
