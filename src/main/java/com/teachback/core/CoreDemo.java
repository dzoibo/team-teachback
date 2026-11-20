package com.teachback.core;

import com.teachback.garage.CarRepository;
import com.teachback.garage.RepairService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CoreDemo {

    public static void main(String[] args) {
        System.out.println("=== Part 1 - Spring Core: the IoC container ===");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

       
        System.out.println("[container] CarRepository -> "
                + context.getBean(CarRepository.class).getClass().getSimpleName());
        System.out.println("[container] RepairService -> "
                + context.getBean(RepairService.class).getClass().getSimpleName() + " (injected)");

        context.close();
    }
}