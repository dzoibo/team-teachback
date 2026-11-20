package com.teachback.core;

import com.teachback.garage.CarRepository;
import com.teachback.garage.RepairService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CoreDemo {

    public static void main(String[] args) {
        System.out.println("=== Part 1 - Spring Core: the IoC container ===");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Slide 6: the container is like a big map, type -> ready-to-use instance
        System.out.println("[container] CarRepository -> "
                + context.getBean(CarRepository.class).getClass().getSimpleName());
        System.out.println("[container] RepairService -> "
                + context.getBean(RepairService.class).getClass().getSimpleName() + " (injected)");

        // Slide 8: ask the container for the bean and use it.
        // We never wrote "new RepairService(...)" here.
        RepairService service = context.getBean(RepairService.class);
        service.repair(42L);

        // Slide 8: singleton by default, one shared instance per container
        RepairService again = context.getBean(RepairService.class);
        System.out.println("[container] Same instance both times? " + (service == again));

        context.close();
    }
}