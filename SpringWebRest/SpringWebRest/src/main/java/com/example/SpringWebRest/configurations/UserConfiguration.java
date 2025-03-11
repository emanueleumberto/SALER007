package com.example.SpringWebRest.configurations;

import com.example.SpringWebRest.models.User;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Locale;

@Configuration
public class UserConfiguration {

    @Bean
    @Scope("prototype")
    public User createCustomUser() {
        return new User();
    }

    @Bean
    @Scope("prototype")
    public User createFakeUser() {
        Faker fake = new Faker(new Locale("it-IT"));
        User user = new User();
        user.setFirstname(fake.name().firstName());
        user.setLastname(fake.name().lastName());
        user.setCity(fake.address().cityName());
        user.setEmail(fake.internet().emailAddress());
        user.setPassword(fake.internet().password(6,10));
        return user;
    }

}
