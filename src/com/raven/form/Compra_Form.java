package com.raven.form;

import com.formdev.flatlaf.FlatClientProperties;
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
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import pdf.ClientePDF;
import services.ClienteServices;
import services.ProductoServices;

public class Compra_Form extends Form {

    public Compra_Form() {
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
        ScrollBarComboBoxProductos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
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
        jTextArea1 = new javax.swing.JTextArea();

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

        jButtonPDFTabla.setText("Imprimir factura previa PDF");
        jButtonPDFTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPDFTablaActionPerformed(evt);
            }
        });

        jButtonExcelTabla.setText("Imprimir factura previa Excel");
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

        jLabel11.setText("Total a pagar:");

        jLabel12.setText("Ver total");

        jLabel13.setText("Ganancias de la compra:");

        jLabeVerGanancia.setText("Ver ganancias");

        jLabel15.setText("Porcentaje de la ganancia:");

        jLabelVerPorcentajeDeLaGanancia.setText("Ver porcentaje de la ganancia");

        jLabel14.setText("Detalles");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(jComboBoxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jComboBoxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jTextFieldContenidoStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    }//GEN-LAST:event_jButton2ActionPerformed

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
        ClientePDF pdf = new ClientePDF();
        pdf.pdfTablaProveedores();
    }
    //JButon para crear el excel
    private void jButtonExcelTablaActionPerformed(java.awt.event.ActionEvent evt) {
        ClientesExcel ce = new ClientesExcel();
        ce.TablaClientesExcelReporte();
    }

    // Esta es la logica para que se aplique cuando se selecciona un cliente o
    // varios o ninguno.
    private List<Cliente> SeleccionarProducto() {
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

    // Metodo la cual carga la tabla con los prodcutos seleccionado por el usuario
    public void loadData() {
        try {
            ProductoServices ps = new ProductoServices();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            if (jTable.isEditing()) {
                jTable.getCellEditor().stopCellEditing();
            }
            
            Productos productoSeleccionado = (Productos) jComboBoxProductos.getSelectedItem();
            if (productoSeleccionado != null) {
                int cantidad = Integer.parseInt(jTextFieldContenidoStock.getText());
                Object[] fila = productoSeleccionado.toTableRowCompraForm(productoSeleccionado.getId());
                fila[4] = cantidad; // Asumiendo que la columna 3 es la cantidad
                model.addRow(fila);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione un producto");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una cantidad válida en el campo de stock");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al agregar el producto a la tabla");
            e.printStackTrace();
        }
    }

    // Metodo la cual busca el cliente en el jTextField
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

    public void setCeldasClienteEmpty() {
        try {
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

    //Metodo la cual se crea una scroll bar para los productos
    public void ScrollBarComboBoxProductos() {
        // Configurar el ComboBox de productos para mostrar 3 elementos y agregar una barra de desplazamiento
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1ApellidoCliente;
    private javax.swing.JTextField jTextFieldContenidoStock;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldDocumentoCliente;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldLocalidad;
    private javax.swing.JTextField jTextFieldNombreCliente;
    private javax.swing.JTextField jTextFieldWhatsApp;
    // End of variables declaration//GEN-END:variables
}
