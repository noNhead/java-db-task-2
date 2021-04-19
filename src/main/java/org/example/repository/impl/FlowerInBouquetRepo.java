package org.example.repository.impl;

import org.example.entity.FlowerInBouquet;
import org.example.repository.RepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class FlowerInBouquetRepo implements RepositoryCrud<FlowerInBouquet> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public FlowerInBouquet select(int id) {
        return null;
    }

    @Override
    public void delete(FlowerInBouquet object) {

    }

    @Override
    public void update(FlowerInBouquet object) {

    }

    @Override
    public void create(FlowerInBouquet object) {

    }
}
