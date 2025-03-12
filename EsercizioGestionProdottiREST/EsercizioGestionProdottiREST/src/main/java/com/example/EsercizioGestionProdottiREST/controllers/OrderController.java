package com.example.EsercizioGestionProdottiREST.controllers;

import com.example.EsercizioGestionProdottiREST.enumerations.StatusOrder;
import com.example.EsercizioGestionProdottiREST.models.Order;
import com.example.EsercizioGestionProdottiREST.models.User;
import com.example.EsercizioGestionProdottiREST.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired OrderService orderService;

    // POST /orders → Crea un ordine per un utente.
    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.saveOrder(order));
    }
    // GET /orders/{id} → Ottiene i dettagli di un ordine.
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
    // PUT /orders/{id}/cancel → Annulla un ordine.
    @PutMapping("/{id}/cancel")
    public ResponseEntity<Order> cancelOrder(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        order.setStatus(StatusOrder.CANCELLED);
        return ResponseEntity.ok(orderService.cancelOrder(order));
    }
    // GET /orders/user/{userId} → Restituisce gli ordini di un utente.
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Order>> getOrderByUserID(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getAllUserOrders(id));
    }
}
