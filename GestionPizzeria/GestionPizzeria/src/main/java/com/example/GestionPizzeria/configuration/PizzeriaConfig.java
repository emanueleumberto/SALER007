package com.example.GestionPizzeria.configuration;

import com.example.GestionPizzeria.model.*;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;
import java.util.Locale;

@Configuration
public class PizzeriaConfig {

    // Menu
    @Bean
    @Scope("singleton")
    public Menu creaMenu() {
//        Menu menu = new Menu("Da peppe");
//        menu.getListaPizze().add(creaPizzaMargherita());
//        menu.getListaPizze().add(creaPizzaBoscaiola());
//        menu.getListaPizze().add(creaPizzaDiavola());
//        menu.getListaPizze().add(creaPizza("Pizza Olive", List.of("Pomodoro", "Mozzarella", "Olive", "Capperi"), 4.0));
//        menu.getListaPizze().add(creaPizza("Pizza Ananas", List.of("Mozzarella", "Aglio", "Ananas"), 10.0));
//        menu.getListaDrink().add(creaDrinkAcqua());
//        menu.getListaDrink().add(creaDrinkCocaCola());
//        menu.getListaDrink().add(creaDrinkBirra());
//        menu.getListaDrink().add(creaDrink("Spritz", 10, 5.0));
//        menu.getListaDrink().add(creaDrink("Succo", 0, 2.0));
        Menu menu = new Menu();
        return menu;
    }


    // Pizze

//    @Bean
//    @Scope("prototype")
//    public Pizza creaPizza(String nome, List<String> ingredienti, Double prezzo) {
//        return new Pizza(nome, ingredienti, prezzo);
//    }

    @Bean
    @Scope("prototype")
    public Pizza creaPizza() {
        return new Pizza();
    }

    @Bean
    @Scope("singleton")
    public Pizza creaPizzaMargherita() {
        return new Pizza("Pizza Margherita", List.of("Pomodoro", "Mozzarella"), 6.00);

    }

    @Bean
    @Scope("singleton")
    public Pizza creaPizzaBoscaiola() {
        return new Pizza("Pizza Boscaiola", List.of("Mozzarella", "Funghi", "Salsiccia"), 8.00);

    }

    @Bean
    @Scope("singleton")
    public Pizza creaPizzaDiavola() {
        return new Pizza("Pizza Diavola", List.of("Pomodoro", "Mozzarella", "Salame piccante"), 7.50);

    }

    // Drink

    @Bean
    @Scope("singleton")
    public Drink creaDrinkCocaCola() {
        return new Drink("Coca Cola", 0 , 2.50);
    }

    @Bean
    @Scope("singleton")
    public Drink creaDrinkBirra() {
        return new Drink("Birra", 6 , 3.50);
    }

    @Bean
    @Scope("singleton")
    public Drink creaDrinkAcqua() {
        return new Drink("Acqua", 0 , 1.50);
    }

//    @Bean
//    @Scope("prototype")
//    public Drink creaDrink(String nome, Integer gradi, Double prezzo) {
//        return new Drink(nome, gradi, prezzo);
//    }

    @Bean
    @Scope("prototype")
    public Drink creaDrink() {
        return new Drink();
    }

    @Bean
    @Scope("prototype")
    public Cliente creaCliente() {
        return new Cliente();
    }

    @Bean
    @Scope("prototype")
    public Cliente creaFakeCliente() {
        Faker fake = new Faker(new Locale("it-IT"));
        return new Cliente(fake.name().fullName(), fake.phoneNumber().cellPhone());
    }

    @Bean
    @Scope("prototype")
    public Ordine creaOrdine() {
        return new Ordine();
    }

}
