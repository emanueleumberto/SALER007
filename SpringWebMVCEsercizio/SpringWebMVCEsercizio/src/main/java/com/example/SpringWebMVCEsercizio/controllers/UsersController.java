package com.example.SpringWebMVCEsercizio.controllers;

import com.example.SpringWebMVCEsercizio.models.User;
import com.example.SpringWebMVCEsercizio.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/esercizio")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("/users")
    public String getUsersPage(Model model) {
        List<User> users = usersService.findAllUsers();
        model.addAttribute("lista", users);
        return "users";
    }

    @GetMapping("/registered")
    public String getRegisteredPage() {
        return "registered";
    }

    @PostMapping("/registered")
    public String registerUser(Model model,
                                    @RequestParam String firstname,
                                    @RequestParam String lastname,
                                    @RequestParam String email,
                                    @RequestParam String password) {
        //return firstname + " " + lastname + " email:" + email + " (" + password + ")";
        // Creo un oggetto di tipo User con i dati letti dal form html
        User user = usersService.createUser(firstname, lastname, email, password);
        usersService.saveUser(user); // Salvo l'oggetto User nel DB

        List<User> users = usersService.findAllUsers(); // Leggo tutti gli User dal DB
        model.addAttribute("lista", users); // li passo al template
        return "users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(Model model, @PathVariable long id) {
        usersService.removeUser(id);
        List<User> users = usersService.findAllUsers(); // Leggo tutti gli User dal DB
        model.addAttribute("lista", users); // li passo al template
        return "users";
    }


}
