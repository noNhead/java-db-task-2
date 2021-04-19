package org.example.repository.impl;

import org.example.entity.Courier;
import org.example.repository.RepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class CourierRepo implements RepositoryCrud<Courier> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Courier select(int id) {
        String query = "SELECT * FROM internet_shop.courier WHERE id = ?";
        return null;
    }

    @Override
    public void delete(Courier object) {

    }

    @Override
    public void update(Courier object) {

    }

    @Override
    public void create(Courier object) {

    }
}
