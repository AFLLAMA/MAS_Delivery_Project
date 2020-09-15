//package mas.delivery.controllers;
//
//import groovy.lang.Grab;
//import mas.delivery.User;
//import mas.delivery.services.CustomerServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
////@Grab(module = "common-length", version = "2.4", value = "org.webjars:jquery:2.0.3-1")
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//public class CustomerController {
//
//    private CustomerServiceImpl customerService;
//
//    public CustomerController(CustomerServiceImpl customerService) {
//        this.customerService = customerService;
//    }
////
////    @GetMapping("/customers")
////    public List<User> getCustomers(){
////        return customerService.getCustomers();
////    }
//    @GetMapping("/customers")
//    public List<User> getCustomer(){
//        List<User> users = new ArrayList<>();
////        users.add((User)customerService.getCustomerById(6L).get());
//        users.add((User)customerService.getCustomerById(5L));
//        return users;
//    }
//
//}
