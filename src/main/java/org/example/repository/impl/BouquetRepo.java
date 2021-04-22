package org.example.repository.impl;

import org.example.entity.Bouquet;
import org.example.repository.RepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BouquetRepo implements RepositoryCrud<Bouquet> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Bouquet select(int id) {
        String query = "SELECT * FROM internet_shop.bouquet WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet, i) -> new Bouquet(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("description")));
    }

    @Override
    public int delete(int id) {
        String query = "DELETE FROM internet_shop.bouquet WHERE id = ?";
        return jdbcTemplate.update(
                query,
                id);
    }

    @Override
    public int update(Bouquet object) {
        String query = "UPDATE internet_shop.bouquet SET name = ?, description = ? WHERE id = ?";
        return jdbcTemplate.update(
                query,
                object.getName(),
                object.getDescription(),
                object.getId());
    }

    @Override
    public int create(Bouquet object) {
        String query = "INSERT INTO internet_shop.bouquet (name, description) " +
                "VALUES (?, ?)";
        return jdbcTemplate.update(
                query,
                object.getName(),
                object.getDescription());
    }
}
