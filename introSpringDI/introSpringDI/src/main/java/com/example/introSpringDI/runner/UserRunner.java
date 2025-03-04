package com.example.introSpringDI.runner;

import com.example.introSpringDI.configuration.UserConfiguration;
import com.example.introSpringDI.model.User;
import com.example.introSpringDI.model.UserList;
import com.example.introSpringDI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class UserRunner implements CommandLineRunner {

    //UserService userService = new UserService(); Accoppiamento forte!!
    @Autowired private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("UserRunner...");

        /*AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(UserConfiguration.class);

        User admin = (User) appContext.getBean("adminUser");
        User user = (User) appContext.getBean("paramsUser", "Giuseppe", "Verdi", "Milano", 34, "g.verdi@example.com");
        User fake = (User) appContext.getBean("fakeUser");

        System.out.println(admin);
        System.out.println(user);
        System.out.println(fake);

        appContext.close();*/

        UserList ul = userService.createUserList("Utenti Registrati");

        User admin =  userService.createAdminUser();
        User user = userService.createCustomUser("Giuseppe", "Verdi", "Milano", 34, "g.verdi@example.com");

        ul.getLista().add(admin);
        ul.getLista().add(user);

        for (int i = 0; i < 8; i++) {
            User fake = userService.createFakeUser();
            ul.getLista().add(fake);
        }

        System.out.println(ul.getName());
        ul.getLista().forEach(u -> System.out.println(u.getFirstname() + " " + u.getLastname()));

    }

}
