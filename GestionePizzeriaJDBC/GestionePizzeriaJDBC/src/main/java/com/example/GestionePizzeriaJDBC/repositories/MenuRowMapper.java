package com.example.GestionePizzeriaJDBC.repositories;

import com.example.GestionePizzeriaJDBC.models.Drink;
import com.example.GestionePizzeriaJDBC.models.Menu;
import com.example.GestionePizzeriaJDBC.models.Pizza;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MenuRowMapper implements RowMapper<Menu> {

    @Override
    public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
        Menu menu = new Menu();
        menu.setId(rs.getLong("id_menu"));
        menu.setNome(rs.getString("nome_menu"));
        return menu;
    }

}
