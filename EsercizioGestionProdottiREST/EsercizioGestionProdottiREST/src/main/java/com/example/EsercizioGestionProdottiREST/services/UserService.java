package com.example.EsercizioGestionProdottiREST.services;

import com.example.EsercizioGestionProdottiREST.models.User;
import com.example.EsercizioGestionProdottiREST.repositories.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired UserRepository userRepository;

    public List<User> getAllUsers() {
        //  restituisce tutti gli utenti.
        return userRepository.findAll();
    };

    public User getUserById(Long id) {
        // restituisce un User tramite ID.
        if(!userRepository.existsById(id)) {
            throw new EntityExistsException("User_ID not exists!!!");
        }
        return userRepository.findById(id).get();
    }

    public User saveUser(User user) {
        // salva un nuovo prodotto.
        if(userRepository.existsByUsername(user.getUsername())) {
            throw new EntityExistsException("Username exists!!!");
        } else if(userRepository.existsByEmail(user.getEmail())) {
            throw new EntityExistsException("Email exists!!!");
        } else {
            return userRepository.save(user);
        }
    }

}
