package org.example.repoTests;

import org.example.entity.Address;
import org.example.repository.impl.AddressRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@JdbcTest
public class AddressTest {
    @Autowired
    private AddressRepo addressRepo;

    @Test
    public void select() {
        assertNotNull(addressRepo.select(1));
    }

    @Test
    public void update() {
        assertEquals(addressRepo.update(new Address(
                1,
                "country",
                "city",
                "street",
                "house",
                "apartment1")), 1);
    }

    @Test
    public void create() {
        assertEquals(addressRepo.create(new Address(
                1,
                "country",
                "city",
                "street",
                "house",
                "apartment1")), 1);
    }

    @Test
    public void delete() {
        assertEquals(addressRepo.delete(1), 1);
    }
}
