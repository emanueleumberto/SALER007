package com.example.gym_management.services;

import com.example.gym_management.enumerations.MembershipType;
import com.example.gym_management.models.Membership;
import com.example.gym_management.payloadDTO.MembershipDTO;
import com.example.gym_management.payloadDTO.ResponseMembershipDTO;
import com.example.gym_management.repositories.MembershipRepository;
import com.example.gym_management.security.entity.User;
import com.example.gym_management.security.exception.MyAPIException;
import com.example.gym_management.security.repository.UserRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class MembershipService {

    @Autowired @Qualifier("createMembership") ObjectProvider<Membership> membershipObjectProvider;
    @Autowired MembershipRepository membershipRepository;
    @Autowired UserRepository userRepository;

    public ResponseMembershipDTO createMembership(MembershipDTO membershipDTO) {

        // add check for username exists in database
        if(!userRepository.existsByUsername(membershipDTO.getUsername())){
            throw new MyAPIException(HttpStatus.BAD_REQUEST, "Username not exists!.");
        }

        User client = userRepository.findByUsername(membershipDTO.getUsername()).get();

        Membership m = membershipObjectProvider.getObject();
        m.setType(membershipDTO.getType());
        m.setUser(client);
        m.setStartMembership(LocalDate.now());
        m.setEndMembership(LocalDate.now().plusMonths(getMembershipType(membershipDTO.getType())));
        m.setActive(true);

        membershipRepository.save(m);
        System.out.println("Membership " + client.getName()  + " created!");

        ResponseMembershipDTO response = new ResponseMembershipDTO();
        response.setId(m.getId());
        response.setType(m.getType());
        response.setClientName(m.getUser().getName());
        response.setUsername(m.getUser().getUsername());
        response.setEmail(m.getUser().getEmail());
        response.setActive(m.isActive());
        response.setStartMembership(m.getStartMembership());
        response.setEndMembership(m.getEndMembership());

        return response;
    }

    private Integer getMembershipType(MembershipType type) {
        if(type.equals(MembershipType.MONTHLY)) return 1;
        else if(type.equals(MembershipType.QUARTERLY)) return 3;
        else return 12;
    }

    public ResponseMembershipDTO getMembershipUser(Long userId) {
        //List<Membership> membershipList = membershipRepository.findAll();
        //Membership membershipDetail = membershipList.stream().filter(m -> m.getUser().getId() == userId).findFirst().get();

        Membership m = membershipRepository.findByUserId(userId).get();

        ResponseMembershipDTO response = new ResponseMembershipDTO();
        response.setId(m.getId());
        response.setType(m.getType());
        response.setClientName(m.getUser().getName());
        response.setUsername(m.getUser().getUsername());
        response.setEmail(m.getUser().getEmail());
        response.setActive(m.isActive());
        response.setStartMembership(m.getStartMembership());
        response.setEndMembership(m.getEndMembership());

        return response;
    }
}
