package com.example.introSpringDI.service;

import com.example.introSpringDI.model.User;
import com.example.introSpringDI.model.UserList;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired @Qualifier("adminUser")  ObjectProvider<User> adminUserProvider;
    @Autowired @Qualifier("fakeUser") ObjectProvider<User> fakeUserProvider;
    @Autowired @Qualifier("customUser") ObjectProvider<User> customUserProvider;
    @Autowired @Qualifier("userList") ObjectProvider<UserList> userListObjectProvider;

    public User createAdminUser() {
        return adminUserProvider.getObject();
    }

    public User createFakeUser() {
        return fakeUserProvider.getObject();
    }

    public User createCustomUser(String firstname, String lastname, String city, Integer age, String email) {
        User user = customUserProvider.getObject();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setCity(city);
        user.setAge(age);
        user.setEmail(email);
        return user;
    }

    public UserList createUserList(String name) {
        UserList userList = userListObjectProvider.getObject();
        userList.setName(name);
        userList.setLista(new ArrayList<User>());
        return userList;
    }

}
