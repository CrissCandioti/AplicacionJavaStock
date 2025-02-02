package com.raven.main;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.raven.form.ChatGPT_Form;
import com.raven.form.Compra_Form;
import com.raven.form.EditNotas_Form;
import com.raven.form.Home_Form;
import com.raven.form.Producto_Form;
import com.raven.form.Proveedores_Form;
import com.raven.form.RegistroCompra_Form1;
import com.raven.form.Usuarios_Form;
import com.raven.menu.EventMenu;
import raven.popup.GlassPanePopup;
import raven.toast.Notifications;

public class Main extends javax.swing.JFrame {

    private Usuarios_Form usuariosForm;
    private Producto_Form productosForm;
    private Proveedores_Form proveedoresForm;
    private ChatGPT_Form ChatGPTForm;
    private Compra_Form Compra_Form;
    private RegistroCompra_Form1 RegistroCompra_Form1;
    private EditNotas_Form EditNotas_Form;

    public Main() {
        initComponents();
        init();
    }

    private void init() {
        GlassPanePopup.install(this);
        Notifications.getInstance().setJFrame(this);
        menu.addEventMenu(new EventMenu() {
            @Override
            public void selectedMenu(int index) {
                if (index == 0) {
                    mainBody.displayForm(new Home_Form());
                } else if (index == 1) {
                    mainBody.displayForm(usuariosForm, "Clientes");
                } else if (index == 3) {
                    mainBody.displayForm(productosForm, "Productos");
                } else if (index == 2) {
                    mainBody.displayForm(proveedoresForm, "Proveedores");
                } else if (index == 6) {
                    mainBody.displayForm(ChatGPTForm, "Notas");
                } else if (index == 4) {
                    mainBody.displayForm(Compra_Form, "Facturacion Compra");
                } else if (index == 5) {
                    mainBody.displayForm(RegistroCompra_Form1, "Registro Compra");
                } else if (index == 7) {
                    mainBody.displayForm(EditNotas_Form, "Editor Notas");
                }
            }
        });
        Compra_Form = new Compra_Form();
        ChatGPTForm = new ChatGPT_Form();
        productosForm = new Producto_Form();
        usuariosForm = new Usuarios_Form();
        RegistroCompra_Form1 = new RegistroCompra_Form1();
        proveedoresForm = new Proveedores_Form();
        EditNotas_Form = new EditNotas_Form();

        mainBody.displayForm(new Home_Form());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground1 = new com.raven.swing.PanelBackground();
        menu = new com.raven.menu.Menu();
        mainBody = new com.raven.component.MainBody();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelBackground1.setBackground(new java.awt.Color(34, 34, 34));

        javax.swing.GroupLayout panelBackground1Layout = new javax.swing.GroupLayout(panelBackground1);
        panelBackground1.setLayout(panelBackground1Layout);
        panelBackground1Layout.setHorizontalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainBody, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBackground1Layout.setVerticalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                    .addComponent(mainBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatLaf.registerCustomDefaultsSource("com.raven.style");
        FlatMacDarkLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.MainBody mainBody;
    private com.raven.menu.Menu menu;
    private com.raven.swing.PanelBackground panelBackground1;
    // End of variables declaration//GEN-END:variables
}
