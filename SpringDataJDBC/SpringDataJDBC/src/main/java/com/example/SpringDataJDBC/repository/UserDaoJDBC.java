package com.example.SpringDataJDBC.repository;

import com.example.SpringDataJDBC.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoJDBC implements UserDaoRepository {

    @Autowired JdbcTemplate jdbc;

    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO users(firstname, lastname, city, age, email) " +
                "VALUES (?, ?, ?, ?, ?)";
        jdbc.update(sql,
                user.getFirstname(),
                user.getLastname(),
                user.getCity(),
                user.getAge(),
                user.getEmail());
    }

    @Override
    public User getUser(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbc.queryForObject(sql, new UserRowMapper(), id);
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE users SET firstname = ?, lastname = ?, age = ?, " +
                "city = ?, email = ? WHERE id = ?";
        jdbc.update(sql,
                user.getFirstname(),
                user.getLastname(),
                user.getAge(),
                user.getCity(),
                user.getEmail(),
                user.getId());
    }

    @Override
    public void deleteUser(User user) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbc.update(sql, user.getId());
    }

    @Override
    public List<User> getAllUser() {
        String sql = "SELECT * FROM users";
        return jdbc.query(sql, new UserRowMapper());
    }

    @Override
    public List<User> getAllByCity(String city) {
        String sql = "SELECT * FROM users WHERE city LIKE concat('%', ?, '%')";
        return jdbc.query(sql, new UserRowMapper(), city);
    }
}
