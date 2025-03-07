package com.example.GestionePizzeriaJPA.runners;

import com.example.GestionePizzeriaJPA.models.Drink;
import com.example.GestionePizzeriaJPA.models.Menu;
import com.example.GestionePizzeriaJPA.models.Pizza;
import com.example.GestionePizzeriaJPA.servicecs.MenuService;
import com.example.GestionePizzeriaJPA.servicecs.ProdottiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuRunner implements CommandLineRunner {

    @Autowired MenuService menuService;
    @Autowired ProdottiService prodottiService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("MenuRunner...");

        //Menu menuProdotti = menuService.creaMenu("Saler 007");
        //menuService.salvaMenu(menuProdotti);
        //Menu menuProdotti = menuService.leggiMenu(1);
        //System.out.println(menuProdotti);


        //Pizza margherita = prodottiService.creaPizza("Pizza Margherita", List.of("Pomodoro", "Mozzarella"), 6.00, menuProdotti);
        //prodottiService.salvaProdotto(margherita);
        //Pizza boscaiola = prodottiService.creaPizza("Pizza Boscaiola", List.of("Mozzarella", "Funghi", "Salsiccia"), 8.00, menuProdotti);
        //prodottiService.salvaProdotto(boscaiola);
        //Pizza diavola = prodottiService.creaPizza("Pizza Diavola", List.of("Pomodoro", "Mozzarella", "Salame piccante"), 7.50, menuProdotti);
        //prodottiService.salvaProdotto(diavola);

        //Drink cocaCola = prodottiService.creaDrink("Coca Cola", 0 , 2.50, menuProdotti);
        //prodottiService.salvaProdotto(cocaCola);
        //Drink acqua = prodottiService.creaDrink("Acqua", 0 , 1.50, menuProdotti);
        //prodottiService.salvaProdotto(acqua);
        //Drink birra = prodottiService.creaDrink("Birra", 6 , 3.50, menuProdotti);
        //prodottiService.salvaProdotto(birra);

        //System.out.println(margherita);
        //System.out.println(cocaCola);

        menuService.stampaMenu(1);
    }
}
