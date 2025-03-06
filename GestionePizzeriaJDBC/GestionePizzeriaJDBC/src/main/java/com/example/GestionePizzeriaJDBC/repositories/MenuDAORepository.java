package com.example.GestionePizzeriaJDBC.repositories;

import com.example.GestionePizzeriaJDBC.models.Menu;
import com.example.GestionePizzeriaJDBC.models.Prodotto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDAORepository {

    // CRUD MENU
    public void salvaMenu(Menu menu);
    public Menu leggiMenu(Long id);
    public void modificaMenu(Menu menu);
    public void eliminaMenu(Menu menu);

    // CRUD PRODOTTI
    public void salvaProdotto(Prodotto prodotto);
    public Prodotto leggiProdotto(Long id);
    public void modificaProdotto(Prodotto prodotto);
    public void eliminaProdotto(Prodotto prodotto);

    public List<Prodotto> leggiTuttiProdottiMenu(Long id_menu);
}
