package com.example.GestionPizzeria.service;

import com.example.GestionPizzeria.model.Drink;
import com.example.GestionPizzeria.model.Menu;
import com.example.GestionPizzeria.model.Pizza;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired @Qualifier("creaMenu") ObjectProvider<Menu> menuObjectProvider;
    @Autowired @Qualifier("creaPizzaMargherita") ObjectProvider<Pizza> pizzaMargheritaObjectProvider;
    @Autowired @Qualifier("creaPizzaBoscaiola") ObjectProvider<Pizza> pizzaBoscaiolaObjectProvider;
    @Autowired @Qualifier("creaPizzaDiavola") ObjectProvider<Pizza> pizzaDiavolaObjectProvider;
    @Autowired @Qualifier("creaPizza") ObjectProvider<Pizza> pizzaObjectProvider;
    @Autowired @Qualifier("creaDrinkCocaCola") ObjectProvider<Drink> drinkCocaColaObjectProvider;
    @Autowired @Qualifier("creaDrinkBirra") ObjectProvider<Drink> drinkBirraObjectProvider;
    @Autowired @Qualifier("creaDrinkAcqua") ObjectProvider<Drink> drinkAcquaObjectProvider;
    @Autowired @Qualifier("creaDrink") ObjectProvider<Drink> drinkObjectProvider;

    public Pizza creaPizza(String nome, List<String> ingredienti, Double prezzo) {
        Pizza pizza = pizzaObjectProvider.getObject();
        pizza.setNome(nome);
        pizza.setIngredienti(ingredienti);
        pizza.setPrezzo(prezzo);
        return pizza;
    }

    public Drink creaDrink(String nome, Integer gradi, Double prezzo) {
        Drink drink = drinkObjectProvider.getObject();
        drink.setNome(nome);
        drink.setGradi(gradi);
        drink.setPrezzo(prezzo);
        return drink;
    }

    public Pizza getPizzaMargerita() {
        return pizzaMargheritaObjectProvider.getObject();
    }

    public Pizza getPizzaBoscaiola() {
        return pizzaBoscaiolaObjectProvider.getObject();
    }

    public Pizza getPizzaDiavola() {
        return pizzaDiavolaObjectProvider.getObject();
    }

    public Drink getDrinkCocaCola() {
        return drinkCocaColaObjectProvider.getObject();
    }

    public Drink getDrinkBeer() {
        return drinkBirraObjectProvider.getObject();
    }

    public Drink getDrinkAcqua() {
        return drinkAcquaObjectProvider.getObject();
    }

    public Menu creaMenu() {
        Menu menu = menuObjectProvider.getObject();
        menu.setNome("Da Peppe");
        menu.getListaPizze().add(getPizzaMargerita());
        menu.getListaPizze().add(getPizzaBoscaiola());
        menu.getListaPizze().add(getPizzaDiavola());
        menu.getListaPizze().add(creaPizza("Pizza Olive", List.of("Pomodoro", "Mozzarella", "Olive", "Capperi"), 4.0));
        menu.getListaPizze().add(creaPizza("Pizza Ananas", List.of("Mozzarella", "Aglio", "Ananas"), 10.0));
        menu.getListaDrink().add(getDrinkAcqua());
        menu.getListaDrink().add(getDrinkCocaCola());
        menu.getListaDrink().add(getDrinkBeer());
        menu.getListaDrink().add(creaDrink("Spritz", 10, 5.0));
        menu.getListaDrink().add(creaDrink("Succo", 0, 2.0));
        return menu;
    }

    public void stampaMenu() {
        Menu menu = creaMenu();
        System.out.println("************* Menu Pizzeria " + menu.getNome() +" **************");
        System.out.println("----- Pizze -----");
        menu.getListaPizze().forEach(p -> {
            System.out.println(
                    (menu.getListaPizze().indexOf(p) + 1) + ". "
                            + p.getNome() + " "
                            + p.getIngredienti().toString()
                            + "  Prezzo: €" + p.getPrezzo());
        });
        System.out.println("----- Drink -----");
        menu.getListaDrink().forEach(d -> {
            System.out.println(
                    (menu.getListaDrink().indexOf(d) + 1) + ". "
                            + d.getNome() + " "
                            + d.getGradi() + "° Prezzo: €"
                            + d.getPrezzo()
            );
        });
    }



}
