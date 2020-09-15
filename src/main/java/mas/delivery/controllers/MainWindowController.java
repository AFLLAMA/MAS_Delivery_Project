package mas.delivery.controllers;

import mas.delivery.gui.view.MainWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class MainWindowController {
    private MainWindow view;
    @Autowired
    private CompanyController companyController;
    @Autowired
    private OrdersController ordersController;

    public MainWindowController(){
        view = new MainWindow();
        initMenuItemListeners();
    }

    private void initMenuItemListeners() {
        view.getMenuItemCompanyList().addActionListener(e -> {
//            System.out.println("Hi");
            companyController.showGUI();
        });
        view.getOrdersList().addActionListener(e -> {
            ordersController.showGUI();
        });
    }

    public void showGUI(){
        view.setVisible(true);
    }

    public void showPanel(JPanel panel){
        view.getContentPane().removeAll();
        view.add(panel);
        view.revalidate();
    }
}
