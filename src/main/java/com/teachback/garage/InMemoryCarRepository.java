package com.teachback.garage;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryCarRepository implements CarRepository {

    private final Map<Long, Car> cars = new ConcurrentHashMap<>();

    public InMemoryCarRepository() {
        save(new Car(41L, "Renault", "Clio", "Marie"));
        save(new Car(42L, "Honda", "Civic", "Paul"));
    }

    @Override
    public Car findById(Long id) {
        Car car = cars.get(id);
        if (car == null) {
            throw new NoSuchElementException("No car with id " + id);
        }
        return car;
    }

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(cars.values());
    }

    @Override
    public int save(Car car) {
        cars.put(car.getId(), car);
        return 1;
    }
}
