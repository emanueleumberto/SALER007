package com.example.GestionPizzeria.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Drink extends Prodotto {

    private Integer gradi;

    public Drink(String nome, Integer gradi, Double prezzo) {
        super(nome, prezzo);
        this.gradi = gradi;
    }
}
