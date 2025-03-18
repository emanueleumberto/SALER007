package com.example.gym_management.controllers;

import com.example.gym_management.models.Membership;
import com.example.gym_management.payloadDTO.MembershipDTO;
import com.example.gym_management.payloadDTO.ResponseMembershipDTO;
import com.example.gym_management.services.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/membership")
public class MembershipController {

    @Autowired MembershipService membershipService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createMembership(@RequestBody MembershipDTO membershipDTO) {
        ResponseMembershipDTO membership = membershipService.createMembership(membershipDTO);
        return new ResponseEntity<>(membership, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> getMembership(@PathVariable Long userId) {
        return new ResponseEntity<>(membershipService.getMembershipUser(userId), HttpStatus.OK);
    }

    @PatchMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> activeMembership(@PathVariable Long userId) {
        return new ResponseEntity<>(membershipService.activeMembershipUser(userId), HttpStatus.OK);
    }


}
