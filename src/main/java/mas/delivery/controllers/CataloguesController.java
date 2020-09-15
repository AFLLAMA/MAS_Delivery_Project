//package mas.delivery.controllers;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import groovy.lang.Grab;
//import mas.delivery.CatalogueOfCompanies;
//import mas.delivery.User;
//import mas.delivery.repo.CatalogueOfCompaniesRepo;
//import mas.delivery.services.CatalogueServiceImpl;
//import mas.delivery.services.CustomerServiceImpl;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.json.JsonArray;
//import javax.json.Json;
//import javax.json.JsonObject;
//import java.util.ArrayList;
//import java.util.List;
//
//@Grab(module = "common-length", version = "2.4", value = "org.webjars:jquery:2.0.3-1")
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//public class CataloguesController {
//
//    private CatalogueServiceImpl catalogueService;
//
//    public CataloguesController(CatalogueServiceImpl catalogueService) {
//        this.catalogueService = catalogueService;
//    }
//
//    @GetMapping("/catalogues")
//    public List<CatalogueOfCompanies> getCats(){
//        return catalogueService.getCatalogues();
//    }
//
////    @RequestMapping("/catalogue")
////    public String listContact(Model model) throws JsonProcessingException {
////
//////        List<String> cats = new ArrayList<>();
//////        for (CatalogueOfCompanies c: catalogueService.getCatalogues()
//////             ) {
//////            cats.add(catalogue(c));
//////        }
////
//////        model.addAttribute("catalogues", cats);
//////        System.out.println("I am here: " + cats);
//////        productRepo.findAll().iterator().forEachRemaining(e -> System.out.println(e));
////
////        System.out.println(catalogue(new CatalogueOfCompanies("name")));
////
////        System.out.println(catalogueService.getCatalogues());
////        model.addAttribute("catalogues",catalogueService.getCatalogues());
////        return "catalogue";
////    }
////
////    public String catalogue(CatalogueOfCompanies catalogue) throws JsonProcessingException {
////        //Creating the ObjectMapper object
////        ObjectMapper mapper = new ObjectMapper();
////        //Converting the Object to JSONString
////        String jsonString = mapper.writeValueAsString(catalogue);
////        return jsonString;
////    }
//
//}
