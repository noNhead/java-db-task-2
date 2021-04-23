package org.example.repoTests;

import org.example.entity.PromotionalCode;
import org.example.repository.impl.PromotionalCodeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase
@Sql({"schema_promotional_code.sql"})
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
        assertEquals(promotionalCodeRepo.delete(2), 1);
    }
}
