package com.example.GestionePizzeriaJPA.repositories;

import com.example.GestionePizzeriaJPA.models.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdottiDAORepository extends JpaRepository<Prodotto, Long> {
}
