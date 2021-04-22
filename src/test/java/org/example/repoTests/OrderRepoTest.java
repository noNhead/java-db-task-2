package org.example.repoTests;

import org.example.entity.Order;
import org.example.entity.PromotionalCode;
import org.example.repository.impl.OrderRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@JdbcTest
public class OrderRepoTest {
    @Autowired
    private OrderRepo orderRepo;

    @Test
    public void select() {
        assertNotNull(orderRepo.select(1));
    }

    @Test
    public void update() {
        assertEquals(orderRepo.update(new Order(1, 1, 1, 1, 1, 1, new Timestamp(System.currentTimeMillis()))), 1);
    }

    @Test
    public void create() {
        assertEquals(orderRepo.create(new Order(1, 1, 1, 1, 1, 1, new Timestamp(System.currentTimeMillis()))), 1);
    }

    @Test
    public void delete() {
        assertEquals(orderRepo.delete(1), 1);
    }
}
