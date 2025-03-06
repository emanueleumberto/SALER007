package com.example.GestionePizzeriaJDBC.services;

import com.example.GestionePizzeriaJDBC.models.Cliente;
import com.example.GestionePizzeriaJDBC.models.Ordine;
import com.example.GestionePizzeriaJDBC.models.Prodotto;
import com.example.GestionePizzeriaJDBC.repositories.OrdineDAO;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrdineService {

    @Autowired OrdineDAO db;
    @Autowired @Qualifier("creaCliente") ObjectProvider<Cliente> clienteObjectProvider;
    @Autowired @Qualifier("creaOrdine") ObjectProvider<Ordine> ordineObjectProvider;

    public Cliente creaCliente(String nome, String telefono) {
        Cliente cliente = clienteObjectProvider.getObject();
        cliente.setNome(nome);
        cliente.setTelefono(telefono);
        return cliente;
    }

    public Ordine creaOrdine(Cliente cliente, List<Prodotto> listaProdotti) {
        Ordine ordine = new Ordine();
        ordine.setCliente(cliente);
        ordine.setListaProdotti(listaProdotti);
        ordine.setDataOrdine(LocalDate.now());
        ordine.setTotale(listaProdotti.stream().mapToDouble(Prodotto::getPrezzo).sum());
        return ordine;
    }

    // DB Method

    public void salvaCliente(Cliente cliente) {
        db.salvaCliente(cliente);
    }

    public void salvaOrdine(Ordine ordine) {
        db.salvaOrdine(ordine);
    }

    public Cliente leggiCliente(long id) {
        return db.leggiCliente(id);
    }

    public Ordine leggiOrdine(long numeroOrdine) {
        Ordine ordine = db.leggiOrdine(numeroOrdine);
        ordine.setListaProdotti(db.leggiProdottiOrdine(numeroOrdine));
        return ordine;
    }


}
