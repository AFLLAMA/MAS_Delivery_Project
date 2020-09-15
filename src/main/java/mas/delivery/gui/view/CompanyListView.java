package mas.delivery.gui.view;

import mas.delivery.Company;
import mas.delivery.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class CompanyListView {
    private JPanel mainPanel;
    private JTable table1;
    private JTable table2;
    private JButton orderButton;

    public JPanel getMainPanel(){
        return mainPanel;
    }

    public JTable getTable1(){
        return table1;
    }

    public JTable getTable2() {
        return table2;
    }

    public JButton getOrderButton() {
        return orderButton;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        orderButton = new JButton();

        table1 = new JTable()
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }
        ;
        table2 = new JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table2.setDefaultRenderer(Company.class, new CompaniesRenderer());
    }

    private class CompaniesRenderer extends JLabel implements TableCellRenderer{
        CompaniesRenderer(){
            super.setOpaque(true);
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            System.out.println("TEXT");
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            Component c = renderer.getTableCellRendererComponent(table,
                    value, isSelected, hasFocus, row, column);

            Product company = (Product)value;
            String text = company.getName();

            setText(text);
            c.setBackground(Color.magenta);
            System.out.println("TABLE " + text);
            super.setBackground(Color.magenta);
            return this;
        }
    }
}
