package org.example.repository.impl;

import org.example.repository.RepositoryCrud;
import org.example.entity.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class FlowerRepo implements RepositoryCrud<Flower>{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Flower select(int id) {
        String query = "SELECT * FROM internet_shop.flower WHERE id = ?";
        return null;
    }

    @Override
    public void delete(Flower object) {

    }

    @Override
    public void update(Flower object) {

    }

    @Override
    public void create(Flower object) {

    }
}
