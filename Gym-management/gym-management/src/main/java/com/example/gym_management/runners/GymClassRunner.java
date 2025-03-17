package com.example.gym_management.runners;

import com.example.gym_management.models.GymClass;
import com.example.gym_management.repositories.GymClassRepository;
import com.example.gym_management.security.entity.User;
import com.example.gym_management.security.repository.UserRepository;
import com.example.gym_management.services.GymClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Component
public class GymClassRunner implements CommandLineRunner {

    @Autowired UserRepository userRepository;
    @Autowired GymClassService gymClassService;
    @Autowired GymClassRepository gymClassRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("GymClassRunner...");

    }


}
