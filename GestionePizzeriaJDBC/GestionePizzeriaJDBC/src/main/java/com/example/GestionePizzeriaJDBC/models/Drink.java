package com.example.GestionePizzeriaJDBC.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Drink extends Prodotto {

    private Integer gradi;

    public Drink(String nome, Integer gradi, Double prezzo, Menu menu) {
        super(nome, prezzo, menu);
        this.gradi = gradi;
    }

    @Override
    public String toString() {
        return getId() + " - Drink: " + getNome() +
                " gradi: " + getGradi() +
                "° prezzo: €" + getPrezzo() +
                " menu: " + getMenu().getNome();
    }

}
