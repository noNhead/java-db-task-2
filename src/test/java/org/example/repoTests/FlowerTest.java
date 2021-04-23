package org.example.repoTests;

import org.example.entity.Flower;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.example.repository.impl.FlowerRepo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase
@Sql({"schema_flower.sql"})
public class FlowerTest {
    @Autowired
    private FlowerRepo flowerRepo;

    @Test
    public void select() {
        assertNotNull(flowerRepo.select(1));
    }

    @Test
    public void update() {
        assertEquals(flowerRepo.update(new Flower(1,"name", 10)), 1);
    }

    @Test
    public void create() {
        assertEquals(flowerRepo.create(new Flower(1,"name", 10)), 1);
    }

    @Test
    public void delete() {
        assertEquals(flowerRepo.delete(2), 1);
    }
}
