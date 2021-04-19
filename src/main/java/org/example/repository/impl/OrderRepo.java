package org.example.repository.impl;

import org.example.entity.Order;
import org.example.repository.RepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class OrderRepo implements RepositoryCrud<Order> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Order select(int id) {
        String query = "SELECT * FROM internet_shop.order WHERE id = ?";
        return null;
    }

    @Override
    public void delete(Order object) {

    }

    @Override
    public void update(Order object) {

    }

    @Override
    public void create(Order object) {

    }
}
