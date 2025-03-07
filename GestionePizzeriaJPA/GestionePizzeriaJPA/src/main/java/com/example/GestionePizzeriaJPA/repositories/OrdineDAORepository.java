package com.example.GestionePizzeriaJPA.repositories;

import com.example.GestionePizzeriaJPA.models.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdineDAORepository extends JpaRepository<Ordine, Long> {
}
