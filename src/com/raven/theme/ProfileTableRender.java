/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.theme;

import entidades.Productos;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author criss
 */
public class ProfileTableRender implements TableCellRenderer {

    private final TableCellRenderer oldCellRender;

    public ProfileTableRender(JTable table) {
        oldCellRender = table.getDefaultRenderer(Object.class);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com = oldCellRender.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        Productos producto = (Productos) value; // Cast the value to Productos
        TableCellProfile cell = new TableCellProfile(producto, com.getFont());
        cell.setBackground(com.getBackground());
        return cell;
    }

}
