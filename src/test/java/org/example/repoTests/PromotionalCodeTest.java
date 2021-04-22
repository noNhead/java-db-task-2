package org.example.repoTests;

import org.example.entity.PromotionalCode;
import org.example.repository.impl.PromotionalCodeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@JdbcTest
public class PromotionalCodeTest {
    @Autowired
    private PromotionalCodeRepo promotionalCodeRepo;

    @Test
    public void select() {
        assertNotNull(promotionalCodeRepo.select(1));
    }

    @Test
    public void update() {
        assertEquals(promotionalCodeRepo.update(new PromotionalCode(1, "code", "description", true)), 1);
    }

    @Test
    public void create() {
        assertEquals(promotionalCodeRepo.create(new PromotionalCode(1, "code", "description", true)), 1);
    }

    @Test
    public void delete() {
        assertEquals(promotionalCodeRepo.delete(1), 1);
    }
}
