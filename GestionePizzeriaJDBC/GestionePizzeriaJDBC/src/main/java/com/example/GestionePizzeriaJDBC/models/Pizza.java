package com.example.GestionePizzeriaJDBC.models;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pizza extends Prodotto {

    List<String> ingredienti;

    public Pizza(String nome, List<String> ingredienti, Double prezzo, Menu menu) {
        super(nome, prezzo, menu);
        this.ingredienti = ingredienti;
    }


    public Pizza(String nome, Double prezzo, Menu menu) {
        super(nome, prezzo, menu);
        this.ingredienti = new ArrayList<String>();
    }

    @Override
    public String toString() {
        return getId() + " - Pizza: " + getNome() +
                " ingredienti: " + getIngredienti() +
                " prezzo: €" + getPrezzo() +
                " menu: " + getMenu().getNome();
    }
}
