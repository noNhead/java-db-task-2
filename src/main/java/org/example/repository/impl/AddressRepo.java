package org.example.repository.impl;

import org.example.entity.Address;
import org.example.repository.RepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AddressRepo implements RepositoryCrud<Address> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Address select(int id) {
        String query = "SELECT * FROM internet_shop.address WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet, i) -> new Address(
                resultSet.getInt("id"),
                resultSet.getString("country"),
                resultSet.getString("city"),
                resultSet.getString("street"),
                resultSet.getString("house"),
                resultSet.getString("apartment")));
    }

    @Override
    public int delete(int id) {
        String query = "DELETE FROM internet_shop.address WHERE id = ?";
        return jdbcTemplate.update(
                query,
                id);
    }

    @Override
    public int update(Address object) {
        String query = "UPDATE internet_shop.address SET country = ?, city = ?, " +
                "street = ?, house = ?, apartment = ? WHERE id = ?";
        return jdbcTemplate.update(
                query,
                object.getCountry(),
                object.getCity(),
                object.getStreet(),
                object.getHouse(),
                object.getApartment(),
                object.getId());
    }

    @Override
    public int create(Address object) {
        String query = "INSERT INTO internet_shop.address (country, city, street, house, apartment) " +
                "VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
                query,
                object.getCountry(),
                object.getCity(),
                object.getStreet(),
                object.getHouse(),
                object.getApartment());
    }
}
