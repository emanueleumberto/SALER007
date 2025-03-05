package com.example.SpringDataJDBC.configuration;

import com.example.SpringDataJDBC.model.User;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Locale;

@Configuration
public class UserConfiguration {

    @Bean("customUser")
    @Scope("prototype")
    public User createCustomUser() {
        return new User();
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

}
