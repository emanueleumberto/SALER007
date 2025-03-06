package com.example.GestionePizzeriaJDBC.runners;

import com.example.GestionePizzeriaJDBC.models.Drink;
import com.example.GestionePizzeriaJDBC.models.Menu;
import com.example.GestionePizzeriaJDBC.models.Pizza;
import com.example.GestionePizzeriaJDBC.models.Prodotto;
import com.example.GestionePizzeriaJDBC.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Order(1)
public class MenuRunner implements CommandLineRunner {

    @Autowired MenuService menuService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("MenuRunner....");

        //Menu menuProdotti = menuService.creaMenu("Da Peppe");
        //menuService.salvaMenu(menuProdotti);

        //Menu menuProdotti = menuService.leggiMenu(1);
        //System.out.println(menuProdotti);

        //Pizza margherita = menuService.creaPizza("Pizza Margherita", List.of("Pomodoro", "Mozzarella"), 6.00, menuProdotti);
        //menuService.salvaProdotto(margherita);
        //Pizza boscaiola = menuService.creaPizza("Pizza Boscaiola", List.of("Mozzarella", "Funghi", "Salsiccia"), 8.00, menuProdotti);
        //menuService.salvaProdotto(boscaiola);
        //Pizza diavola = menuService.creaPizza("Pizza Diavola", List.of("Pomodoro", "Mozzarella", "Salame piccante"), 7.50, menuProdotti);
        //menuService.salvaProdotto(diavola);

        //Drink cocaCola = menuService.creaDrink("Coca Cola", 0 , 2.50, menuProdotti);
        //menuService.salvaProdotto(cocaCola);
        //Drink acqua = menuService.creaDrink("Acqua", 0 , 1.50, menuProdotti);
        //menuService.salvaProdotto(acqua);
        //Drink birra = menuService.creaDrink("Birra", 6 , 3.50, menuProdotti);
        //menuService.salvaProdotto(birra);

        //Pizza margherita = (Pizza) menuService.leggiProdotto(1);
        //System.out.println(margherita);
        //Drink cocaCola = (Drink) menuService.leggiProdotto(2);
        //System.out.println(cocaCola);

        //menuService.stampaMenu(1);

    }
}
