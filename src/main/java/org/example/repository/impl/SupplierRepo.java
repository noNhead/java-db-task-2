package org.example.repository.impl;

import org.example.repository.RepositoryCrud;
import org.example.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SupplierRepo implements RepositoryCrud<Supplier> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Supplier select(int id) {
        String query = "SELECT * FROM internet_shop.supplier WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet, i) -> new Supplier(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("phone"),
                resultSet.getString("email"),
                resultSet.getInt("address_id")));
    }

    @Override
    public void delete(Supplier object) {
        String query = "DELETE FROM internet_shop.supplier WHERE id = ?";
        jdbcTemplate.update(
                query,
                object.getId());
    }

    @Override
    public void update(Supplier object) {
        String query = "UPDATE internet_shop.supplier SET name = ?, phone = ?, " +
                "email = ? WHERE id = ?";
        jdbcTemplate.update(
                query,
                object.getName(),
                object.getPhone(),
                object.getEmail(),
                object.getId());
    }

    @Override
    public void create(Supplier object) {
        String query = "INSERT INTO internet_shop.supplier (name, phone, email) " +
                "VALUES (?, ?, ?)";
        jdbcTemplate.update(
                query,
                object.getName(),
                object.getPhone(),
                object.getEmail());
    }
}
