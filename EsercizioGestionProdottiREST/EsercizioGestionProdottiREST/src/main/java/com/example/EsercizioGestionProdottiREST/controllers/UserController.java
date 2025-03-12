package com.example.EsercizioGestionProdottiREST.controllers;

import com.example.EsercizioGestionProdottiREST.models.Product;
import com.example.EsercizioGestionProdottiREST.models.User;
import com.example.EsercizioGestionProdottiREST.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired UserService userService;

    // GET /users → Restituisce tutti gli utenti.
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
    // GET /users/{id} → Restituisce un utente.
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    // POST /users → Registra un nuovo utente.
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

}
