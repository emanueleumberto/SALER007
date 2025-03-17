package com.example.gym_management.runners;

import com.example.gym_management.enumerations.MembershipType;
import com.example.gym_management.models.Membership;
import com.example.gym_management.payloadDTO.MembershipDTO;
import com.example.gym_management.repositories.MembershipRepository;
import com.example.gym_management.security.entity.User;
import com.example.gym_management.security.repository.UserRepository;
import com.example.gym_management.services.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MembershipRunner implements CommandLineRunner {

    @Autowired MembershipService membershipService;
    @Autowired MembershipRepository membershipRepository;
    @Autowired UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("MembershipRunner...");

    }

}
