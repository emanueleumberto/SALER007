package com.example.GestionePizzeriaJPA.servicecs;

import com.example.GestionePizzeriaJPA.models.Drink;
import com.example.GestionePizzeriaJPA.models.Menu;
import com.example.GestionePizzeriaJPA.models.Pizza;
import com.example.GestionePizzeriaJPA.models.Prodotto;
import com.example.GestionePizzeriaJPA.repositories.ProdottiDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottiService {

    @Autowired ProdottiDAORepository db;
    @Autowired @Qualifier("creaPizza") ObjectProvider<Pizza> pizzaObjectProvider;
    @Autowired @Qualifier("creaDrink") ObjectProvider<Drink> drinkObjectProvider;

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

    public void salvaProdotto(Prodotto prodotto) {
        db.save(prodotto);
    }

    public Prodotto leggiProdotto(long id) {
        return db.findById(id).get();
    }

}
