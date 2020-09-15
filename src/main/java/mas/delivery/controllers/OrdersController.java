package mas.delivery.controllers;

import mas.delivery.DeliveryOrder;
import mas.delivery.User;
import mas.delivery.gui.view.OrderTableModel;
import mas.delivery.gui.view.OrderTableRenderer;
import mas.delivery.gui.view.OrdersListView;
import mas.delivery.repo.OrderRepo;
import mas.delivery.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class OrdersController {

    @Autowired
    MainWindowController mainWindowController;
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    UserRepo userRepo;

    User loggedAs;
    OrdersListView view;
    public OrdersController() {
        view = new OrdersListView();
        initListModels();

    }

    private void updateTableFromDB() {
//        DefaultTableModel tableModel;
        OrderTableModel tableModel;
        loggedAs = (User) userRepo.findWithOrdersById(4L).get();
//        System.out.println(loggedAs.getDeliveryOrders().stream().collect(Collectors.toList()));

//        System.out.println(orderRepo.findAll());
//        List<DeliveryOrder> ordersData = (List<DeliveryOrder>) orderRepo.findAll();
        List<DeliveryOrder> ordersData = loggedAs.getDeliveryOrders().stream().collect(Collectors.toList());
//        tableModel = new DefaultTableModel(compData,names);
        tableModel = new OrderTableModel(ordersData);

        view.getTable1().setModel(tableModel);
        view.getTable1().setDefaultRenderer(DeliveryOrder.class, new OrderTableRenderer());

        view.getTable1().repaint();
    }

    private void initListModels() {
        view.getTable1().setModel(new DefaultTableModel());

    }

    public void showGUI(){
        mainWindowController.showPanel(view.getPanel1());
        updateTableFromDB();
    }
}
