package com.example.GestionePizzeriaJDBC.configurations;

import com.example.GestionePizzeriaJDBC.models.Drink;
import com.example.GestionePizzeriaJDBC.models.Menu;
import com.example.GestionePizzeriaJDBC.models.Pizza;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MenuConfiguration {

    @Bean("creaMenu")
    @Scope("prototype")
    public Menu creaMenu() {
        return new Menu();
    }

    @Bean("creaPizza")
    @Scope("prototype")
    public Pizza creaPizza() {
        return new Pizza();
    }

    @Bean("creaDrink")
    @Scope("prototype")
    public Drink creaDrink() {
        return new Drink();
    }

}
