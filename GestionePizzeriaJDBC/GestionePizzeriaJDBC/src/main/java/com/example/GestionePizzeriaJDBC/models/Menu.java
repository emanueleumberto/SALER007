package com.example.GestionePizzeriaJDBC.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Menu {

    private Long id;
    private String nome;
    private List<Pizza> listaPizze;
    private List<Drink> listaDrink;

    public Menu() {
        this.listaPizze = new ArrayList<Pizza>();
        this.listaDrink = new ArrayList<Drink>();
    }

}
