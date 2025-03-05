package com.example.SpringDataJDBC.runner;

import com.example.SpringDataJDBC.model.User;
import com.example.SpringDataJDBC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserRunner implements CommandLineRunner {

    @Autowired private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("UserRunner....");

        //User u1 = userService.createCustomUser("Mario", "Rossi", "Roma", 45, "m.rossi@example.com");
        //User u2 = userService.createFakeUser();
        //User u3 = userService.createFakeUser();

        //System.out.println(u1);
        //System.out.println(u2);
        //System.out.println(u3);

        //userService.saveUser(u1);
        //userService.saveUser(u2);
        //userService.saveUser(u3);
        //User u = userService.findUser(1);
        //System.out.println(u);
        //u.setCity("Milano");
        //userService.updateUser(u);
        //userService.removeUser(u);

        //userService.findAll().forEach(System.out::println);
        userService.findAllByCity("salentino").forEach(System.out::println);
    }
}
