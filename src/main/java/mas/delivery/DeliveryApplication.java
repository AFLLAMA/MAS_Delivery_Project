package mas.delivery;

import mas.delivery.controllers.MainWindowController;
import mas.delivery.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.time.LocalDate;

@SpringBootApplication
public class DeliveryApplication {
//    @Autowired
//    private DataInit dataInit;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(DeliveryApplication.class).headless(false).run(args);
//        ctx.getBean(DataInit.class).init();
        SwingUtilities.invokeLater(()->{
            ctx.getBean(MainWindowController.class).showGUI();
        });
    }

}
