package com.example.gym_management.security.controller;

import com.example.gym_management.security.entity.User;
import com.example.gym_management.security.payload.JWTAuthResponse;
import com.example.gym_management.security.payload.LoginDto;
import com.example.gym_management.security.payload.UpdateRoleUserDTO;
import com.example.gym_management.security.repository.UserRepository;
import com.example.gym_management.security.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired UserRepository userRepository;
    @Autowired AuthService authService;

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> userInfo(@PathVariable Long id){
        User user = userRepository.findById(id).get();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return new ResponseEntity<>("User deleted!", HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UpdateRoleUserDTO updateRoleUserDTO){
        return new ResponseEntity<>(authService.updateRoleUser(id, updateRoleUserDTO), HttpStatus.OK);
    }
}
