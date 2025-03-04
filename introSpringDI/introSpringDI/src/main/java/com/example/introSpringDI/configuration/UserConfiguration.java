package com.example.introSpringDI.configuration;

import com.example.introSpringDI.model.User;
import com.example.introSpringDI.model.UserList;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.util.Locale;

@Configuration
@PropertySource("application.properties")
public class UserConfiguration {

    @Value("${user.admin.firstname}") private String adminFirstmane;
    @Value("${user.admin.lastname}") private String adminLastname;
    @Value("${user.admin.city}") private String adminCity;
    @Value("${user.admin.age}") private Integer adminAge;
    @Value("${user.admin.email}") private String adminEmail;

    @Bean("adminUser")
    @Scope("singleton")
    public User createAdminUser() {
        return new User(adminFirstmane, adminLastname, adminCity, adminAge, adminEmail);
    }

    @Bean("customUser")
    @Scope("prototype")
    public User createCustomUser() {
        return new User();
    }

    @Bean("paramsUser")
    @Scope("prototype")
    public User createCustomUserParm(String firstname, String lastname, String city, Integer age, String email) {
        return User.builder()
                .firstname(firstname)
                .lastname(lastname)
                .age(age)
                .city(city)
                .email(email)
                .build();
    }

    @Bean("fakeUser")
    @Scope("prototype")
    public User createFakeUser() {
        Faker fake = new Faker(new Locale("it-IT"));
        User user = new User();
        user.setFirstname(fake.name().firstName());
        user.setLastname(fake.name().lastName());
        user.setCity(fake.address().cityName());
        user.setAge(fake.number().numberBetween(18,80));
        user.setEmail(fake.internet().emailAddress());
        return user;
    }

    @Bean("userList")
    @Scope("prototype")
    public UserList createCustomUserList() {
        return new UserList();
    }
}
