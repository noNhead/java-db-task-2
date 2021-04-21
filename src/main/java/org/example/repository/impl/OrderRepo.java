package org.example.repository.impl;

import org.example.entity.Address;
import org.example.entity.Order;
import org.example.repository.RepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepo implements RepositoryCrud<Order> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Order select(int id) {
        String query = "SELECT * FROM internet_shop.order WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet, i) -> new Order(
                resultSet.getInt("id"),
                resultSet.getInt("username_id"),
                resultSet.getInt("courier_id"),
                resultSet.getInt("promotional_codes"),
                resultSet.getInt("bouquet_id"),
                resultSet.getInt("address_id"),
                resultSet.getTimestamp("date")));
    }

    @Override
    public void delete(Order object) {
        String query = "DELETE FROM internet_shop.order WHERE id = ?";
        jdbcTemplate.update(
                query,
                object.getId());
    }

    @Override
    public void update(Order object) {
        String query = "UPDATE internet_shop.order SET username_id = ?, date = ?, " +
                "courier_id = ?, promotional_codes = ?, bouquet_id = ?, address_id = ? WHERE id = ?";
        jdbcTemplate.update(
                query,
                object.getUsernameId(),
                object.getTimeToDelivery(),
                object.getCourierId(),
                object.getPromotionalCodeId(),
                object.getBouquetId(),
                object.getAddressId(),
                object.getId());
    }

    @Override
    public void create(Order object) {
        String query = "INSERT INTO internet_shop.order " +
                "(username_id, date, courier_id, promotional_codes, bouquet_id, address_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                query,
                object.getUsernameId(),
                object.getTimeToDelivery(),
                object.getCourierId(),
                object.getPromotionalCodeId(),
                object.getBouquetId(),
                object.getAddressId());
    }
}
