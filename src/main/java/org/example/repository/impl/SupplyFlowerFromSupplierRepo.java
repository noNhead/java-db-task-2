package org.example.repository.impl;

import org.example.entity.FlowerSupplyFromSupplier;
import org.example.repository.RepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class SupplyFlowerFromSupplierRepo implements RepositoryCrud<FlowerSupplyFromSupplier> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public FlowerSupplyFromSupplier select(int id) {
        return null;
    }

    @Override
    public void delete(FlowerSupplyFromSupplier object) {

    }

    @Override
    public void update(FlowerSupplyFromSupplier object) {

    }

    @Override
    public void create(FlowerSupplyFromSupplier object) {

    }
}
