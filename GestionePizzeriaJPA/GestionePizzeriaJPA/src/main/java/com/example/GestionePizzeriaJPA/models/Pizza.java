package com.example.GestionePizzeriaJPA.models;

import com.example.GestionePizzeriaJPA.utitities.StringListConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("pizza")
public class Pizza extends Prodotto {

    @Convert(converter = StringListConverter.class)
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
