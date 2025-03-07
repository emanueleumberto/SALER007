package com.example.GestionePizzeriaJPA.runners;

import com.example.GestionePizzeriaJPA.models.Cliente;
import com.example.GestionePizzeriaJPA.models.Drink;
import com.example.GestionePizzeriaJPA.models.Ordine;
import com.example.GestionePizzeriaJPA.models.Pizza;
import com.example.GestionePizzeriaJPA.servicecs.ClienteService;
import com.example.GestionePizzeriaJPA.servicecs.MenuService;
import com.example.GestionePizzeriaJPA.servicecs.OrdineService;
import com.example.GestionePizzeriaJPA.servicecs.ProdottiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdineRunner implements CommandLineRunner {

    @Autowired ClienteService clienteService;
    @Autowired ProdottiService prodottiService;
    @Autowired OrdineService ordineService;

    @Override
    public void run(String... args) throws Exception {

        //Cliente mario = clienteService.creaCliente("Mario Rossi", "+39 123.456.789");
        //clienteService.salvaCliente(mario);

        //Cliente mario = clienteService.leggiCliente(1);
        //System.out.println(mario);

        //Pizza margherita = (Pizza) prodottiService.leggiProdotto(1);
        //Drink cocaCola = (Drink) prodottiService.leggiProdotto(2);

        //Ordine ordine = ordineService.creaOrdine(mario, List.of(margherita, cocaCola));
        //System.out.println(ordine);

        //ordineService.salvaOrdine(ordine);

        Ordine ordine = ordineService.leggiOrdine(1);
        System.out.println(ordine);
    }
}
