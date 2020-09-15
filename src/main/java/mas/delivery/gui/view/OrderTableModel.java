package mas.delivery.gui.view;

import mas.delivery.DeliveryOrder;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class OrderTableModel extends AbstractTableModel {

    private List<DeliveryOrder> data;

    private String[] colNames = new String[]{"Id", "Customer", "Products"};

    public OrderTableModel(List<DeliveryOrder> data) {
        this.data = data;
    }


    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DeliveryOrder deliveryOrder = data.get(rowIndex);
        if(0 == columnIndex) {
            return deliveryOrder.getDeliveryOrderId();
        }
        else if(1 == columnIndex) {
            return deliveryOrder.getCustomer().getName();
        }
        else if(2 == columnIndex) {
            return deliveryOrder.getProducts();
        }
        return null;
    }
}
