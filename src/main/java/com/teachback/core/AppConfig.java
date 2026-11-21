package com.teachback.core;

import com.teachback.garage.CarRepository;
import com.teachback.garage.InMemoryCarRepository;
import com.teachback.garage.NotificationService;
import com.teachback.garage.RepairService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CarRepository carRepository() {
        return new InMemoryCarRepository();
    }

    @Bean
    public NotificationService notificationService() {
        return message -> System.out.println("[notification] " + message);
    }

    @Bean
    public RepairService repairService(CarRepository carRepository,
                                       NotificationService notificationService) {
        return new RepairService(carRepository, notificationService);
    }
}