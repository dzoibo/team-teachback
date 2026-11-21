package com.teachback.garage;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairService {

    private final CarRepository repository;
    private final NotificationService notifications;

    public RepairService(CarRepository repository, NotificationService notifications) {
        this.repository = repository;
        this.notifications = notifications;
    }

    public Car repair(Long carId) {
        Car car = repository.findById(carId);
        notifications.send("Your " + car.getBrand() + " " + car.getModel()
                + " is repaired, " + car.getOwnerName());
        return car;
    }

    public List<Car> findAll() {
        return repository.findAll();
    }
}
