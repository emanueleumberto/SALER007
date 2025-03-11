package com.example.SpringWebRest.runners;

import com.example.SpringWebRest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserRunner implements CommandLineRunner {

    @Autowired UserService userService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("UserRunner...");
        //initDB(10);
    }

    public void initDB(int n) {
        for (int i = 0; i < n; i++) {
            userService.create(userService.createFakeUser());
        }
        System.out.println("Database inizializzato con " + n + " utenti!!!") ;
    }

}
