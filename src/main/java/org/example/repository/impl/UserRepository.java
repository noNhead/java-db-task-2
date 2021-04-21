package org.example.repository.impl;

import org.example.entity.User;
import org.example.repository.RepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements RepositoryCrud<User> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User select(int id) {
        String query = "SELECT * FROM internet_shop.username WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet, i) -> new User(
                resultSet.getInt("id"),
                resultSet.getString("username"),
                resultSet.getString("email"),
                resultSet.getString("phone"),
                resultSet.getString("role"),
                resultSet.getBoolean("active"),
                resultSet.getTimestamp("create_time")));
    }

    @Override
    public void delete(User object) {
        String query = "DELETE FROM internet_shop.username WHERE id = ?";
        jdbcTemplate.update(
                query,
                object.getId());
    }

    @Override
    public void update(User object) {
        String query = "UPDATE internet_shop.username SET username = ?, email = ?, " +
                "create_time = ?, active = ?, role = ?, phone = ? WHERE id = ?";
        jdbcTemplate.update(
                query,
                object.getUsername(),
                object.getEmail(),
                object.getCreateTime(),
                object.isActive(),
                object.getRole(),
                object.getPhone(),
                object.getId());
    }

    @Override
    public void create(User object) {
        String query = "INSERT INTO internet_shop.users (username, email, create_time, active, role, phone) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                query,
                object.getUsername(),
                object.getEmail(),
                object.getCreateTime(),
                object.isActive(),
                object.getRole(),
                object.getPhone());
    }
}
