package com.example.GestionePizzeriaJPA.models;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("drink")
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
