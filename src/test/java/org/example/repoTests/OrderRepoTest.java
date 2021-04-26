package org.example.repoTests;

import org.example.data.Order;
import org.example.repository.impl.OrderRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase
@Sql({"schema_order_repo.sql"})
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
        assertEquals(orderRepo.delete(2), 1);
    }
}
