package com.example.gym_management.configurations;

import com.example.gym_management.models.Membership;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MembershipConfiguration {

    @Bean
    @Scope("prototype")
    public Membership createMembership() {
        return new Membership();
    }

}
