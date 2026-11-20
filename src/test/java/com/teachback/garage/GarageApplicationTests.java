package com.teachback.garage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GarageApplicationTests {

    @Autowired
    RepairService repairService;

    @Test
    void contextLoadsAndServiceIsWired() {
        assertEquals(2, repairService.findAll().size());
    }
}
