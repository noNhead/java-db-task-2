package org.example.repository.impl;

import org.example.data.Flower;
import org.example.data.Supplier;
import org.example.repository.RepositoryCrudFlowerFromSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Map;

@Repository
public class SupplyFlowerFromSupplierRepo implements RepositoryCrudFlowerFromSupplier<Flower, Supplier> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> select(int id) {
        String query = "SELECT * FROM internet_shop.flower_has_supplier WHERE id = ?";
        return jdbcTemplate.queryForMap(query, id);
    }

    @Override
    public int delete(int id) {
        String query = "DELETE FROM internet_shop.flower_has_supplier WHERE id = ?";
        return jdbcTemplate.update(
                query,
                id);
    }

    @Override
    public int update(Flower flower, Supplier supplier, Timestamp timestamp, int id) {
        String query = "UPDATE internet_shop.flower_has_supplier SET flower_id = ?, supplier_id = ?, " +
                "number = ?, delivery_date = ? WHERE id = ?";
        return jdbcTemplate.update(
                query,
                flower.getId(),
                supplier.getId(),
                flower.getNumber(),
                timestamp,
                id);
    }

    @Override
    public int create(Flower flower, Supplier supplier, Timestamp timestamp) {
        String query = "INSERT INTO internet_shop.flower_has_supplier (flower_id, supplier_id, number, delivery_date) " +
                "VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(
                query,
                flower.getId(),
                supplier.getId(),
                flower.getNumber(),
                timestamp);
    }
}
