package mas.delivery.gui.view;

import mas.delivery.DeliveryOrder;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class OrdersListView {
    private JTable table1;
    private JPanel panel1;

    public JTable getTable1() {
        return table1;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        table1 = new JTable()
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

    }


}
