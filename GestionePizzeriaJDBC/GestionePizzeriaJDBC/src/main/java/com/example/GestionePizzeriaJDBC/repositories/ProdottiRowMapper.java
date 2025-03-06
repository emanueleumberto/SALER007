package com.example.GestionePizzeriaJDBC.repositories;

import com.example.GestionePizzeriaJDBC.models.Drink;
import com.example.GestionePizzeriaJDBC.models.Menu;
import com.example.GestionePizzeriaJDBC.models.Pizza;
import com.example.GestionePizzeriaJDBC.models.Prodotto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProdottiRowMapper implements RowMapper<Prodotto> {
    @Override
    public Prodotto mapRow(ResultSet rs, int rowNum) throws SQLException {
        Menu menu = new Menu();
        menu.setId(rs.getLong("id_menu"));
        menu.setNome(rs.getString("nome_menu"));
        if(rs.getString("tipo_prodotto").equals("Pizza")) {
            Pizza pizza = new Pizza();
            pizza.setId(rs.getLong("id_prodotto"));
            pizza.setNome(rs.getString("nome_prodotto"));
            pizza.setIngredienti(List.of(rs.getString("ingredienti_pizza")));
            pizza.setPrezzo(rs.getDouble("prezzo"));
            pizza.setMenu(menu);
            return pizza;
        } else if(rs.getString("tipo_prodotto").equals("Drink")) {
            Drink drink = new Drink();
            drink.setId(rs.getLong("id_prodotto"));
            drink.setNome(rs.getString("nome_prodotto"));
            drink.setGradi(rs.getInt("gradi_drink"));
            drink.setPrezzo(rs.getDouble("prezzo"));
            drink.setMenu(menu);
            return drink;
        }
        return null;
    }
}
