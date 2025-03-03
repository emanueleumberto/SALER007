package com.example.intoSpring.configurations;

import com.example.intoSpring.classes.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("application.properties")
public class ConfigurationUser {

    @Value("${user.admin.name}") private String adminName;
    @Value("${user.admin.lastname}") private String adminLastname;
    @Value("${user.admin.city}") private String adminCity;
    @Value("${user.admin.age}") private Integer adminAge;
    @Value("${user.admin.email}") private String adminEmail;

    @Bean(name = "userDefault")
    @Scope("singleton")
    public User createUser() {
        return new User("Mario", "Rossi", "Roma", 45, "m.rossi@example.com");
    }

    @Bean(name = "customUser")
    @Scope("prototype")
    public User createCustomUser(String name, String lastname, String city, Integer age, String email) {
        return new User(name, lastname, city, age, email);
    }

    @Bean(name = "adminUser")
    @Scope("singleton")
    public User createAdminUser() {
        return new User(adminName, adminLastname, adminCity, adminAge,adminEmail);
    }



}
