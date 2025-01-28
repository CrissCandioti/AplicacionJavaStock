/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.crud;

import entidades.Productos;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author criss
 */
public class VerProducto extends javax.swing.JPanel {

    /**
     * Creates new form VerProducto
     */
    public VerProducto() {
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

        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelVerNombre = new javax.swing.JLabel();
        jLabelVerFecha = new javax.swing.JLabel();
        jLabelVerContenido = new javax.swing.JLabel();
        jLabelVerVariedad = new javax.swing.JLabel();
        jLabelVerPrecioCosto = new javax.swing.JLabel();
        jLabelVerPrecioVenta = new javax.swing.JLabel();
        jLabelVerMarca = new javax.swing.JLabel();
        jLabelVerStock = new javax.swing.JLabel();
        jLabelVerTipoProducto = new javax.swing.JLabel();
        jLabelVerProveedor = new javax.swing.JLabel();
        jLabelVerDescripcion = new javax.swing.JLabel();
        jLabelVerGanancia = new javax.swing.JLabel();
        jLabelVerPorcentajeGanancia = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Stock");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Marca");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Nombre");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("Tipo producto");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Fecha");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Proveedor");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Contenido");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Variedad");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Precio costo");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Precio venta");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Descripcion");

        jLabelVerNombre.setText("Ver Nombre");

        jLabelVerFecha.setText("Ver Fecha");

        jLabelVerContenido.setText("Ver Contenido");

        jLabelVerVariedad.setText("Ver Variedad");

        jLabelVerPrecioCosto.setText("Ver Precio costo");

        jLabelVerPrecioVenta.setText("Ver Precio venta");

        jLabelVerMarca.setText("Ver Marca");

        jLabelVerStock.setText("Ver Stock");

        jLabelVerTipoProducto.setText("Ver Tipo producto");

        jLabelVerProveedor.setText("Ver Proveedor");

        jLabelVerDescripcion.setText("Ver Descripcion");

        jLabelVerGanancia.setText("Ver Ganancia");

        jLabelVerPorcentajeGanancia.setText("Ver Porcentaje Ganancia");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Ganancia");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel14.setText("Porcentaje Ganancia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelVerGanancia)
                            .addComponent(jLabelVerPorcentajeGanancia)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelVerNombre)
                            .addComponent(jLabelVerFecha)
                            .addComponent(jLabelVerContenido)
                            .addComponent(jLabelVerVariedad)
                            .addComponent(jLabelVerPrecioCosto)
                            .addComponent(jLabelVerPrecioVenta)
                            .addComponent(jLabelVerMarca)
                            .addComponent(jLabelVerStock)
                            .addComponent(jLabelVerTipoProducto)
                            .addComponent(jLabelVerProveedor)
                            .addComponent(jLabelVerDescripcion))))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelVerNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelVerFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabelVerContenido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelVerVariedad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelVerPrecioCosto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabelVerPrecioVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabelVerGanancia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabelVerPorcentajeGanancia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabelVerStock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabelVerMarca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabelVerTipoProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabelVerProveedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabelVerDescripcion))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelVerContenido;
    private javax.swing.JLabel jLabelVerDescripcion;
    private javax.swing.JLabel jLabelVerFecha;
    private javax.swing.JLabel jLabelVerGanancia;
    private javax.swing.JLabel jLabelVerMarca;
    private javax.swing.JLabel jLabelVerNombre;
    private javax.swing.JLabel jLabelVerPorcentajeGanancia;
    private javax.swing.JLabel jLabelVerPrecioCosto;
    private javax.swing.JLabel jLabelVerPrecioVenta;
    private javax.swing.JLabel jLabelVerProveedor;
    private javax.swing.JLabel jLabelVerStock;
    private javax.swing.JLabel jLabelVerTipoProducto;
    private javax.swing.JLabel jLabelVerVariedad;
    // End of variables declaration//GEN-END:variables

    public void seteoValores(Productos aux) {
        if (aux != null) {
            jLabelVerNombre.setText(aux.getNombre());
            jLabelVerContenido.setText(aux.getContenido());
            jLabelVerMarca.setText(aux.getMarca());
            jLabelVerProveedor.setText(aux.getProveedor().getNombre());
            jLabelVerFecha.setText(new SimpleDateFormat("dd-MMMM-yyyy").format(aux.getFechaIngreso()));
            jLabelVerVariedad.setText(aux.getVariedad());
            jLabelVerPrecioCosto.setText(String.valueOf(aux.getPrecioCosto()));
            jLabelVerPrecioVenta.setText(String.valueOf(aux.getPrecioventa()));
            jLabelVerStock.setText(String.valueOf(aux.getStock()));
            jLabelVerTipoProducto.setText(aux.getTipoProducto());
            jLabelVerDescripcion.setText(aux.getDescripcion());
            jLabelVerPorcentajeGanancia.setText(String.valueOf(aux.getPorcentajeGanancias()));
            jLabelVerGanancia.setText(String.valueOf(aux.getGanancias()));
        }
    }
}
