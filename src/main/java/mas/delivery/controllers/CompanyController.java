package mas.delivery.controllers;

import mas.delivery.*;
import mas.delivery.gui.view.CompanyListView;
import mas.delivery.repo.CourierRepo;
import mas.delivery.repo.OrderRepo;
import mas.delivery.repo.ProductRepo;
import mas.delivery.services.CompanyServiceImpl;
import mas.delivery.services.CustomerServiceImpl;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.LinkOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class CompanyController {

    @Autowired
    private MainWindowController mainWindowController;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CourierRepo courierRepo;

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private ProductRepo productRepo;

    private CompanyListView view;

    private CompanyServiceImpl companyService;

    private List<Product> order = new ArrayList<>();

    public CompanyController(CompanyServiceImpl companyService) {
        this.companyService = companyService;
        view = new CompanyListView();
        initListModels();
        initListeners();
        orderButtonListener();

    }

    private void orderButtonListener(){
        JButton orderButton = view.getOrderButton();

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeliveryOrder deliveryOrder = new DeliveryOrder();

                User loggedAs = customerService.getCustomerById(4L);

                deliveryOrder.setCustomer(loggedAs);
                orderRepo.save(deliveryOrder);
                for (Product p: order) {
                    Product product = (Product) productRepo.findById(p.getProductId()).get();

                    deliveryOrder.addProduct(product);
                    productRepo.save(product);
                }

                System.out.println(order.size());

                order = new ArrayList<>();
            }
        });
    }

    private void initListeners(){
        JTable table1 = view.getTable1();
        JTable table2 = view.getTable2();
        table1.setCellSelectionEnabled(true);
        table2.setCellSelectionEnabled(true);
        table1.setRowSelectionAllowed(false);
        table2.setColumnSelectionAllowed(false);
        table1.setColumnSelectionAllowed(false);
        table2.setRowSelectionAllowed(false);

        ListSelectionModel cellSelectionModel1 = table1.getSelectionModel();
        cellSelectionModel1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cellSelectionModel1.addListSelectionListener(e -> {
            boolean isAdj = e.getValueIsAdjusting();
            if (!isAdj&& !cellSelectionModel1.isSelectionEmpty()){
                SwingUtilities.invokeLater(() ->{
//                    System.out.println("a");
                    int r = view.getTable1().getSelectedRow();
                    int c = view.getTable1().getSelectedColumn();
                    Company selected = (Company) view.getTable1().getValueAt(r,c);

                    Company company = companyService.getCompanyByID(selected.getCompanyId());

                    updateProducts(company.getProducts());
                    cellSelectionModel1.clearSelection();
                    table1.repaint();
                });
            }

        });
        ListSelectionModel cellSelectionModel2 = table2.getSelectionModel();
        cellSelectionModel2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cellSelectionModel2.addListSelectionListener(e -> {
            boolean isAdj = e.getValueIsAdjusting();
            if (!isAdj&&!cellSelectionModel2.isSelectionEmpty()){
                SwingUtilities.invokeLater(() ->{
                    Product selected = (Product) view.getTable2().getValueAt(view.getTable2().getSelectedRow(),
                            view.getTable2().getSelectedColumn());
                    System.out.println(selected.getName());
                    order.add(selected);
                    cellSelectionModel2.clearSelection();
                    table1.repaint();
                    table2.repaint();
                });
            }
        });

    }

    private void updateProducts(Set<Product> products) {
        Product[] prods = new Product[products.size()];
        products.toArray(prods);
        DefaultTableModel tableModel;

        int columns = 3;
        int rows = (prods.length-1)/3 + 1;
        Object[][] compData = new Object[rows][columns];
        int rowCount = 0;
        int columnCount = 0;
        for (int i = 0; i < products.size(); i++) {
            compData[rowCount][columnCount] = prods[i];
            if ((i+1)%3 == 0) {
                rowCount++;
                columnCount = 0;
            }else
                columnCount++;
        }
        String [] names = {"col1", "col2","col3"};
        tableModel = new DefaultTableModel(compData,names);
        DefaultTableModel clear = (DefaultTableModel) view.getTable2().getModel();
        clear.setRowCount(0);

        view.getTable2().setModel(tableModel);

    }

    private void initListModels() {
        view.getTable1().setModel(new DefaultTableModel());

    }

    public void showGUI(){
        updateCompaniesFromDB();
        mainWindowController.showPanel(view.getMainPanel() );
        view.getTable2().repaint();
        view.getOrderButton().repaint();
    }

    private void updateCompaniesFromDB() {
        List<Company> companies = companyService.getCompanies();
        DefaultTableModel tableModel;
        int columns = 3;
        int rows = (companies.size()-1)/3 + 1;
        Object[][] compData = new Object[rows][columns];
        compData[0][0] = companies.get(0);
        compData[0][1] = companies.get(1);

        String [] names = {"c", "c"};
        tableModel = new DefaultTableModel(compData,names);

        view.getTable1().setModel(tableModel);

    }
}