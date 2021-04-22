package org.example.repoTests;

import org.example.entity.Bouquet;
import org.example.repository.impl.BouquetRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@JdbcTest
public class BouquetTest {
        @Autowired
        private BouquetRepo bouquetRepo;

        @Test
        public void select() {
            assertNotNull(bouquetRepo.select(1));
        }

        @Test
        public void update() {
            assertEquals(bouquetRepo.update(new Bouquet(1, "bouquet name", "description")), 1);
        }

        @Test
        public void create() {
            assertEquals(bouquetRepo.create(new Bouquet(1, "bouquet name", "description")), 1);
        }

        @Test
        public void delete() {
            assertEquals(bouquetRepo.delete(1), 1);
        }
}
