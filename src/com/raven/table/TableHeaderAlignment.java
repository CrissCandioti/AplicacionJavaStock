/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.table;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingContainer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author criss
 */
public class TableHeaderAlignment implements TableCellRenderer{
   
    private final TableCellRenderer oldHeaderRenderer;
    private final TableCellRenderer oldCellRenderer;

    public TableHeaderAlignment(JTable table) {
        this.oldHeaderRenderer = table.getTableHeader().getDefaultRenderer();
        this.oldCellRenderer = table.getDefaultRenderer(Object.class);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) oldHeaderRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setHorizontalAlignment(getAlignment(column));
        return label;
    }
    
    protected int getAlignment (int colum){
        if (colum == 1) {
            return SwingConstants.CENTER;
        }
        return SwingConstants.LEADING;
    }
}
