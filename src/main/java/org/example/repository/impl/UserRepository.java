package org.example.repository.impl;

import org.example.entity.User;
import org.example.repository.RepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements RepositoryCrud<User> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User select(int id) {
        return null;
    }

    @Override
    public void delete(User object) {

    }

    @Override
    public void update(User object) {

    }

    @Override
    public void create(User object) {

    }
}
