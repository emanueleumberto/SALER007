package com.example.GestionPizzeria.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Menu {

    private String nome;
    private List<Pizza> listaPizze;
    private List<Drink> listaDrink;

    public Menu() {
        this.listaPizze = new ArrayList<Pizza>();
        this.listaDrink = new ArrayList<Drink>();
    }

}
