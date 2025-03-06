package com.example.GestionePizzeriaJDBC.repositories;

import com.example.GestionePizzeriaJDBC.models.Cliente;
import com.example.GestionePizzeriaJDBC.models.Ordine;
import com.example.GestionePizzeriaJDBC.models.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Component
public class OrdineDAO implements OrdineDAORepository {

    @Autowired JdbcTemplate jdbc;

    // Cliente

    @Override
    public void salvaCliente(Cliente cliente) {
        String sql = "INSERT INTO clienti (nome_cliente, telefono_cliente) " +
                "VALUES (?, ?)";
        jdbc.update(sql, cliente.getNome(), cliente.getTelefono());
        System.out.println("Cliente " + cliente.getNome() + " salvato nel DB!");
    }

    @Override
    public Cliente leggiCliente(Long id) {
        String sql = "SELECT * FROM clienti WHERE id_cliente = ?";
        return jdbc.queryForObject(sql, new ClienteRowMapper(), id);
    }

    @Override
    public void modificaCliente(Cliente cliente) {
        String sql = "UPDATE clienti SET nome_cliente = ?, telefono_cliente = ? " +
                "WHERE id_cliente = ?";
        jdbc.update(sql, cliente.getNome(), cliente.getTelefono(), cliente.getId());
        System.out.println("Cliente " + cliente.getNome() + " modificato nel DB!");
    }

    @Override
    public void eliminaCliente(Cliente cliente) {
        String sql = "DELETE FROM clienti WHERE id_cliente = ?";
        jdbc.update(sql, cliente.getId());
        System.out.println("Cliente " + cliente.getNome() + " eliminato dal DB!");
    }

    @Override
    public List<Cliente> leggiTuttiClienti() {
        String sql = "SELECT * FROM clienti";
        return jdbc.query(sql, new ClienteRowMapper());
    }

    // Ordine

    @Override
    public void salvaOrdine(Ordine ordine) {
        String sql = "INSERT INTO ordini (id_cliente, dataOrdine, totale) VALUES (?, ?, ?)";
        //jdbc.update(sql, ordine.getCliente().getId(), ordine.getDataOrdine(), ordine.getTotale());

        GeneratedKeyHolder holder = new GeneratedKeyHolder(); // Per farmi ritornare l'ID inserito
        jdbc.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setLong(1, ordine.getCliente().getId());
                statement.setString(2, ordine.getDataOrdine().toString());
                statement.setDouble(3, ordine.getTotale());
                return statement;
            }
        }, holder);

        // leggo l'ultimo id dell'ordine inserito
        long numeroOrdine = holder.getKey().longValue();

        String sql_p = "INSERT INTO prodotti_ordini (numeroOrdine, id_prodotto) VALUES (?, ?)";
        ordine.getListaProdotti().forEach(p -> {
            jdbc.update(sql_p, numeroOrdine, p.getId());
        });

        System.out.println("Ordine " + ordine.getCliente().getNome() + " salvato nel DB!");

    }

    @Override
    public Ordine leggiOrdine(Long numeroOrdine) {
        String sql = "SELECT * FROM ordini AS o " +
                "INNER JOIN clienti AS c ON o.id_cliente = c.id_cliente " +
                "WHERE o.numeroOrdine = ?";
        return jdbc.queryForObject(sql, new OrdineRowMapper(), numeroOrdine);
    }

    @Override
    public List<Prodotto> leggiProdottiOrdine(Long numeroOrdine) {
        String sql = "SELECT * FROM prodotti_ordini AS po " +
                "INNER JOIN prodotti AS p ON po.id_prodotto = p.id_prodotto " +
                "INNER JOIN menu AS m ON p.menu_id = m.id_menu " +
                "WHERE po.numeroOrdine = ?";
        return jdbc.query(sql, new ProdottiRowMapper(), numeroOrdine);
    }

    @Override
    public void modificaOrdine(Ordine ordine) {

    }

    @Override
    public void eliminaOrdine(Ordine ordine) {

    }

    @Override
    public List<Ordine> leggiTuttiOrdini() {
        return List.of();
    }
}
