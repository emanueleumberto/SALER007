package com.example.GestionePizzeriaJPA.repositories;

import com.example.GestionePizzeriaJPA.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDAORepository extends JpaRepository<Cliente, Long> {
}
