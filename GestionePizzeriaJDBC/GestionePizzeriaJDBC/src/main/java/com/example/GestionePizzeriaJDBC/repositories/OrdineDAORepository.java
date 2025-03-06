package com.example.GestionePizzeriaJDBC.repositories;

import com.example.GestionePizzeriaJDBC.models.Cliente;
import com.example.GestionePizzeriaJDBC.models.Ordine;
import com.example.GestionePizzeriaJDBC.models.Prodotto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdineDAORepository {

    // CRUD Cliente
    public void salvaCliente(Cliente cliente);
    public Cliente leggiCliente(Long id);
    public void modificaCliente(Cliente cliente);
    public void eliminaCliente(Cliente cliente);

    public List<Cliente> leggiTuttiClienti();

    // CRUD Ordine
    public void salvaOrdine(Ordine ordine);
    public Ordine leggiOrdine(Long numeroOrdine);
    public void modificaOrdine(Ordine ordine);
    public void eliminaOrdine(Ordine ordine);

    public List<Prodotto> leggiProdottiOrdine(Long numeroOrdine);
    public List<Ordine> leggiTuttiOrdini();

}
