package com.teachback.garage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class RepairController {

    private final RepairService repairService;

    public RepairController(RepairService repairService) {
        this.repairService = repairService;
    }

    @GetMapping
    public List<Car> all() {
        return repairService.findAll();
    }

    // GET only to make the demo easy from a browser
    @GetMapping("/{id}/repair")
    public Car repair(@PathVariable Long id) {
        return repairService.repair(id);
    }
    
    // Ref Slide 24: Alisha brings her Toyota Corolla to the garage
    @GetMapping("/alisha")
    public String registerAlisha() {
        Car car = new Car(1007L, "Toyota", "Corolla", "Alisha");
        int rows = repairService.registerCar(car);
        return "Rows inserted: " + rows;
    }
}
