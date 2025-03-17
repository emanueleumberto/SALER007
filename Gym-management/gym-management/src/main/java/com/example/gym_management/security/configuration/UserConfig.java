package com.example.gym_management.security.configuration;

import com.example.gym_management.security.entity.ERole;
import com.example.gym_management.security.entity.Role;
import com.example.gym_management.security.payload.RegisterDto;
import com.example.gym_management.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.util.HashSet;
import java.util.Set;

@Configuration
@PropertySource("application.properties")
public class UserConfig {

    @Autowired RoleRepository roleRepository;
    @Value("${user.admin.name}") private String adminName;
    @Value("${user.admin.username}") private String adminUsername;
    @Value("${user.admin.email}") private String adminEmail;
    @Value("${user.admin.password}") private String adminPassword;
    @Value("${user.admin.role}") private String adminRole;

    @Bean
    @Scope("singleton")
    public RegisterDto createUserAdmin() {

        Set<String> roles = new HashSet<>();
        roles.add(adminRole);

        RegisterDto admin = new RegisterDto();
        admin.setName(adminName);
        admin.setUsername(adminUsername);
        admin.setEmail(adminEmail);
        admin.setPassword(adminPassword);
        admin.setRoles(roles);
        return admin;
    }

}
