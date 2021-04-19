package org.example.repository.impl;

import org.example.repository.RepositoryCrud;
import org.example.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class SupplierRepo implements RepositoryCrud<Supplier> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Supplier select(int id) {
        String query = "SELECT * FROM internet_shop.supplier WHERE id = ?";
        return null;
    }

    @Override
    public void delete(Supplier object) {

    }

    @Override
    public void update(Supplier object) {

    }

    @Override
    public void create(Supplier object) {

    }
}
