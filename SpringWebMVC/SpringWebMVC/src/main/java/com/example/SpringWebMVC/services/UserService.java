package com.example.SpringWebMVC.services;

import com.example.SpringWebMVC.model.User;
import com.example.SpringWebMVC.repository.UserDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired UserDAORepository db;

    public User checkLogin(String email, String password) {
        return db.findByEmailAndPassword(email, password);
    }

}
