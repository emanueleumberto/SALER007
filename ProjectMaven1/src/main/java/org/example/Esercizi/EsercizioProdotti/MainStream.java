package org.example.Esercizi.EsercizioProdotti;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;

public class MainStream {

    private static Faker fake = new Faker(new Locale("it-IT"));
    private static List<Prodotto> listaProdotti = new ArrayList<Prodotto>();

    public static void main(String[] args) {
        caricaProdotti(10);
        System.out.println("***************");
        stampaProdotti50();
        System.out.println("***************");
        prodottiDaCategoria("Tools").forEach(System.out::println);
        System.out.println("***************");
        prezzoMedio();
        System.out.println("***************");
        prodottiPrezzo10();
        System.out.println("***************");
        OrdinaProdottoPrezzo();
        System.out.println("***************");
        raggruppaPerCategoria();
    }

    // Soluzione 1
    public static void caricaProdotti(int numProdotti) {
        //Creare una lista di almeno 10 prodotti con valori diversi utilizzando Java Faker.
        for(int i=0; i<numProdotti; i++) {
            listaProdotti.add(new Prodotto(
                    fake.commerce().productName(),
                    fake.commerce().department(),
                    Double.parseDouble(fake.commerce().price().replace(",", ".")),
                    fake.number().numberBetween(1,5)));
        }
        System.out.println("Lista di " + listaProdotti.size() +  " prodotti creata!");
    }

    // Soluzione 2
    public static void stampaProdotti50() {
        // Filtrare e stampare i prodotti con prezzo superiore a 50€.
        listaProdotti
                .stream().filter(p -> p.getPrezzo() > 50)
                .forEach(System.out::println);
    }

    // Soluzione 3
    public static List<String> prodottiDaCategoria(String categoria) {
        // Estrarre una lista dei nomi dei prodotti appartenenti
        // a una categoria specifica (es. "Elettronica").
        return listaProdotti.stream()
                .filter(p -> p.getCategoria().equals(categoria))
                .map(Prodotto::getNome)
                .collect(Collectors.toList());

    }

    // Soluzione 4
    public static void prezzoMedio() {
        // Calcolare e stampare il prezzo medio di tutti i prodotti.
        double prezzoMedio = listaProdotti.stream()
                .mapToDouble(Prodotto::getPrezzo)
                .average()
                .orElse(0);
        System.out.println("Prezzo medio: " + prezzoMedio);
    }

    // Soluzione 5
    public static void prodottiPrezzo10() {
        // Verificare se almeno un prodotto della lista ha un prezzo inferiore a 10€.
        boolean prezzo10 = listaProdotti.stream().anyMatch(p -> p.getPrezzo() < 10);
        System.out.println("Esiste almeno un prodotto della lista con un prezzo inferiore a 10€? " + prezzo10);
    }

    // Soluzione 6
    public static void OrdinaProdottoPrezzo() {
        // Extra: Ordinare la lista in base al prezzo in modo crescente e stamparla.
        listaProdotti.stream()
                .sorted(Comparator.comparingDouble(Prodotto::getPrezzo))
                .forEach(System.out::println);
    }

    // Soluzione 7
    public static void raggruppaPerCategoria() {
        // Extra: Raggruppare i prodotti per categoria e visualizzarli.
        Map<String, List<Prodotto>> prodPerCat =  listaProdotti.stream()
                        .collect(Collectors.groupingBy(Prodotto::getCategoria));
        prodPerCat.forEach((categoria, listaProdotti) -> {
            System.out.println(categoria + " -> " + listaProdotti);
        } );
    }
}
