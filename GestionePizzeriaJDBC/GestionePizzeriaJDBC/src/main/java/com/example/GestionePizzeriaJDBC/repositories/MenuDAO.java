package com.example.GestionePizzeriaJDBC.repositories;

import com.example.GestionePizzeriaJDBC.models.Drink;
import com.example.GestionePizzeriaJDBC.models.Menu;
import com.example.GestionePizzeriaJDBC.models.Pizza;
import com.example.GestionePizzeriaJDBC.models.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuDAO implements MenuDAORepository {

    @Autowired JdbcTemplate jdbc;

    @Override
    public void salvaMenu(Menu menu) {
        String sql = "INSERT INTO menu (nome_menu) VALUES (?)";
        jdbc.update(sql, menu.getNome());
        System.out.println("Menu " + menu.getNome() + " salvato nel DB!");
    }

    @Override
    public Menu leggiMenu(Long id) {
        String sql = "SELECT * FROM menu WHERE id_menu = ?";
        return jdbc.queryForObject(sql, new MenuRowMapper(), id);
    }

    @Override
    public void modificaMenu(Menu menu) {
        String sql = "UPDATE menu SET nome_menu = ? WHERE id_menu = ?";
        jdbc.update(sql, menu.getNome(), menu.getId());
        System.out.println("Menu " + menu.getNome() + " modificato nel DB!");
    }

    @Override
    public void eliminaMenu(Menu menu) {
        String sql = "DELETE FROM menu WHERE id_menu = ?";
        jdbc.update(sql, menu.getId());
        System.out.println("Menu " + menu.getNome() + " eliminato dal DB!");
    }

    @Override
    public void salvaProdotto(Prodotto prodotto) {
        String sql = "INSERT INTO prodotti (" +
                "nome_prodotto, prezzo, ingredienti_pizza, " +
                "gradi_drink, menu_id, tipo_prodotto) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        String ingredienti = (prodotto instanceof Pizza) ? ((Pizza) prodotto).getIngredienti().toString() : null;
        Integer gradi = (prodotto instanceof Drink) ? ((Drink) prodotto).getGradi() : null;
        jdbc.update(sql,
                prodotto.getNome(),
                prodotto.getPrezzo(),
                ingredienti,
                gradi,
                prodotto.getMenu().getId(),
                prodotto.getClass().getSimpleName()
        );
        System.out.println(prodotto.getClass().getSimpleName() + " " + prodotto.getNome() + " salvato nel DB!");


        /*if(prodotto instanceof Pizza) {
            Pizza p = (Pizza) prodotto;
            jdbc.update(sql,
                    p.getNome(),
                    p.getPrezzo(),
                    p.getIngredienti().toString(),
                    null,
                    p.getMenu().getId(),
                    prodotto.getClass().getSimpleName()
                    );
            System.out.println("Pizza " + p.getNome() + " salvato nel DB!");
        } else  if(prodotto instanceof Drink) {
            Drink p = (Drink) prodotto;
            jdbc.update(sql,
                    p.getNome(),
                    p.getPrezzo(),
                    null,
                    p.getGradi(),
                    p.getMenu().getId(),
                    prodotto.getClass().getSimpleName()
            );
            System.out.println("Pizza " + p.getNome() + " salvato nel DB!");
        }*/


    }

    @Override
    public Prodotto leggiProdotto(Long id) {
        String sql = "SELECT * FROM prodotti AS p " +
                "INNER JOIN menu AS m ON p.menu_id = m.id_menu " +
                "WHERE id_prodotto = ?";
        return jdbc.queryForObject(sql, new ProdottiRowMapper(), id);
    }

    @Override
    public void modificaProdotto(Prodotto prodotto) {
        String ingredienti = (prodotto instanceof Pizza) ? ((Pizza) prodotto).getIngredienti().toString() : null;
        Integer gradi = (prodotto instanceof Drink) ? ((Drink) prodotto).getGradi() : null;
        String sql = "UPDATE prodotti SET nome_prodotto = ?, " +
                "prezzo = ?, ingredienti_pizza = ?, " +
                "gradi_drink = ?, menu_id = ?, tipo_prodotto = ? " +
                "WHERE id_prodotto = ?";
        jdbc.update(sql,
                prodotto.getNome(),
                prodotto.getPrezzo(),
                ingredienti,
                gradi,
                prodotto.getMenu().getId(),
                prodotto.getClass().getSimpleName(),
                prodotto.getId()
                );
        System.out.println("Prodotto " + prodotto.getNome() + " modificato nel DB!");
    }

    @Override
    public void eliminaProdotto(Prodotto prodotto) {
        String sql = "DELETE FROM prodotti WHERE id_prodotto = ?";
        jdbc.update(sql, prodotto.getId());
        System.out.println("Prodotto " + prodotto.getNome() + " eliminato dal DB!");
    }

    @Override
    public List<Prodotto> leggiTuttiProdottiMenu(Long id_menu) {
        String sql = "SELECT * FROM prodotti AS p " +
                "INNER JOIN menu AS m ON p.menu_id = m.id_menu WHERE p.menu_id = ?";
        return jdbc.query(sql, new ProdottiRowMapper(), id_menu);
    }
}
