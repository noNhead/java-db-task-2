package org.example.repository.impl;

import org.example.repository.RepositoryCrud;
import org.example.data.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FlowerRepo implements RepositoryCrud<Flower>{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Flower select(int id) {
        String query = "SELECT * FROM internet_shop.flower WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet, i) -> new Flower(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("number")));
    }

    @Override
    public int delete(int id) {
        String query = "DELETE FROM internet_shop.flower WHERE id = ?";
        return jdbcTemplate.update(
                query,
                id);
    }

    @Override
    public int update(Flower object) {
        String query = "UPDATE internet_shop.flower SET name = ?, number = ? WHERE id = ?";
        return jdbcTemplate.update(
                query,
                object.getName(),
                object.getNumber(),
                object.getId());
    }

    @Override
    public int create(Flower object) {
        String query = "INSERT INTO internet_shop.flower (name, number) " +
                "VALUES (?, ?)";
        return jdbcTemplate.update(
                query,
                object.getName(),
                object.getNumber());
    }
}
