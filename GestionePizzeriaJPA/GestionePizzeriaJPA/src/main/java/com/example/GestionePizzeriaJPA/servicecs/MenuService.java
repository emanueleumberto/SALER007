package com.example.GestionePizzeriaJPA.servicecs;

import com.example.GestionePizzeriaJPA.models.Drink;
import com.example.GestionePizzeriaJPA.models.Menu;
import com.example.GestionePizzeriaJPA.models.Pizza;
import com.example.GestionePizzeriaJPA.repositories.MenuDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired MenuDAORepository db;
    @Autowired @Qualifier("creaMenu") ObjectProvider<Menu> menuObjectProvider;

    public Menu creaMenu(String nome) {
        Menu menu = menuObjectProvider.getObject();
        menu.setNome(nome);
        return menu;
    }

    public void stampaMenu(long id) {
        Menu menu = leggiMenu(id);
        System.out.println("************* Menu Pizzeria " + menu.getNome() +" **************");
        System.out.println("----- Pizze -----");
        menu.getListaProdotti().forEach(p -> {
            if(p instanceof Pizza) {
                Pizza pizza = (Pizza) p;
                System.out.println(
                        (menu.getListaProdotti().indexOf(p) + 1) + ". "
                                + pizza.getNome() + " "
                                + pizza.getIngredienti().toString()
                                + "  Prezzo: €" + pizza.getPrezzo());
            }
        });
        System.out.println("----- Drink -----");
        menu.getListaProdotti().forEach(d -> {
            if(d instanceof Drink) {
                Drink drink = (Drink) d;
                System.out.println(
                        (menu.getListaProdotti().indexOf(d) + 1) + ". "
                                + drink.getNome() + " "
                                + drink.getGradi() + "° Prezzo: €"
                                + drink.getPrezzo()
                );
            }
        });
    }

    public void salvaMenu(Menu menu) {
        db.save(menu);
    }

    public Menu leggiMenu(long id) {
        return db.findById(id).get();
    }

}
