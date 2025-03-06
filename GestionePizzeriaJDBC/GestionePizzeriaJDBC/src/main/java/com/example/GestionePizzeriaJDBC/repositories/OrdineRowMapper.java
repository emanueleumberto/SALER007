package com.example.GestionePizzeriaJDBC.repositories;

import com.example.GestionePizzeriaJDBC.models.Cliente;
import com.example.GestionePizzeriaJDBC.models.Ordine;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdineRowMapper implements RowMapper<Ordine> {
    @Override
    public Ordine mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setId(rs.getLong("id_cliente"));
        cliente.setNome(rs.getString("nome_cliente"));
        cliente.setTelefono(rs.getString("telefono_cliente"));

        Ordine ordine = new Ordine();
        ordine.setNumeroOrdine(rs.getInt("numeroOrdine"));
        ordine.setDataOrdine(rs.getDate("dataOrdine").toLocalDate());
        ordine.setTotale(rs.getDouble("totale"));
        ordine.setCliente(cliente);
        return ordine;
    }
}
