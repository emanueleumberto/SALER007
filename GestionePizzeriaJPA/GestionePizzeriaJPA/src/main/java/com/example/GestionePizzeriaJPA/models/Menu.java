package com.example.GestionePizzeriaJPA.models;

import jakarta.persistence.*;
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
@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "menu", fetch = FetchType.EAGER)
    private List<Prodotto> listaProdotti;

    public Menu() {
        this.listaProdotti = new ArrayList<Prodotto>();
    }

}
