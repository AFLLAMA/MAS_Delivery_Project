package mas.delivery.gui.view;


import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class OrderTableRenderer extends JLabel implements TableCellRenderer
{

    public OrderTableRenderer()
    {
        super.setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                            boolean hasFocus, int row, int column)
    {
        super.setBackground(Color.GREEN);
        return this;
    }

}

