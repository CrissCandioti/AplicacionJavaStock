package com.raven.form;

import com.raven.component.Form;
import entidades.Notas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import raven.chat.component.ChatBox;
import raven.chat.model.ModelMessage;
import raven.chat.swing.ChatEvent;
import services.NotaServices;

public class ChatGPT_Form extends Form {

    public ChatGPT_Form() {
        initComponents();
        chatArea.setTitle("OpenAI");
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy, hh:mmaa");
        cargarMensajesAnteriores();
        chatArea.addChatEvent(new ChatEvent() {
            @Override
            public void mousePressedSendButton(ActionEvent evt) {
                try {
                    Icon icon = new ImageIcon(getClass().getResource("/com/raven/icon/logo.png"));
                    String name = "AngelTienda";
                    String date = df.format(new Date());
                    String message = chatArea.getText().trim();

                    if (!message.isEmpty()) {
                        // Guardar mensaje en la base de datos
                        NotaServices chatServices = new NotaServices();
                        chatServices.persistirNota( date, message);

                        // Mostrar mensaje en el chat
                        chatArea.addChatBox(new ModelMessage(icon, name, date, message), ChatBox.BoxType.RIGHT);
                        chatArea.setText("");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al guardar el mensaje: " + e.getMessage());
                }
            }

            @Override
            public void mousePressedFileButton(ActionEvent evt) {
                // Implementar lógica para archivos si es necesario
            }

            @Override
            public void keyTyped(KeyEvent evt) {
                // Implementar lógica de escritura si es necesario  
            }
        });
    }

    private void cargarMensajesAnteriores() {
        try {
            NotaServices chatServices = new NotaServices();
            List<Notas> mensajes = chatServices.listaNotas();
            Icon icon = new ImageIcon(getClass().getResource("/com/raven/icon/logo.png"));
            for (Notas chat : mensajes) {
                String date = chat.getFechaMensaje();
                chatArea.addChatBox(new ModelMessage(icon, "AngelTienda", 
                    date, chat.getNota()), ChatBox.BoxType.LEFT);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar mensajes anteriores: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new raven.chat.swing.Background();
        chatArea = new raven.chat.component.ChatArea();

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chatArea, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chatArea, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.chat.swing.Background background1;
    private raven.chat.component.ChatArea chatArea;
    // End of variables declaration//GEN-END:variables
}
