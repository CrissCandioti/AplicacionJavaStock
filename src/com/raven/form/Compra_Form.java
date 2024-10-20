package com.raven.form;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.raven.component.Form;
import com.raven.crud.UsuariosAgregarBaseDatos;
import com.raven.table.CheckBoxTableHeaderRenderer;
import com.raven.table.TableHeaderAlignment;
import entidades.Cliente;
import entidades.Productos;
import excel.ClientesExcel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        jTextFieldNombreCliente.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar");
        jTextFieldNombreCliente.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("com/raven/icon/search.svg"));

        jTextFieldNombreCliente.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;");

        jTable.getColumnModel().getColumn(0).setHeaderRenderer(new CheckBoxTableHeaderRenderer(jTable, 0));
        jTable.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(jTable));
        loadData();
        seteoComboBoxClientes();
        seteoComboBoxProductos();
        timerDate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButtonEliminarCliente = new javax.swing.JButton();
        jButtonBuscarCliente = new javax.swing.JButton();
        jTextFieldNombreCliente = new javax.swing.JTextField();
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

        jButtonEliminarCliente.setText("Eliminar");
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

        jTextFieldNombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldNombreClienteKeyReleased(evt);
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

        jLabel1.setText("Nombre cliente:");

        jLabel2.setText("Apellido cliente:");

        jLabel3.setText("Documento:");

        jLabel4.setText("Correo electronico");

        jLabel5.setText("WhatsApp:");

        jLabel6.setText("Localidad:");

        jLabel7.setText("Direccion:");

        jLabel8.setText("Ingrese el producto");

        jButton1.setText("Eliminar");

        jButton2.setText("Añadir");

        jLabel9.setText("Fecha y Hora:");

        jLabelVerFechaYHora.setText("Ver Fecha y hora");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                .addGap(100, 100, 100))
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(jComboBoxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelVerFechaYHora))
                                    .addGroup(jPanelLayout.createSequentialGroup()
                                        .addComponent(jButtonExcelTabla)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonPDFTabla)))))
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
                                    .addComponent(jTextFieldNombreCliente)
                                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jTextFieldEmail))
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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                    .addComponent(jTextFieldNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1ApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonPDFTabla)
                            .addComponent(jButtonExcelTabla)))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
    private void jButtonBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarClienteActionPerformed
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
    }//GEN-LAST:event_jButtonBuscarClienteActionPerformed
    //JButton para eliminar el cliente de la base de datos
    private void jButtonEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarClienteActionPerformed
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
    }//GEN-LAST:event_jButtonEliminarClienteActionPerformed

    //jTextField la cual buscaremos el cliente por nombre o apellido
    private void jTextFieldNombreClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreClienteKeyReleased
        search(jTextFieldNombreCliente.getText().trim());
    }//GEN-LAST:event_jTextFieldNombreClienteKeyReleased

    private void jButtonPDFTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPDFTablaActionPerformed
        ClientePDF pdf = new ClientePDF();
        pdf.pdfTablaProveedores();
    }//GEN-LAST:event_jButtonPDFTablaActionPerformed

    private void jButtonExcelTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcelTablaActionPerformed
        ClientesExcel ce = new ClientesExcel();
        ce.TablaClientesExcelReporte();
    }//GEN-LAST:event_jButtonExcelTablaActionPerformed

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

    //Seteo para el comboBox de los clientes
    public void seteoComboBoxClientes() {
        try {
            ClienteServices cs = new ClienteServices();
            for (Cliente aux : cs.listaCliente()) {
                jComboBoxClientes.addItem(aux);
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo seteoComboBoxClientes() de la clase compra_form: " + e.fillInStackTrace());
        }
    }

    //Metodo para setear los valores del comboBox de los productos
    public void seteoComboBoxProductos() {
        try {
            ProductoServices ps = new ProductoServices();
            for (Productos pro : ps.listaProductos()) {
                jComboBoxProductos.addItem(pro);
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo seteoComboBoxClientes() de la clase compra_form: " + e.fillInStackTrace());
        }
    }

    //Timer para el date
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonBuscarCliente;
    private javax.swing.JButton jButtonEliminarCliente;
    private javax.swing.JButton jButtonExcelTabla;
    private javax.swing.JButton jButtonPDFTabla;
    private javax.swing.JComboBox<Cliente> jComboBoxClientes;
    private javax.swing.JComboBox<Productos> jComboBoxProductos;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelVerFechaYHora;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField1ApellidoCliente;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldDocumentoCliente;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldLocalidad;
    private javax.swing.JTextField jTextFieldNombreCliente;
    private javax.swing.JTextField jTextFieldWhatsApp;
    // End of variables declaration//GEN-END:variables
}
