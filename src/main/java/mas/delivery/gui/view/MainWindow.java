package mas.delivery.gui.view;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JMenuItem menuItemCompanyList;
    private JMenuItem ordersList;
    public MainWindow() throws HeadlessException {
        setTitle("Delivery app composing order demo");
        setSize(1025,768);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initMenuBar();
    }

    private void initMenuBar() {
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        bar.add(menu);
        menuItemCompanyList = new JMenuItem("Catalogue");
        ordersList = new JMenuItem("See orders");
        menu.add(menuItemCompanyList);
        menu.add(ordersList);
        this.setJMenuBar(bar);
//        this.pack();
//        this.setVisible(true);
    }

    public JMenuItem getMenuItemCompanyList() {
        return menuItemCompanyList;
    }

    public JMenuItem getOrdersList() {
        return ordersList;
    }
}
