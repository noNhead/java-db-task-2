package org.example.repository.impl;

import org.example.entity.FlowerSupplyFromSupplier;
import org.example.repository.RepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SupplyFlowerFromSupplierRepo implements RepositoryCrud<FlowerSupplyFromSupplier> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public FlowerSupplyFromSupplier select(int id) {
        String query = "SELECT * FROM internet_shop.flower_has_supplier WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet, i) -> new FlowerSupplyFromSupplier(
                resultSet.getInt("id"),
                resultSet.getInt("flower_id"),
                resultSet.getInt("supplier_id"),
                resultSet.getInt("number"),
                resultSet.getTimestamp("delivery_date")));
    }

    @Override
    public void delete(FlowerSupplyFromSupplier object) {
        String query = "DELETE FROM internet_shop.flower_has_supplier WHERE id = ?";
        jdbcTemplate.update(
                query,
                object.getId());
    }

    @Override
    public void update(FlowerSupplyFromSupplier object) {
        String query = "UPDATE internet_shop.flower_has_supplier SET flower_id = ?, supplier_id = ?, " +
                "number = ?, delivery_date = ? WHERE id = ?";
        jdbcTemplate.update(
                query,
                object.getFlowerId(),
                object.getSupplierId(),
                object.getNumber(),
                object.getDeliveryTimestamp(),
                object.getId());
    }

    @Override
    public void create(FlowerSupplyFromSupplier object) {
        String query = "INSERT INTO internet_shop.flower_has_supplier (flower_id, supplier_id, number, delivery_date) " +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(
                query,
                object.getFlowerId(),
                object.getSupplierId(),
                object.getNumber(),
                object.getDeliveryTimestamp());
    }
}
