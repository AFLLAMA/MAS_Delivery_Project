//package mas.delivery;
//
//import mas.delivery.repo.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//
//@Component
//public class DataInit {
//
//    @Autowired
//    private CompanyRepo companyRepo;
//    @Autowired
//    private CourierRepo courierRepo;
//    @Autowired
//    private CatalogueOfCompaniesRepo cocRepo;
//    @Autowired
//    private UserRepo userRepo;
//    @Autowired
//    private OrderRepo orderRepo;
//    @Autowired
//    private ProductRepo productRepo;
//
//    public void init(){
//        User cus1 = new User("lama", "qwerty123", "Andrii", "Feshchenko",LocalDate.now(), true, "Grojecka 322/8");
//        User cus2 = new User("lama1", "qwerty123", "Anna", "Vlasenko",LocalDate.now(), true, "Koszykowa 8");
//        User cus3 = new User("lama2", "qwerty123", "Anton", "Suprun", LocalDate.now(),true,"Sikorskiego 228");
//        User cus4 = new User("lama3", "qwerty123", "Anastasia", "Kolesnik", LocalDate.now(), true, "Sikorskiego 22");
//        User cus5 = new User("lama4", "qwerty123", "Shrek", "Kek",LocalDate.now(), true, "Grojecka 322/8");
//
////            System.out.println(cus4.getType());
//
//        cus1.upgrade( LocalDate.now());
//        cus2.upgrade( LocalDate.now());
//        cus3.upgrade( LocalDate.now());
//        cus4.upgrade( LocalDate.now());
//        cus5.upgrade( LocalDate.now());
//
////            System.out.println(cus4.getCustomerType());
//
//        DeliveryOrder do1 = new DeliveryOrder();
//        DeliveryOrder do0 = new DeliveryOrder();
//        DeliveryOrder do2 = new DeliveryOrder();
//        DeliveryOrder do3 = new DeliveryOrder();
//        DeliveryOrder do4 = new DeliveryOrder();
//
//        Product p1 = new Product("BigMac", 25.);
//        Product p0 = new Product("Potato", 10.);
//        Product p2 = new Product("Coca-cola", 10.);
//        Product p3 = new Product("McFlury", 20.);
//        Product p4 = new Product("McNuggets", 20.);
//        Product p5 = new Product("Twister", 20.);
//        Product p6 = new Product("Pepsi", 20.);
//
//
//        Company com1 = new Company("McDonald's", "Grojecka 1234/A");
//        Company com2 = new Company("KFC", "Anny Akhmatovoi 41G");
//
//        CatalogueOfCompanies coc = new CatalogueOfCompanies("American");
//
////        Courier cour1 = new Courier("soifg", "qwerty1234", "Mykola", "Shidnyi", "+48733482021", LocalDate.now());
////        Courier cour0 = new Courier("ksuyfdyy", "qwerty1234", "Maria", "Mel", "+48733444455", LocalDate.now());
//
////        courierRepo.save(cour1);
////        courierRepo.save(cour0);
//
//        coc.addCompany(com1);
//        coc.addCompany(com2);
//
//        cocRepo.save(coc);
//
//        com1.addProduct(p1);
//        com1.addProduct(p0);
//        com1.addProduct(p2);
//        com1.addProduct(p3);
//        com1.addProduct(p4);
//        com2.addProduct(p5);
//        com2.addProduct(p6);
//
//        companyRepo.save(com1);
//        companyRepo.save(com2);
//
//        do1.setCustomer(cus1);
//        do0.setCustomer(cus2);
//        do2.setCustomer(cus3);
////        do3.setCustomer(cus4);
//        do3.setCustomer(cus5);
//        do4.setCustomer(cus4);
//
//        userRepo.save(cus1);
//        userRepo.save(cus2);
//        userRepo.save(cus3);
//        userRepo.save(cus4);
//        userRepo.save(cus5);
//
//
////        do1.setCourier(cour1);
////        do2.setCourier(cour0);
////        do3.setCourier(cour0);
////        do0.setCourier(cour0);
//
//        do1.addProduct(p1);
//        do2.addProduct(p1);
//        do2.addProduct(p0);
//        do0.addProduct(p0);
//        do3.addProduct(p2);
//        do3.addProduct(p2);
//        do0.addProduct(p6);
//        do4.addProduct(p0);
//
//        orderRepo.save(do1);
//        orderRepo.save(do2);
//        orderRepo.save(do3);
//        orderRepo.save(do0);
//        orderRepo.save(do4);
//
//        productRepo.save(p1);
//        productRepo.save(p4);
//        productRepo.save(p3);
//        productRepo.save(p2);
//        productRepo.save(p0);
//        productRepo.save(p5);
//        productRepo.save(p6);
//
//
//
//    }
//}
