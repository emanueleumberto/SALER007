package com.example.SpringWebRest.controllers;

import com.example.SpringWebRest.models.User;
import com.example.SpringWebRest.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired UserService userService;

    @GetMapping
    public List<User> getUsers() {
        List<User> users = userService.findAll();
        return users;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        //User user = userService.findById(id);
        //return user;
        try {
            return new ResponseEntity<User>(userService.findById(id), HttpStatus.OK);
        } catch (EntityNotFoundException | NoSuchElementException e ) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/{id}/update")
    public User updatePutUser(@PathVariable Long id, @RequestBody User user) {
        if(id == user.getId()) {
            return userService.update(user);
        }
        return null;
    }

    @PatchMapping("/{id}/update")
    public ResponseEntity<?> updatePatchUser(@PathVariable Long id,
                                @RequestBody Map<String, Object> updates) {
        User user;

        try {
            user = userService.findById(id);
        } catch (EntityNotFoundException | NoSuchElementException e ) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(User.class, key);
            if(field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, user, value);
            }
        });

        return new ResponseEntity<User>(userService.update(user), HttpStatus.OK);

    }

    @DeleteMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "User deleted!";
    }

}
