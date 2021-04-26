package org.example.repoTests;

import org.example.repository.impl.FlowerInBouquetRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase
@Sql({"schema_flower_has_bouquet.sql"})
public class FlowerInBouquetTest {
    @Autowired
    private FlowerInBouquetRepo flowerInBouquetRepo;

    @Test
    public void select() {
        assertNotNull(flowerInBouquetRepo.select(1));
    }

    @Test
    public void update() {
        assertEquals(flowerInBouquetRepo.update(new FlowerInBouquet(1, 1, 1, 11)), 1);
    }

    @Test
    public void create() {
        assertEquals(flowerInBouquetRepo.create(new FlowerInBouquet(1, 1, 1, 11)), 1);
    }

    @Test
    public void delete() {
        assertEquals(flowerInBouquetRepo.delete(2), 1);
    }
}
