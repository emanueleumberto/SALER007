package com.example.gym_management.configurations;

import com.example.gym_management.models.GymClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class GymClassConfigurations {

    @Bean
    @Scope("prototype")
    public GymClass createGymClass() {
        return new GymClass();
    }

}
