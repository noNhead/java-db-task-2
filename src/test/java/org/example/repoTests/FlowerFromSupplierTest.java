package org.example.repoTests;

import org.example.entity.FlowerInBouquet;
import org.example.entity.FlowerSupplyFromSupplier;
import org.example.repository.impl.SupplyFlowerFromSupplierRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@JdbcTest
public class FlowerFromSupplierTest {
    @Autowired
    private SupplyFlowerFromSupplierRepo supplyFlowerFromSupplierRepo;

    @Test
    public void select() {
        assertNotNull(supplyFlowerFromSupplierRepo.select(1));
    }

    @Test
    public void update() {
        assertEquals(supplyFlowerFromSupplierRepo.update(new FlowerSupplyFromSupplier(1, 1, 2, 11, new Timestamp(System.currentTimeMillis()))), 1);
    }

    @Test
    public void create() {
        assertEquals(supplyFlowerFromSupplierRepo.create(new FlowerSupplyFromSupplier(1, 1, 2, 11, new Timestamp(System.currentTimeMillis()))), 1);
    }

    @Test
    public void delete() {
        assertEquals(supplyFlowerFromSupplierRepo.delete(1), 1);
    }
}
