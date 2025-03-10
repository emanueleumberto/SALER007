package com.example.SpringWebMVCEsercizio.configurations;

import com.example.SpringWebMVCEsercizio.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class UsersConfiguration {

    @Bean
    @Scope("prototype")
    public User createUser() {
        return new User();
    }

}
