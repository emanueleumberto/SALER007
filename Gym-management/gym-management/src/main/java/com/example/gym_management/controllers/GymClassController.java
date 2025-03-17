package com.example.gym_management.controllers;

import com.example.gym_management.models.GymClass;
import com.example.gym_management.payloadDTO.GymClassDTO;
import com.example.gym_management.payloadDTO.MembershipDTO;
import com.example.gym_management.payloadDTO.ResponseGymClassDTO;
import com.example.gym_management.services.GymClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/classes")
public class GymClassController {

    @Autowired GymClassService gymClassService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createGymClass(@RequestBody GymClassDTO gymClassDTO) {
        ResponseGymClassDTO response = gymClassService.createGymClass(gymClassDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> findGymClass() {
        return new ResponseEntity<>(gymClassService.getGymClassList(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('INSTRUCTOR') or hasRole('ADMIN')")
    public ResponseEntity<?> findClientsGymClass(@PathVariable Long id) {

        return new ResponseEntity<>(gymClassService.getClientsByGymClass(id), HttpStatus.OK);
    }

}
