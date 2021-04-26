package org.example.repository.impl;

import org.example.data.Order;
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
        String query = "SELECT * FROM internet_shop.order_repo WHERE id = ?";
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
    public int delete(int id) {
        String query = "DELETE FROM internet_shop.order_repo WHERE id = ?";
        return jdbcTemplate.update(
                query,
                id);
    }

    @Override
    public int update(Order object) {
        String query = "UPDATE internet_shop.order_repo SET username_id = ?, date = ?, " +
                "courier_id = ?, promotional_codes = ?, bouquet_id = ?, address_id = ? WHERE id = ?";
        return jdbcTemplate.update(
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
    public int create(Order object) {
        String query = "INSERT INTO internet_shop.order_repo " +
                "(username_id, date, courier_id, promotional_codes, bouquet_id, address_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
                query,
                object.getUsernameId(),
                object.getTimeToDelivery(),
                object.getCourierId(),
                object.getPromotionalCodeId(),
                object.getBouquetId(),
                object.getAddressId());
    }
}
