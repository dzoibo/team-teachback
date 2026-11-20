package com.teachback.garage;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairService {

    private final CarRepository repository;

    public RepairService(CarRepository repository) {
        this.repository = repository;
    }

    public void repair(Long carId) {
        Car car = repository.findById(carId);
        System.out.println("Repairing " + car.getBrand() + " " + car.getModel()
                + " for " + car.getOwnerName());
    }

    public List<Car> findAll() {
        return repository.findAll();
    }
}
