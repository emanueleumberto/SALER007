package com.example.GestionePizzeriaJDBC.runners;

import com.example.GestionePizzeriaJDBC.models.Cliente;
import com.example.GestionePizzeriaJDBC.models.Drink;
import com.example.GestionePizzeriaJDBC.models.Ordine;
import com.example.GestionePizzeriaJDBC.models.Pizza;
import com.example.GestionePizzeriaJDBC.services.MenuService;
import com.example.GestionePizzeriaJDBC.services.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(2)
public class OrdineRunner implements CommandLineRunner {

    @Autowired OrdineService ordineService;
    @Autowired MenuService menuService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("OrdineRunner....");

        //Cliente cliente = ordineService.creaCliente("Mario Rossi", "+39 123.456.789");
        //ordineService.salvaCliente(cliente);

        //Cliente mario = ordineService.leggiCliente(1);
        //Pizza margherita = (Pizza) menuService.leggiProdotto(1);
        //Drink cocaCola = (Drink) menuService.leggiProdotto(4);

        //Ordine ordine = ordineService.creaOrdine(mario, List.of(margherita, cocaCola));
        //ordineService.salvaOrdine(ordine);

        Ordine ordine = ordineService.leggiOrdine(1);
        System.out.println(ordine);
    }
}
