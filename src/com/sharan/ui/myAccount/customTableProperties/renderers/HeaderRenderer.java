package com.sharan.ui.myAccount.customTableProperties.renderers;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class HeaderRenderer extends JLabel implements TableCellRenderer {

        public HeaderRenderer() {
            setFont(new Font("Times New Roman",Font.BOLD,18));
            setOpaque(true);
            setBackground(Color.yellow);
            setForeground(Color.BLUE);
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


