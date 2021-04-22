package org.example.repoTests;

import org.example.entity.User;
import org.example.repository.impl.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@JdbcTest
public class UsersTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void select() {
        assertNotNull(userRepository.select(1));
    }

    @Test
    public void update() {
        assertEquals(userRepository.update(new User(1, "username", "email", "phone", "role", true, new Timestamp(System.currentTimeMillis()))), 1);
    }

    @Test
    public void create() {
        assertEquals(userRepository.create(new User(1, "username", "email", "phone", "role", true, new Timestamp(System.currentTimeMillis()))), 1);
    }

    @Test
    public void delete() {
        assertEquals(userRepository.delete(1), 1);
    }
}
