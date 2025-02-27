package org.example.esercizi.DAO;

import org.example.esercizi.DatabaseConn;
import org.example.esercizi.classes.Prodotto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {

    public void creaProdotto(Prodotto p) throws SQLException {
        String sql = "INSERT INTO prodotti (nome, descrizione, prezzo, quantita_disponibile) " +
                "VALUES (?, ?, ?, ?)";
        PreparedStatement ps = DatabaseConn.getConnetion().prepareStatement(sql);
        ps.setString(1, p.getNome());
        ps.setString(2, p.getDescrizione());
        ps.setDouble(3, p.getPrezzo());
        ps.setInt(4, p.getQuantita_disponibile());
        ps.executeUpdate();
        System.out.println("Prodotto " + p.getNome() + " inserito nel DB!");
    }

    public Prodotto leggiProdotto(int id) throws SQLException {
        String sql = "SELECT * FROM prodotti WHERE id_prodotto = ?";
        PreparedStatement ps = DatabaseConn.getConnetion().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Prodotto p = null;
        if(rs.next()){
            int id_prodotto = rs.getInt("id_prodotto");
            String nome = rs.getString("nome");
            String descrizione = rs.getString("descrizione");
            double prezzo = rs.getDouble("prezzo");
            int quantita = rs.getInt("quantita_disponibile");
            p = new Prodotto(id_prodotto, nome, descrizione, prezzo, quantita);
        }
        return p;
    }

    public void modificaProdotto(Prodotto p) throws SQLException {
        String sql = "UPDATE prodotti SET nome = ?, descrizione = ?, prezzo = ?, quantita_disponibile = ? " +
                "WHERE id_prodotto = ?";
        PreparedStatement ps = DatabaseConn.getConnetion().prepareStatement(sql);
        ps.setString(1, p.getNome());
        ps.setString(2, p.getDescrizione());
        ps.setDouble(3, p.getPrezzo());
        ps.setInt(4, p.getQuantita_disponibile());
        ps.setInt(5, p.getId_prodotto());
        ps.executeUpdate();
        System.out.println("Prodotto " + p.getNome() + " modificato nel DB!");
    }

    public void eliminaProdotto(Prodotto p) throws SQLException {
        String sql = "DELETE FROM prodotti WHERE id_prodotto = ?";
        PreparedStatement ps = DatabaseConn.getConnetion().prepareStatement(sql);
        ps.setInt(1, p.getId_prodotto());
        ps.executeUpdate();
        System.out.println("Prodotto " + p.getNome() + " eliminato dal DB!");
    }

    public List<Prodotto> leggiTuttiIProdotti() throws SQLException {
        String sql = "SELECT * FROM prodotti";
        PreparedStatement ps = DatabaseConn.getConnetion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Prodotto> lista = new ArrayList<Prodotto>();
        while(rs.next()){
            int id_prodotto = rs.getInt("id_prodotto");
            String nome = rs.getString("nome");
            String descrizione = rs.getString("descrizione");
            double prezzo = rs.getDouble("prezzo");
            int quantita = rs.getInt("quantita_disponibile");
            lista.add(new Prodotto(id_prodotto, nome, descrizione, prezzo, quantita));
        }
        return lista;
    }

}
