package com.sharan.ui.myAccount.renderers;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class LabelRenderer extends JLabel implements TableCellRenderer {

    public LabelRenderer() {
        setFont(new Font("Consolas", Font.BOLD, 16));
        setOpaque(true);
        setForeground(Color.BLACK);
        setBackground(Color.WHITE);
        setHorizontalAlignment(CENTER);
        setBorder(BorderFactory.createEtchedBorder());
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        return this;
    }


}
