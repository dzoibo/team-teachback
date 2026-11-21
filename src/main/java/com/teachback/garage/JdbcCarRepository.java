package com.teachback.garage;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcCarRepository implements CarRepository {

    private final JdbcTemplate jdbcTemplate;

    // Slide 23: the RowMapper turns one row into one Car (owner_name -> ownerName)
    private final RowMapper<Car> carRowMapper = (rs, rowNum) -> new Car(
            rs.getLong("id"),
            rs.getString("brand"),
            rs.getString("model"),
            rs.getString("owner_name"));

    // Injected by constructor (Parts 1 and 2): Boot created this JdbcTemplate
    public JdbcCarRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Slide 22: update() runs the INSERT and returns the number of rows changed
    @Override
    public int save(Car car) {
        return jdbcTemplate.update(
                "INSERT INTO car (id, brand, model, owner_name) VALUES (?, ?, ?, ?)",
                car.getId(), car.getBrand(), car.getModel(), car.getOwnerName());
    }

    // Slide 23: queryForObject() -> one row, one object
    @Override
    public Car findById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM car WHERE id = ?", carRowMapper, id);
    }

    // Slide 23: query() -> many rows, a List
    @Override
    public List<Car> findAll() {
        return jdbcTemplate.query("SELECT * FROM car ORDER BY id", carRowMapper);
    }
}