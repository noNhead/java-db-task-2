package org.example.repository.impl;

import org.example.entity.Bouquet;
import org.example.repository.RepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BouquetRepo implements RepositoryCrud<Bouquet> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Bouquet select(int id) {
        return null;
    }

    @Override
    public void delete(Bouquet object) {

    }

    @Override
    public void update(Bouquet object) {

    }

    @Override
    public void create(Bouquet object) {

    }
}
