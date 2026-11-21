package com.teachback.garage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = {
        "com.teachback.garage",
        "com.teachback.external"})
public class GarageApplication {

    public static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(GarageApplication.class, args);
        RepairService repairService =
                context.getBean(RepairService.class);
        System.out.println("Bean retrieved: "
                + repairService.getClass().getSimpleName());
    }
}
