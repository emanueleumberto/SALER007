package com.example.SpringWebMVCEsercizio.services;

import com.example.SpringWebMVCEsercizio.models.User;
import com.example.SpringWebMVCEsercizio.repositories.UsersRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired private UsersRepository db;
    @Autowired @Qualifier("createUser") private ObjectProvider<User> userObjectProvider;

    public User createUser(String firstname, String lastname, String email, String password) {
        User user = userObjectProvider.getObject();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }

    public void saveUser(User user) {
        db.save(user);
    }

    public List<User> findAllUsers() {
        return db.findAll();
    }

    public void removeUser(Long id) {
        db.deleteById(id);
    }
}
