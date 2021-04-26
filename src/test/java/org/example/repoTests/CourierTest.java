package org.example.repoTests;

import org.example.data.Courier;
import org.example.repository.impl.CourierRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase
@Sql({"schema_courier.sql"})
public class CourierTest {
    @Autowired
    private CourierRepo courierRepo;

    @Test
    public void select() {
        assertNotNull(courierRepo.select(1));
    }

    @Test
    public void update() {
        assertEquals(courierRepo.update(new Courier(1, "Name", "phone")), 1);
    }

    @Test
    public void create() {
        assertEquals(courierRepo.create(new Courier(1, "Name", "phone")), 1);
    }

    @Test
    public void delete() {
        assertEquals(courierRepo.delete(2), 1);
    }
}
