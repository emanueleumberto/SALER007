package com.example.GestionePizzeriaJDBC.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ordine {

    private Integer numeroOrdine;
    private Cliente cliente;
    private List<Prodotto> listaProdotti;
    private LocalDate dataOrdine;
    private Double totale;

}
