package com.teachback.garage;

import java.util.List;

/**
 * The contract shared by the three parts of the teachback.
 * Part 1 (John): in-memory implementation.
 * Part 3 (Cynthia): JDBC implementation of the same interface.
 * Do not change it without telling the team.
 */
public interface CarRepository {

    Car findById(Long id);

    List<Car> findAll();

    int save(Car car);
}
