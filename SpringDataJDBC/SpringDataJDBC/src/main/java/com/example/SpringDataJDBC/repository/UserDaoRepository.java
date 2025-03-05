package com.example.SpringDataJDBC.repository;

import com.example.SpringDataJDBC.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDaoRepository {

    // CRUD
    public void insertUser(User user); // Create
    public User getUser(Long id); // Read
    public void updateUser(User user); // Update
    public void deleteUser(User user); // Delete

    public List<User> getAllUser();
    public List<User> getAllByCity(String city);
}
