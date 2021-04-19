package org.example.repository.impl;

import org.example.entity.PromotionalCode;
import org.example.repository.RepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class PromotionalCodeRepo implements RepositoryCrud<PromotionalCode> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public PromotionalCode select(int id) {
        String query = "SELECT * FROM internet_shop.promotional_code WHERE id = ?";
        return null;
    }

    @Override
    public void delete(PromotionalCode object) {

    }

    @Override
    public void update(PromotionalCode object) {

    }

    @Override
    public void create(PromotionalCode object) {

    }
}
