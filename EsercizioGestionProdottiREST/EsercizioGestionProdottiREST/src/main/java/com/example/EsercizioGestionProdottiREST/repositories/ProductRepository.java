package com.example.EsercizioGestionProdottiREST.repositories;

import com.example.EsercizioGestionProdottiREST.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public boolean existsById(Long id);
}
