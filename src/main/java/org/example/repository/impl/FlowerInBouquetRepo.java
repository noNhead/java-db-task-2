package org.example.repository.impl;

import org.example.data.Bouquet;
import org.example.data.Flower;
import org.example.repository.RepositoryCrudFlowerInBouquet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class FlowerInBouquetRepo implements RepositoryCrudFlowerInBouquet<Flower, Bouquet> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> select(int id) {
        String query = "SELECT * FROM internet_shop.flower_has_bouquet WHERE id = ?";
        return jdbcTemplate.queryForMap(query, id);
    }

    @Override
    public int delete(int id) {
        String query = "DELETE FROM internet_shop.flower_has_bouquet WHERE id = ?";
        return jdbcTemplate.update(
                query,
                id);
    }

    @Override
    public int update(Flower flower, Bouquet bouquet, int id) {
        String query = "UPDATE internet_shop.flower_has_bouquet SET flower_id = ?, bouquet_id = ?, " +
                "number = ? WHERE id = ?";
        return jdbcTemplate.update(
                query,
                flower.getId(),
                bouquet.getId(),
                flower.getNumber(),
                id);
    }

    @Override
    public int create(Flower flower, Bouquet bouquet) {
        String query = "INSERT INTO internet_shop.flower_has_bouquet (flower_id, bouquet_id, number) " +
                "VALUES (?, ?, ?)";
        return jdbcTemplate.update(
                query,
                flower.getId(),
                bouquet.getId(),
                flower);
    }
}
