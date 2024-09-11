package com.raven.table;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class TableHeaderAlignment implements TableCellRenderer {
    private final TableCellRenderer oldHeaderRenderer;

    public TableHeaderAlignment(JTable table) {
        this.oldHeaderRenderer = table.getTableHeader().getDefaultRenderer();
        alignColumnContent(table);
    }

    private void alignColumnContent(JTable table) {
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(getAlignment(i));
            column.setCellRenderer(renderer);
        }
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) oldHeaderRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setHorizontalAlignment(getAlignment(column));
        return label;
    }

    protected int getAlignment(int column) {
        if (column == 0 || column == 1) {
            return SwingConstants.CENTER;
        }
        return SwingConstants.LEADING;
    }
}