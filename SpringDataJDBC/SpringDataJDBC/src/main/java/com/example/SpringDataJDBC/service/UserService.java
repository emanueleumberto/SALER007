package com.example.SpringDataJDBC.service;

import com.example.SpringDataJDBC.model.User;
import com.example.SpringDataJDBC.repository.UserDaoJDBC;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired UserDaoJDBC db;
    @Autowired @Qualifier("customUser") ObjectProvider<User> customUserObjectProvider;
    @Autowired @Qualifier("fakeUser") ObjectProvider<User> fakeUserObjectProvider;

    public User createCustomUser(String firstname, String lastname, String city, Integer age, String email) {
        User user = customUserObjectProvider.getObject();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setCity(city);
        user.setAge(age);
        user.setEmail(email);
        return user;
    }

    public User createFakeUser() {
        return fakeUserObjectProvider.getObject();
    }

    // JDBC Method

    public void saveUser(User user) {
        db.insertUser(user);
        System.out.println(user.getFirstname() + " " + user.getLastname() + " inserito nel DB!");
    }

    public User findUser(long id) {
        return db.getUser(id);
    }

    public void updateUser(User user) {
        db.updateUser(user);
        System.out.println(user.getFirstname() + " " + user.getLastname() + " modificato nel DB!");
    }

    public void removeUser(User user) {
        db.deleteUser(user);
        System.out.println(user.getFirstname() + " " + user.getLastname() + " eliminato dal DB!");
    }

    public List<User> findAll() {
        return db.getAllUser();
    }

    public List<User> findAllByCity(String city) {
        return db.getAllByCity(city);
    }
}
