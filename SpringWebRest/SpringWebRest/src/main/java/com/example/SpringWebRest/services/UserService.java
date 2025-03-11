package com.example.SpringWebRest.services;

import com.example.SpringWebRest.models.User;
import com.example.SpringWebRest.repositories.UserRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired UserRepository userRepository;
    @Autowired @Qualifier("createFakeUser") ObjectProvider<User> userObjectProvider;

    // User Method
    public User createFakeUser() {
        return userObjectProvider.getObject();
    }

    // CRUD Method

    public User create(User user) {
        userRepository.save(user);
        return user;
    }

    public User update(User user) {
        userRepository.save(user);
        return user;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
