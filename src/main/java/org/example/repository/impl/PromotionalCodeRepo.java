package org.example.repository.impl;

import org.example.entity.PromotionalCode;
import org.example.repository.RepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PromotionalCodeRepo implements RepositoryCrud<PromotionalCode> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public PromotionalCode select(int id) {
        String query = "SELECT * FROM internet_shop.promotional_code WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet, i) -> new PromotionalCode(
                resultSet.getInt("id"),
                resultSet.getString("code"),
                resultSet.getString("description"),
                resultSet.getBoolean("active")));
    }

    @Override
    public int delete(int id) {
        String query = "DELETE FROM internet_shop.promotional_code WHERE id = ?";
        return jdbcTemplate.update(
                query,
                id);
    }

    @Override
    public int update(PromotionalCode object) {
        String query = "UPDATE internet_shop.promotional_code SET code = ?, description = ?, " +
                "active = ? WHERE id = ?";
        return jdbcTemplate.update(
                query,
                object.getCode(),
                object.getDescription(),
                object.isActive(),
                object.getId());
    }

    @Override
    public int create(PromotionalCode object) {
        String query = "INSERT INTO internet_shop.promotional_code (code, description, active) " +
                "VALUES (?, ?, ?)";
        return jdbcTemplate.update(
                query,
                object.getCode(),
                object.getDescription(),
                object.isActive());
    }
}
