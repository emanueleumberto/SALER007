package com.example.SpringWebMVCEsercizio.repositories;

import com.example.SpringWebMVCEsercizio.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
}
