package org.example.repository.impl;

import org.example.entity.FlowerInBouquet;
import org.example.repository.RepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FlowerInBouquetRepo implements RepositoryCrud<FlowerInBouquet> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public FlowerInBouquet select(int id) {
        String query = "SELECT * FROM internet_shop.flower_has_bouquet WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet, i) -> new FlowerInBouquet(
                resultSet.getInt("id"),
                resultSet.getInt("flower_id"),
                resultSet.getInt("bouquet_id"),
                resultSet.getInt("number")));
    }

    @Override
    public int delete(int id) {
        String query = "DELETE FROM internet_shop.flower_has_bouquet WHERE id = ?";
        return jdbcTemplate.update(
                query,
                id);
    }

    @Override
    public int update(FlowerInBouquet object) {
        String query = "UPDATE internet_shop.flower_has_bouquet SET flower_id = ?, bouquet_id = ?, " +
                "number = ? WHERE id = ?";
        return jdbcTemplate.update(
                query,
                object.getFlowerId(),
                object.getBouquetId(),
                object.getNumber(),
                object.getId());
    }

    @Override
    public int create(FlowerInBouquet object) {
        String query = "INSERT INTO internet_shop.flower_has_bouquet (flower_id, bouquet_id, number) " +
                "VALUES (?, ?, ?)";
        return jdbcTemplate.update(
                query,
                object.getFlowerId(),
                object.getBouquetId(),
                object.getNumber());
    }
}
