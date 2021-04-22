package org.example.repoTests;

import org.example.entity.Supplier;
import org.example.repository.impl.SupplierRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@JdbcTest
public class SupplierTest {
    @Autowired
    private SupplierRepo supplierRepo;

    @Test
    public void select() {
        assertNotNull(supplierRepo.select(1));
    }

    @Test
    public void update() {
        assertEquals(supplierRepo.update(new Supplier(1,"name","phone","email", 1)), 1);
    }

    @Test
    public void create() {
        assertEquals(supplierRepo.create(new Supplier(1,"name","phone","email", 1)), 1);
    }

    @Test
    public void delete() {
        assertEquals(supplierRepo.delete(1), 1);
    }
}
