//package mas.delivery.controllers;
//
//import groovy.lang.Grab;
//import mas.delivery.Product;
//import mas.delivery.services.CatalogueServiceImpl;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Grab(module = "common-length", version = "2.4", value = "org.webjars:jquery:2.0.3-1")
//@Controller
//public class TestController {
//    private CatalogueServiceImpl catalogueService;
//
//    public TestController(CatalogueServiceImpl catalogueService) {
//        this.catalogueService = catalogueService;
//    }
//
//    @RequestMapping("/test")
//    public String test(Model model){
//        model.addAttribute("test1", catalogueService.getCatalogues());
////        new Product("sushi",44.25)
//
//        return "test.html";
//    }
//}
