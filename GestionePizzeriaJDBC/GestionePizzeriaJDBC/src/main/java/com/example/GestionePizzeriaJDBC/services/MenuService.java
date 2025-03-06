package com.example.GestionePizzeriaJDBC.services;

import com.example.GestionePizzeriaJDBC.models.Drink;
import com.example.GestionePizzeriaJDBC.models.Menu;
import com.example.GestionePizzeriaJDBC.models.Pizza;
import com.example.GestionePizzeriaJDBC.models.Prodotto;
import com.example.GestionePizzeriaJDBC.repositories.MenuDAO;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {

    @Autowired MenuDAO db;
    @Autowired @Qualifier("creaMenu") ObjectProvider<Menu> menuObjectProvider;
    @Autowired @Qualifier("creaPizza") ObjectProvider<Pizza> pizzaObjectProvider;
    @Autowired @Qualifier("creaDrink") ObjectProvider<Drink> drinkObjectProvider;

    public Menu creaMenu(String nome) {
        Menu menu = menuObjectProvider.getObject();
        menu.setNome(nome);
        return menu;
    }

    public Pizza creaPizza(String nome, List<String> ingredienti, Double prezzo, Menu menu) {
        Pizza pizza = pizzaObjectProvider.getObject();
        pizza.setNome(nome);
        pizza.setIngredienti(ingredienti);
        pizza.setPrezzo(prezzo);
        pizza.setMenu(menu);
        return pizza;
    }

    public Drink creaDrink(String nome, Integer gradi, Double prezzo, Menu menu) {
        Drink drink = drinkObjectProvider.getObject();
        drink.setNome(nome);
        drink.setGradi(gradi);
        drink.setPrezzo(prezzo);
        drink.setMenu(menu);
        return drink;
    }

    // DB Method

    public void salvaMenu(Menu menu) {
        db.salvaMenu(menu);
    }

    public Menu leggiMenu(long id) {
        Menu menu = db.leggiMenu(id);
        List<Prodotto> listaProdotti = leggiProdottiDelMenu(id);
        menu.setListaPizze(listaProdotti.stream()
                                .filter(p -> p instanceof Pizza)
                                .map(p -> (Pizza) p)
                                .collect(Collectors.toList()));
        menu.setListaDrink(listaProdotti.stream()
                                .filter(p -> p instanceof Drink)
                                .map(p->(Drink)p)
                                .collect(Collectors.toList()));
        return menu;
    }

    public void salvaProdotto(Prodotto prodotto) {
        db.salvaProdotto(prodotto);
    }

    public Prodotto leggiProdotto(long id) {
        return db.leggiProdotto(id);
    }

    public List<Prodotto> leggiProdottiDelMenu(long id) {
        return db.leggiTuttiProdottiMenu(id);
    }

    public void stampaMenu(long id) {
        Menu menu = leggiMenu(id);
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
