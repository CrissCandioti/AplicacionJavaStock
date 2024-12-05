package com.raven.form;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.raven.component.Form;
import com.raven.table.CheckBoxTableHeaderRenderer;
import com.raven.table.TableHeaderAlignment;
import entidades.Cliente;
import entidades.Productos;
import excel.ClientesExcel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import pdf.CompraPDF;
import raven.alerts.MessageAlerts;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import services.ClienteServices;
import services.CompraServices;
import services.ProductoServices;

public class Compra_Form extends Form {

    public Compra_Form() {
        initComponents();
        init();
    }

    private void init() {
        jTextFieldIdCliente.setVisible(false);

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

        jTextFieldBuscador.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar");
        jTextFieldBuscador.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("com/raven/icon/search.svg"));

        jTextFieldBuscador.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;");

        jTextFieldBuscadorProductos.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar");
        jTextFieldBuscadorProductos.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("com/raven/icon/search.svg"));
        jTextFieldBuscadorProductos.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;");

        jScrollPane.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
                + "background:$Table.background;");

        jLabel.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +5;");
        jLabel8.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +5;");
        jLabel11.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +5;");
        jLabel12.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +5;");
        jLabel14.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +5;");

        // Metodo para las celdas del cliente y enable boolean false
        styleCeldasCliente();

        jTable.getColumnModel().getColumn(0).setHeaderRenderer(new CheckBoxTableHeaderRenderer(jTable, 0));
        jTable.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(jTable));

        seteoComboBoxClientes();
        seteoComboBoxProductos();
        timerDate();
        ScrollBarComboBoxClientes();
        ScrollBarComboBoxProductos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButtonEliminarCliente = new javax.swing.JButton();
        jButtonBuscarCliente = new javax.swing.JButton();
        jLabel = new javax.swing.JLabel();
        jButtonPDFTabla = new javax.swing.JButton();
        jButtonExcelTabla = new javax.swing.JButton();
        jComboBoxClientes = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1ApellidoCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDocumentoCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldWhatsApp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldLocalidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldDireccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxProductos = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabelVerFechaYHora = new javax.swing.JLabel();
        jTextFieldNombreCliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldContenidoStock = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabeVerGanancia = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabelVerPorcentajeDeLaGanancia = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDetalles = new javax.swing.JTextArea();
        jTextFieldIdCliente = new javax.swing.JTextField();
        jTextFieldBuscador = new javax.swing.JTextField();
        jTextFieldBuscadorProductos = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Estado", "#", "Nombre", "Contenido", "Stock", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
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

        jButtonEliminarCliente.setText("Borrar");
        jButtonEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarClienteActionPerformed(evt);
            }
        });

        jButtonBuscarCliente.setText("Buscar");
        jButtonBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarClienteActionPerformed(evt);
            }
        });

        jLabel.setText("Ingrese el cliente");

        jButtonPDFTabla.setText("Imprimir recibo previa PDF");
        jButtonPDFTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPDFTablaActionPerformed(evt);
            }
        });

        jButtonExcelTabla.setText("Imprimir recibo previa Excel");
        jButtonExcelTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcelTablaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre cliente:");

        jLabel2.setText("Apellido cliente:");

        jLabel3.setText("Documento:");

        jLabel4.setText("Correo electronico");

        jLabel5.setText("WhatsApp:");

        jLabel6.setText("Localidad:");

        jLabel7.setText("Direccion:");

        jLabel8.setText("Ingrese el producto");

        jButton1.setText("Quitar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Añadir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Fecha y Hora:");

        jLabelVerFechaYHora.setText("Ver Fecha y hora");

        jLabel10.setText("Cantidad (Stock):");

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/8_s.png"))); // NOI18N
        jButton3.setText("Realizar compra");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel11.setText("Total a pagar:");

        jLabel12.setText("0.00");

        jLabel13.setText("Ganancias de la compra:");

        jLabeVerGanancia.setText("0,00");

        jLabel15.setText("Porcentaje de la ganancia:");

        jLabelVerPorcentajeDeLaGanancia.setText("NaN%");

        jLabel14.setText("Detalles");

        jTextAreaDetalles.setColumns(20);
        jTextAreaDetalles.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDetalles);

        jTextFieldBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscadorActionPerformed(evt);
            }
        });

        jTextFieldBuscadorProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscadorProductosActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/arrow-clockwise.png"))); // NOI18N
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
                .addGap(45, 45, 45)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(jComboBoxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldContenidoStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldBuscadorProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(jComboBoxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonBuscarCliente)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonEliminarCliente))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelVerFechaYHora))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonExcelTabla)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonPDFTabla)))
                        .addGap(45, 45, 45))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel)
                            .addComponent(jLabel8)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jTextFieldEmail)
                                    .addComponent(jTextFieldNombreCliente))
                                .addGap(32, 32, 32)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1ApellidoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jTextFieldWhatsApp, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                        .addGap(100, 100, 100))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelVerPorcentajeDeLaGanancia))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabeVerGanancia))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(379, 379, 379)
                .addComponent(jTextFieldIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabelVerFechaYHora))
                .addGap(18, 18, 18)
                .addComponent(jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEliminarCliente)
                    .addComponent(jButtonBuscarCliente)
                    .addComponent(jComboBoxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(25, 25, 25)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1ApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldWhatsApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jLabel10)
                            .addComponent(jTextFieldContenidoStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldBuscadorProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabeVerGanancia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabelVerPorcentajeDeLaGanancia))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(50, 50, 50)
                        .addComponent(jLabel14))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jTextFieldIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPDFTabla)
                    .addComponent(jButtonExcelTabla)
                    .addComponent(jButton3))
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

    //Jbutton para agregar los productos a la tabla
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        loadData();
        seteoJLabelGanancias();
        calcularYSetearPorcentajeGanancia();
    }//GEN-LAST:event_jButton2ActionPerformed
    //Metodo la cual al pulsar el JButton se realiza la compra
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            DefaultOption option = new DefaultOption() {
                @Override
                public boolean closeWhenClickOutside() {
                    return true;
                }
            };
            String actions[] = new String[]{"Cancelar", "Confirmar"};
            JLabel label = new JLabel("Estas seguro que deseas realizar esta compra?");
            label.setBorder(new EmptyBorder(0, 25, 0, 25));
            GlassPanePopup.showPopup(new SimplePopupBorder(label, "Confirmar compra", actions, (pc, i) -> {
                if (i == 1) {
                    //Variables para utilizar
                    CompraPDF pdf = new CompraPDF();
                    ProductoServices ps = new ProductoServices();
                    ClienteServices cs = new ClienteServices();
                    Productos aux = null;
                    Cliente index = null;
                    CompraServices css = new CompraServices();

                    //Logica para obtener el cliente
                    index = cs.buscarClienteID(Integer.parseInt(jTextFieldIdCliente.getText()));
                    //Metodo que me retorna la fecha y hora actual obtenerFechaHoraActual();
                    //Variale la cual se obtiene lo del campo detalles
                    String detalles = jTextAreaDetalles.getText();
                    //Total a pagar
                    double total = Double.parseDouble(jLabel12.getText());
                    //Llamamos a CompraServices para ejecutar la compra
                    css.persistirEntidad(obtenerFechaHoraActual(), index, listaProductos(), cantidadComprada(), detalles, total);
                    pdf.facturacionPDF(index, obtenerFechaHoraActual(), listaProductos(), total);
                    refrescar();
                    pc.closePopup();
                } else {
                    MessageAlerts.getInstance().showMessage("Compra cancelada", "La compra fue cancelada", MessageAlerts.MessageType.WARNING);
                    pc.closePopup();
                }
            }), option);
        } catch (NumberFormatException e) {
            MessageAlerts.getInstance().showMessage("Error al realizar la compra", "No selecciono un cliente", MessageAlerts.MessageType.ERROR);
        } catch (Exception f) {
            MessageAlerts.getInstance().showMessage("Error al realizar la compra", "Verifique los datos e intente nuevamente", MessageAlerts.MessageType.ERROR);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    //JTextfield la cual busca al cliente en el comboBox
    private void jTextFieldBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscadorActionPerformed
        // Lógica para buscar clientes por nombre en el jComboBoxClientes mientras el usuario escribe
        ClienteServices cs = new ClienteServices();
        String busqueda = jTextFieldBuscador.getText().toLowerCase();
        DefaultComboBoxModel<Cliente> model = (DefaultComboBoxModel<Cliente>) jComboBoxClientes.getModel();
        model.removeAllElements();

        for (Cliente cliente : cs.listaCliente()) {
            String nombreCompleto = (cliente.getNombre() + " " + cliente.getApellido()).toLowerCase();
            if (nombreCompleto.contains(busqueda)) {
                model.addElement(cliente);
            }
        }

        if (model.getSize() > 0) {
            jComboBoxClientes.setSelectedIndex(0);
            jComboBoxClientes.showPopup();
        } else {
            jComboBoxClientes.hidePopup();
        }
    }//GEN-LAST:event_jTextFieldBuscadorActionPerformed
    //JTexfield la cual busca el producto por el nombre
    private void jTextFieldBuscadorProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscadorProductosActionPerformed
        // Lógica para buscar productos por nombre en el jComboBoxProductos mientras el usuario escribe
        ProductoServices ps = new ProductoServices();
        String busqueda = jTextFieldBuscadorProductos.getText().toLowerCase();
        DefaultComboBoxModel<Productos> model = (DefaultComboBoxModel<Productos>) jComboBoxProductos.getModel();
        model.removeAllElements();

        for (Productos producto : ps.listaProductos()) {
            String nombreProducto = producto.getNombre().toLowerCase();
            if (nombreProducto.contains(busqueda)) {
                model.addElement(producto);
            }
        }

        if (model.getSize() > 0) {
            jComboBoxProductos.setSelectedIndex(0);
            jComboBoxProductos.showPopup();
        } else {
            jComboBoxProductos.hidePopup();
        }
    }//GEN-LAST:event_jTextFieldBuscadorProductosActionPerformed
//Metodo la cual refresca la pestaña
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            refrescar();
        } catch (Exception e) {
            System.out.println("Error al refrescar la página: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    //JButton para quitar el producto de la lista
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Lógica para eliminar productos seleccionados de la tabla
        DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();
        int filas = jTable.getRowCount();

        for (int i = filas - 1; i >= 0; i--) {
            Boolean seleccionado = (Boolean) jTable.getValueAt(i, 0);
            if (seleccionado) {
                modelo.removeRow(i);
            }
        }

        // Actualizar la tabla
        jTable.setModel(modelo);
        jTable.repaint();

        // Actualizar cálculos si es necesario
        seteoJLabelGanancias();
        seteoJLabelTotal();
        calcularYSetearPorcentajeGanancia();
    }

    // JButon que llama a un metodo para setear las celdas del cliente
    private void jButtonBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {
        setCeldasCliente();
    }

    // JButton que llama a un metodo para setear todos los valores de las celdas de
    // los clientes pero en este caso los deja vacio
    private void jButtonEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {
        setCeldasClienteEmpty();
    }

    //Jbutton para crear el pdf
    private void jButtonPDFTablaActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            CompraPDF pdf = new CompraPDF();
            Double total = Double.parseDouble(jLabel12.getText());
            System.out.println(listaProductos());
            pdf.pdfPresupuesto(obtenerFechaHoraActual(), listaProductos(), total);
            refrescar();
        } catch (Exception e) {
            System.out.println("Error en el metodo crear pdf de presupuesto:" + e.fillInStackTrace());
        }
    }

    //JButon para crear el excel
    private void jButtonExcelTablaActionPerformed(java.awt.event.ActionEvent evt) {
        ClientesExcel ce = new ClientesExcel();
        ce.TablaClientesExcelReporte();
    }

    // Metodo la cual carga la tabla con los prodcutos seleccionado por el usuario
    public void loadData() {
        try {
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            if (jTable.isEditing()) {
                jTable.getCellEditor().stopCellEditing();
            }

            Productos productoSeleccionado = (Productos) jComboBoxProductos.getSelectedItem();
            int cantidad = Integer.parseInt(jTextFieldContenidoStock.getText());

            // Verificar si el producto ya existe en la tabla
            boolean productoExistente = false;
            for (int i = 0; i < model.getRowCount(); i++) {
                int idProductoEnTabla = (int) model.getValueAt(i, 1); // Asumiendo que el ID está en la columna 1
                if (idProductoEnTabla == productoSeleccionado.getId()) {
                    productoExistente = true;
                    break;
                }
            }

            if (productoExistente) {
                MessageAlerts.getInstance().showMessage("Error", "Este producto ya ha sido agregado a la tabla", MessageAlerts.MessageType.ERROR);
                return;
            }

            if (productoSeleccionado != null) {
                if (cantidad <= productoSeleccionado.getStock()) {
                    Object[] fila = productoSeleccionado.toTableRowCompraForm(productoSeleccionado.getId());
                    fila[4] = cantidad; // Asumiendo que la columna 3 es la cantidad
                    model.addRow(fila);
                } else {
                    MessageAlerts.getInstance().showMessage("Error en la cantidad (stock)", "La cantidad que desea añadir es superior a la disponible" + "\nStock del producto disponible: " + productoSeleccionado.getStock() + "\nCantidad que desea ingresar: " + cantidad, MessageAlerts.MessageType.ERROR);
                }
            }
            seteoJLabelTotal();
        } catch (NumberFormatException e) {
            MessageAlerts.getInstance().showMessage("Importante", "Seleccione la cantidad(stock)", MessageAlerts.MessageType.WARNING);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al agregar el producto a la tabla");
            e.printStackTrace();
        }
    }

    //Metodo la cual me retorna los productos de la tabla para el pdf u excel
    public List<Productos> listaProductos() {
        try {
            //Logica para obtener la lista de la Jtable
            ProductoServices ps = new ProductoServices();
            List<Productos> listaProductos = new ArrayList<>();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            int rowCount = model.getRowCount();

            for (int i = 0; i < rowCount; i++) {
                int codigo = (int) model.getValueAt(i, 1);
                int stockIngresado = (int) model.getValueAt(i, 4);
                double precioVenta = (double) model.getValueAt(i, 5);

                // Calcular el total para este producto
                double totalProducto = precioVenta * stockIngresado;

                // Busca el producto con el codigo u id, y setea stock ingresado y el total calculado
                Productos aux = ps.buscarProductoPorID(codigo);
                aux.setStock(stockIngresado);
                aux.setPrecioventa(totalProducto);
                listaProductos.add(aux);
            }
            return listaProductos;
        } catch (Exception e) {
            System.out.println("Error en la lista de productos de la clase Compra_Form: " + e.getMessage());
        }
        return null;
    }

    //Metodo la cual obtengo la cantidad de stock comprada de los productos
    public List<Integer> cantidadComprada() {
        try {
            List<Integer> cantidadComprada = new ArrayList<>();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            int rowCount = model.getRowCount();

            for (int i = 0; i < rowCount; i++) {
                int cantidadIngresado = (int) model.getValueAt(i, 4);
                cantidadComprada.add(cantidadIngresado);
            }
            return cantidadComprada;
        } catch (Exception e) {
            System.out.println("Error en el metodo cantidadComrpada de la clase compra_Form");
            System.out.println(e.fillInStackTrace());
        }
        return null;
    }

    // Seteo para el comboBox de los clientes
    public void seteoComboBoxClientes() {
        try {
            ClienteServices cs = new ClienteServices();
            for (Cliente aux : cs.listaCliente()) {
                jComboBoxClientes.addItem(aux);
            }
        } catch (Exception e) {
            System.out.println(
                    "Error en el metodo seteoComboBoxClientes() de la clase compra_form: " + e.fillInStackTrace());
        }
    }

    // Metodo para setear los valores del comboBox de los productos
    public void seteoComboBoxProductos() {
        try {
            ProductoServices ps = new ProductoServices();
            for (Productos pro : ps.listaProductos()) {
                jComboBoxProductos.addItem(pro);
            }
        } catch (Exception e) {
            System.out.println(
                    "Error en el metodo seteoComboBoxClientes() de la clase compra_form: " + e.fillInStackTrace());
        }
    }

    // Timer para el date
    public void timerDate() {
        try {
            // Crear el formato de fecha
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

            // Crear un ActionListener para actualizar la hora
            ActionListener updateTime = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtener la fecha y hora actual
                    Date now = new Date();
                    // Formatear la fecha y hora
                    String formattedDate = dateFormat.format(now);
                    // Imprimir la fecha y hora formateada
                    jLabelVerFechaYHora.setText(formattedDate);
                }
            };

            // Crear un Timer que llame al ActionListener cada 1000 milisegundos (1 segundo)
            Timer timer = new Timer(1000, updateTime);
            // Iniciar el Timer
            timer.start();
        } catch (Exception e) {
        }
    }

    // Metodo con los estilos de las celdas del dato del cliente
    public void styleCeldasCliente() {
        try {
            jTextFieldNombreCliente.putClientProperty(FlatClientProperties.STYLE, ""
                    + "arc:15;"
                    + "borderWidth:0;"
                    + "focusWidth:0;"
                    + "innerFocusWidth:0;");
            jTextField1ApellidoCliente.putClientProperty(FlatClientProperties.STYLE, ""
                    + "arc:15;"
                    + "borderWidth:0;"
                    + "focusWidth:0;"
                    + "innerFocusWidth:0;");
            jTextFieldDocumentoCliente.putClientProperty(FlatClientProperties.STYLE, ""
                    + "arc:15;"
                    + "borderWidth:0;"
                    + "focusWidth:0;"
                    + "innerFocusWidth:0;");
            jTextFieldEmail.putClientProperty(FlatClientProperties.STYLE, ""
                    + "arc:15;"
                    + "borderWidth:0;"
                    + "focusWidth:0;"
                    + "innerFocusWidth:0;");
            jTextFieldWhatsApp.putClientProperty(FlatClientProperties.STYLE, ""
                    + "arc:15;"
                    + "borderWidth:0;"
                    + "focusWidth:0;"
                    + "innerFocusWidth:0;");
            jTextFieldLocalidad.putClientProperty(FlatClientProperties.STYLE, ""
                    + "arc:15;"
                    + "borderWidth:0;"
                    + "focusWidth:0;"
                    + "innerFocusWidth:0;");
            jTextFieldDireccion.putClientProperty(FlatClientProperties.STYLE, ""
                    + "arc:15;"
                    + "borderWidth:0;"
                    + "focusWidth:0;"
                    + "innerFocusWidth:0;");
            jTextFieldNombreCliente.setEnabled(false);
            jTextField1ApellidoCliente.setEnabled(false);
            jTextFieldDocumentoCliente.setEnabled(false);
            jTextFieldEmail.setEnabled(false);
            jTextFieldWhatsApp.setEnabled(false);
            jTextFieldLocalidad.setEnabled(false);
            jTextFieldDireccion.setEnabled(false);
        } catch (Exception e) {
            System.out.println("Error en el metodo styleCeldasCliente() de la clase compra_form");
        }
    }

    // Metodo para seter los valores de las celdas traida con el comboBox del
    // cliente
    public void setCeldasCliente() {
        try {
            Cliente aux = (Cliente) jComboBoxClientes.getSelectedItem();
            jTextFieldIdCliente.setText(String.valueOf(aux.getId()));
            jTextFieldNombreCliente.setText(aux.getNombre());
            jTextField1ApellidoCliente.setText(aux.getApellido());
            jTextFieldDocumentoCliente.setText(String.valueOf(aux.getDocumento()));
            jTextFieldEmail.setText(aux.getEmail());
            jTextFieldWhatsApp.setText(aux.getWhatsapp());
            jTextFieldLocalidad.setText(aux.getLocalidad());
            jTextFieldDireccion.setText(aux.getDireccion());
        } catch (Exception e) {
            System.out.println("Error en el metodo setCeldasCliente() de la clase Compra_Form");
        }
    }

    //Metod creado para setear las celdas
    public void setCeldasClienteEmpty() {
        try {
            jTextFieldIdCliente.setText("");
            jTextFieldNombreCliente.setText("");
            jTextField1ApellidoCliente.setText("");
            jTextFieldDocumentoCliente.setText("");
            jTextFieldEmail.setText("");
            jTextFieldWhatsApp.setText("");
            jTextFieldLocalidad.setText("");
            jTextFieldDireccion.setText("");
        } catch (Exception e) {
            System.out.println("Error en el metodo setCeldasClienteEmpty() de la clase Compra_Form");
        }
    }

    //Metodo la cual se crea la scroll bar para el comboBox de los CLientes
    public void ScrollBarComboBoxClientes() {
        try {
            // Configurar el ComboBox de clientes para mostrar 3 elementos
            jComboBoxClientes.setMaximumRowCount(3);

            // Personalizar el renderizador para mostrar solo el nombre del cliente
            jComboBoxClientes.setRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if (value instanceof Cliente) {
                        Cliente cliente = (Cliente) value;
                        setText(cliente.getNombre() + " " + cliente.getApellido());
                    }
                    return this;
                }
            });

            // Agregar una barra de desplazamiento al popup del ComboBox
            Object comp = jComboBoxClientes.getUI().getAccessibleChild(jComboBoxClientes, 0);
            if (comp instanceof JPopupMenu) {
                JPopupMenu popup = (JPopupMenu) comp;
                JScrollPane scrollPane = (JScrollPane) popup.getComponent(0);
                scrollPane.setHorizontalScrollBar(new JScrollBar(JScrollBar.HORIZONTAL));
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo ScrollBarComboBoxClientes() de la clase Compra_Form");
        }
    }

    //Metodo la cual se crea una scroll bar para los productos
    public void ScrollBarComboBoxProductos() {
        try {
            jComboBoxProductos.setMaximumRowCount(3);
            jComboBoxProductos.setRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if (value instanceof Productos) {
                        Productos producto = (Productos) value;
                        setText(producto.getNombre()); // Asumiendo que Productos tiene un método getNombre()
                    }
                    return this;
                }
            });

            // Agregar una barra de desplazamiento al popup del ComboBox
            Object comp = jComboBoxProductos.getUI().getAccessibleChild(jComboBoxProductos, 0);
            if (comp instanceof JPopupMenu) {
                JPopupMenu popup = (JPopupMenu) comp;
                JScrollPane scrollPane = (JScrollPane) popup.getComponent(0);
                scrollPane.setHorizontalScrollBar(new JScrollBar(JScrollBar.HORIZONTAL));
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            }
        } catch (Exception e) {
            System.out.println("Error en el método ScrollBarComboBoxProductos() de la clase Compra_Form");
            e.printStackTrace();
        }
    }

    //Metodo creado para setear el label para obtener el total
    public void seteoJLabelTotal() {
        try {
            double total = 0.0;
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            int rowCount = model.getRowCount();

            for (int i = 0; i < rowCount; i++) {
                Object precioObj = model.getValueAt(i, 5); // Obtengo el precio que esta en la columna 5
                Object cantidadObj = model.getValueAt(i, 4); // Obtengo la cantidad que esta en la columna 4

                if (precioObj instanceof Double && cantidadObj instanceof Integer) {
                    double precio = (Double) precioObj;
                    int cantidad = (Integer) cantidadObj;
                    total += precio * cantidad;
                }
            }

            jLabel12.setText(String.format(Locale.US, "%.2f", total));
        } catch (Exception e) {
            System.out.println("Error en el método seteoJLabelGananciaPorcentajeTotal() de la clase Compra_Form");
            e.printStackTrace();
        }
    }

    //Metodo creado para setear el jlabel para obtener la ganancia
    public void seteoJLabelGanancias() {
        try {
            ProductoServices ps = new ProductoServices();
            double gananciaTotal = 0.0;
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            int rowCount = model.getRowCount();
            Productos aux = null;

            for (int i = 0; i < rowCount; i++) {
                Object codigo = model.getValueAt(i, 1); // Obtenemos el codigo de la base de datos para obtener el precio de venta
                Object cantidadObj = model.getValueAt(i, 4); // Obtenemos la cantidad(stock)

                if (cantidadObj instanceof Integer) {
                    aux = ps.buscarProductoPorID((int) codigo);
                    double precioCompra = aux.getPrecioCosto();
                    double precioVenta = aux.getPrecioventa();
                    int cantidad = (Integer) cantidadObj;
                    double gananciaProducto = (precioVenta - precioCompra) * cantidad;
                    gananciaTotal += gananciaProducto;
                }
            }

            jLabeVerGanancia.setText(String.format("%.2f", gananciaTotal));
        } catch (Exception e) {
            System.out.println("Error en el método seteoJLabelGanancias() de la clase Compra_Form");
            e.printStackTrace();
        }
    }

    // Método para obtener la fecha y hora actual
    public Date obtenerFechaHoraActual() {
        try {
            return new Date();
        } catch (Exception e) {
            System.out.println("Error en el método obtenerFechaHoraActual() de la clase Compra_Form");
            e.printStackTrace();
            return null;
        }
    }

    // Método para calcular y setear el porcentaje de ganancia
    public void calcularYSetearPorcentajeGanancia() {
        try {
            ProductoServices ps = new ProductoServices();
            double totalCompra = 0.0;
            double totalVenta = 0.0;
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            int rowCount = model.getRowCount();
            Productos aux = null;

            for (int i = 0; i < rowCount; i++) {
                Object codigo = model.getValueAt(i, 1);
                Object cantidadObj = model.getValueAt(i, 4);

                if (cantidadObj instanceof Integer) {
                    aux = ps.buscarProductoPorID((int) codigo);
                    double precioCompra = aux.getPrecioCosto();
                    double precioVenta = aux.getPrecioventa();
                    int cantidad = (Integer) cantidadObj;
                    totalCompra += precioCompra * cantidad;
                    totalVenta += precioVenta * cantidad;
                }
            }

            double ganancia = totalVenta - totalCompra;
            double porcentajeGanancia = (ganancia / totalCompra) * 100;

            jLabelVerPorcentajeDeLaGanancia.setText(String.format("%.2f%%", porcentajeGanancia));
        } catch (Exception e) {
            System.out.println("Error en el método calcularYSetearPorcentajeGanancia() de la clase Compra_Form");
            e.printStackTrace();
        }
    }

    //Metodo crado para refrescar una vez realizada la compra y para el JButton refrescar
    public void refrescar() {
        try {
            // Limpiar la tabla
            DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();
            modelo.setRowCount(0);
            jTable.setModel(modelo);

            // Limpiar detalles y totales
            jLabel12.setText("0.00"); // Total
            jLabeVerGanancia.setText("0,00"); // Ganancias
            jLabelVerPorcentajeDeLaGanancia.setText("NaN%"); // Porcentaje ganancia

            // Limpiar datos del cliente
            setCeldasClienteEmpty();

            // Actualizar stock en combobox productos
            ProductoServices ps = new ProductoServices();
            DefaultComboBoxModel<Productos> modeloProductos = new DefaultComboBoxModel<>();
            for (Productos producto : ps.listaProductos()) {
                modeloProductos.addElement(producto);
            }
            jComboBoxProductos.setModel(modeloProductos);

            // Actualizar combobox clientes
            ClienteServices cs = new ClienteServices();
            DefaultComboBoxModel<Cliente> modeloClientes = new DefaultComboBoxModel<>();
            for (Cliente cliente : cs.listaCliente()) {
                modeloClientes.addElement(cliente);
            }
            jComboBoxClientes.setModel(modeloClientes);

            // Limpiar buscadores
            jTextFieldBuscador.setText("");
            jTextFieldBuscadorProductos.setText("");
            jTextFieldContenidoStock.setText("");
            jTextAreaDetalles.setText("");
        } catch (Exception e) {
            System.out.println("Error en el metodo refrescar del metodo Compra_Form: " + e.fillInStackTrace());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonBuscarCliente;
    private javax.swing.JButton jButtonEliminarCliente;
    private javax.swing.JButton jButtonExcelTabla;
    private javax.swing.JButton jButtonPDFTabla;
    private javax.swing.JComboBox<Cliente> jComboBoxClientes;
    private javax.swing.JComboBox<Productos> jComboBoxProductos;
    private javax.swing.JLabel jLabeVerGanancia;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelVerFechaYHora;
    private javax.swing.JLabel jLabelVerPorcentajeDeLaGanancia;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextArea jTextAreaDetalles;
    private javax.swing.JTextField jTextField1ApellidoCliente;
    private javax.swing.JTextField jTextFieldBuscador;
    private javax.swing.JTextField jTextFieldBuscadorProductos;
    private javax.swing.JTextField jTextFieldContenidoStock;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldDocumentoCliente;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldIdCliente;
    private javax.swing.JTextField jTextFieldLocalidad;
    private javax.swing.JTextField jTextFieldNombreCliente;
    private javax.swing.JTextField jTextFieldWhatsApp;
    // End of variables declaration//GEN-END:variables
}
