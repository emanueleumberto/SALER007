package com.example.EsercizioGestionProdottiREST.repositories;

import com.example.EsercizioGestionProdottiREST.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // exists by email
    public boolean existsByEmail(String email);
    // exists by username
    public boolean existsByUsername(String username);
}
