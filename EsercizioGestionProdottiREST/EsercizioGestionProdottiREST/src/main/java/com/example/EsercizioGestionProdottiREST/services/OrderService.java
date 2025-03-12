package com.example.EsercizioGestionProdottiREST.services;

import com.example.EsercizioGestionProdottiREST.enumerations.StatusOrder;
import com.example.EsercizioGestionProdottiREST.models.Order;
import com.example.EsercizioGestionProdottiREST.models.Product;
import com.example.EsercizioGestionProdottiREST.models.User;
import com.example.EsercizioGestionProdottiREST.repositories.OrderRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        //  restituisce tutti gli ordini.
        return orderRepository.findAll();
    };

    public List<Order> getAllUserOrders(Long user_id) {
        //  restituisce tutti gli ordini di uno specifico User.
        List<Order> orders = orderRepository.findAll();
        List<Order> userOrders = orders
                                    .stream()
                                    .filter(o -> o.getUser().getId() == user_id)
                                    .collect(Collectors.toList());
        return userOrders;
    };

    public Order getOrderById(Long id) {
        // restituisce un Order tramite ID.
        if(!orderRepository.existsById(id)) {
            throw new EntityExistsException("Order_ID not exists!!!");
        }
        return orderRepository.findById(id).get();
    }

    public Order saveOrder(Order order) {
        // salva un nuovo Ordine.
        double total = order.getProducts().stream().mapToDouble(p -> p.getPrice().doubleValue()).sum();
        order.setTotalPrice(BigDecimal.valueOf(total));
        order.setStatus(StatusOrder.PENDING);
        orderRepository.save(order);
        return order;
    }

    public Order cancelOrder(Order order) {
        // cancella un Ordine.
        orderRepository.save(order);
        return order;
    }

}
