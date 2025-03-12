package com.example.EsercizioGestionProdottiREST.repositories;

import com.example.EsercizioGestionProdottiREST.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
