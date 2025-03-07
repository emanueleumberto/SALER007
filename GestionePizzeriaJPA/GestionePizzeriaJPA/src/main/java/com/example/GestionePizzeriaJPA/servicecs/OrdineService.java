package com.example.GestionePizzeriaJPA.servicecs;

import com.example.GestionePizzeriaJPA.models.Cliente;
import com.example.GestionePizzeriaJPA.models.Ordine;
import com.example.GestionePizzeriaJPA.models.Prodotto;
import com.example.GestionePizzeriaJPA.repositories.OrdineDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrdineService {

    @Autowired OrdineDAORepository db;
    @Autowired @Qualifier("creaOrdine") ObjectProvider<Ordine> ordineObjectProvider;

    public Ordine creaOrdine(Cliente cliente, List<Prodotto> listaProdotti) {
        Ordine ordine = new Ordine();
        ordine.setCliente(cliente);
        ordine.setListaProdotti(listaProdotti);
        ordine.setDataOrdine(LocalDate.now());
        ordine.setTotale(listaProdotti.stream().mapToDouble(Prodotto::getPrezzo).sum());
        return ordine;
    }

    public void salvaOrdine(Ordine ordine) {
        db.save(ordine);
    }

    public Ordine leggiOrdine(long numeroOrdine) {
        return db.findById(numeroOrdine).get();
    }
}
