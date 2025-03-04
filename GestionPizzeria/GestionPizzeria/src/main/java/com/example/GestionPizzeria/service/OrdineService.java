package com.example.GestionPizzeria.service;

import com.example.GestionPizzeria.model.*;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdineService {

    private List<Ordine> listaOrdini = new ArrayList<Ordine>();
    private static int numOrdine = 1;
    @Autowired @Qualifier("creaOrdine") ObjectProvider<Ordine> ordineObjectProvider;
    @Autowired @Qualifier("creaFakeCliente") ObjectProvider<Cliente> clienteFakeObjectProvider;

    public void creaOrdine(Cliente cliente, List<Prodotto> listaProdotti) {
        Ordine ordine = ordineObjectProvider.getObject();
        ordine.setNumeroOrdine(numOrdine++);
        ordine.setCliente(cliente);
        ordine.setListaProdotti(listaProdotti);
        ordine.setDataOrdine(LocalDate.now());
        listaOrdini.add(ordine);
    }

    public void stampaOrdini() {
        listaOrdini.forEach(o -> {
            System.out.println("Ordine n." + o.getNumeroOrdine());
            System.out.println("Pizze Ordinate: ");
            o.getListaProdotti().forEach(p -> {
                if(p instanceof Pizza) {
                    System.out.println(p.getNome() + " - " + ((Pizza) p).getIngredienti() + " €" + p.getPrezzo());

                }
            });
            System.out.println("Drink ordinati: ");
            o.getListaProdotti().forEach(p -> {
                if(p instanceof Drink) {
                    System.out.println(p.getNome() + " - " + ((Drink) p).getGradi() + "° €" + p.getPrezzo());
                }
            });
            System.out.println("Totale ordine: " + o.getListaProdotti().stream().mapToDouble(Prodotto::getPrezzo).sum());
        });

    }

    public Cliente getFakeCliente() {
        return clienteFakeObjectProvider.getObject();
    }

}
