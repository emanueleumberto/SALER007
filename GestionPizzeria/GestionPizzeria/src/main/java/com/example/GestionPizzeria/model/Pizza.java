package com.example.GestionPizzeria.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Pizza extends Prodotto {

    List<String> ingredienti;

    public Pizza(String nome, List<String> ingredienti, Double prezzo) {
        super(nome, prezzo);
        this.ingredienti = ingredienti;
    }


    public Pizza(String nome, Double prezzo) {
        super(nome, prezzo);
        this.ingredienti = new ArrayList<String>();
    }

}
