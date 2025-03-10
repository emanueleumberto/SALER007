package com.example.SpringWebMVC.repository;

import com.example.SpringWebMVC.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAORepository extends JpaRepository<User, Long> {

    public User findByEmailAndPassword(String email, String password);

}
