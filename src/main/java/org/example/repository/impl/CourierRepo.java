package org.example.repository.impl;

import org.example.entity.Address;
import org.example.entity.Courier;
import org.example.repository.RepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourierRepo implements RepositoryCrud<Courier> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Courier select(int id) {
        String query = "SELECT * FROM internet_shop.courier WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet, i) -> new Courier(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("phone")));
    }

    @Override
    public void delete(Courier object) {
        String query = "DELETE FROM internet_shop.courier WHERE id = ?";
        jdbcTemplate.update(
                query,
                object.getId());
    }

    @Override
    public void update(Courier object) {
        String query = "UPDATE internet_shop.courier SET name = ?, phone = ? WHERE id = ?";
        jdbcTemplate.update(
                query,
                object.getName(),
                object.getPhone(),
                object.getId());
    }

    @Override
    public void create(Courier object) {
        String query = "INSERT INTO internet_shop.courier (name, phone) " +
                "VALUES (?, ?)";
        jdbcTemplate.update(
                query,
                object.getName(),
                object.getPhone());
    }
}
