package com.example.GestionPizzeria.runner;

import com.example.GestionPizzeria.model.Cliente;
import com.example.GestionPizzeria.model.Pizza;
import com.example.GestionPizzeria.service.MenuService;
import com.example.GestionPizzeria.service.OrdineService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PizzeriaRunner implements CommandLineRunner {

    @Autowired MenuService menuService; // new MenuService();
    @Autowired OrdineService ordineService;

    //@Autowired @Qualifier("creaFakeCliente") ObjectProvider<Cliente> clienteFakeObjectProvider;
    //@Autowired @Qualifier("creaPizzaMargherita") ObjectProvider<Pizza> pizzaMargheritaObjectProvider;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("PizzeriaRunner....");

        menuService.stampaMenu();

        System.out.println("---------------------------------------");

        ordineService.creaOrdine(
                ordineService.getFakeCliente(),
                List.of(
                    menuService.getPizzaMargerita(), menuService.getPizzaBoscaiola(), menuService.getDrinkAcqua(), menuService.getDrinkCocaCola()
                ));

        ordineService.creaOrdine(
                ordineService.getFakeCliente(),
                List.of(
                        menuService.getPizzaDiavola(), menuService.getPizzaMargerita(), menuService.getDrinkBeer(), menuService.getDrinkCocaCola()
                )
        );

        ordineService.stampaOrdini();
    }
}
