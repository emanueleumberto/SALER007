package org.example.Esercizi.EsercizioFinale;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

public class Officina {

    private String nomeOfficina;
    private Map<String, Veicolo> veicoli;

    public Officina(String nomeOfficina) {
        this.nomeOfficina = nomeOfficina;
        this.veicoli = new HashMap<String, Veicolo>();
    }

    public String getNomeOfficina() {
        return nomeOfficina;
    }

    public Map<String, Veicolo> getVeicoli() {
        return veicoli;
    }

    public void aggiungiVeicolo(Veicolo veicolo) {
        if(veicolo != null) {
            this.veicoli.put(veicolo.getTarga(), veicolo);
        }
    }

    public void rimuoviVeicolo(String targa) {
        if(this.veicoli.remove(targa) == null) {
            throw new NoSuchElementException("Veicolo non trovato");
        }
    }

    public Optional<Veicolo> cercaVeicolo(String targa) {
        return Optional.ofNullable(this.veicoli.get(targa));
    }

    public void visualizzaVeicoli() {
        //this.veicoli.forEach((targa, veicolo) -> System.out.println(targa + " -> " + veicolo));
        this.veicoli.values().forEach(System.out::println);
    }
    public List<Veicolo> filtraVeicoliPerMarca(String marca) {
        return this.veicoli
                .values()
                .stream()
                .filter(v -> v.getMarca().equalsIgnoreCase(marca))
                .collect(Collectors.toList());

    }

}
