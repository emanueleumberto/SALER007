package org.example.esercizi.DAO;

import org.example.esercizi.DatabaseConn;
import org.example.esercizi.classes.Cliente;
import org.example.esercizi.classes.DettaglioOrdine;
import org.example.esercizi.classes.Ordine;
import org.example.esercizi.classes.Prodotto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrdineDAO {

    private ProdottoDAO prodottoDao = new ProdottoDAO();

    public void creaOrdine(Ordine o) throws SQLException {
        if(!(o.getDettaglioOrdine().getProdotto().getQuantita_disponibile() >= o.getDettaglioOrdine().getQuantita())) {
            System.out.println("Quantità prodotto non disponibile");
            return;
        }

        String sql = "INSERT INTO ordini (id_cliente) VALUES (?)";
        PreparedStatement ps = DatabaseConn.getConnetion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, o.getCliente().getId_cliente());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()) {
            int last_inserted_id = rs.getInt(1);
            System.out.println("last_inserted_id: " + last_inserted_id);
            sql = "INSERT INTO dettagli_ordine (id_ordine, id_prodotto, quantita, prezzo_unitario) " +
                    "VALUES (?, ?, ?, ?)";
            ps = DatabaseConn.getConnetion().prepareStatement(sql);
            ps.setInt(1, last_inserted_id);
            ps.setInt(2, o.getDettaglioOrdine().getProdotto().getId_prodotto());
            ps.setInt(3, o.getDettaglioOrdine().getQuantita());
            ps.setDouble(4, o.getDettaglioOrdine().getPrezzo_unitario());
            ps.executeUpdate();
        }
        Prodotto p = o.getDettaglioOrdine().getProdotto();
        p.setQuantita_disponibile(
                p.getQuantita_disponibile() -
                        o.getDettaglioOrdine().getQuantita());
        prodottoDao.modificaProdotto(p);
        System.out.println("Ordine inserito nel DB!");
    }

    public Ordine leggiOrdine(int id) throws SQLException {
        String sql = "SELECT o.id_ordine, c.id_cliente, do.id_dettaglio_ordine, p.id_prodotto, " +
                     "c.nome AS nome_cliente, c.cognome, c.email, c.telefono, " +
                     "p.nome AS nome_prodotto, p.prezzo, p.descrizione, p.quantita_disponibile, " +
                     "do.prezzo_unitario, do.quantita, o.data_ordine " +
                     "FROM ordini AS o " +
                     "INNER JOIN dettagli_ordine AS do ON o.id_ordine = do.id_ordine " +
                     "INNER JOIN clienti AS c ON o.id_cliente = c.id_cliente " +
                     "INNER JOIN prodotti AS p ON do.id_prodotto = p.id_prodotto " +
                     "WHERE o.id_ordine = ?";
        PreparedStatement ps = DatabaseConn.getConnetion().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Ordine o = null;
        if(rs.next()){
            int id_ordine = rs.getInt("id_ordine");
            int id_cliente = rs.getInt("id_cliente");
            String nome = rs.getString("nome_cliente");
            String cognome = rs.getString("cognome");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            LocalDate data_ordine = rs.getDate("data_ordine").toLocalDate();
            int id_dettaglio_ordine = rs.getInt("id_dettaglio_ordine");
            int id_prodotto = rs.getInt("id_prodotto");
            String nomeProdotto = rs.getString("nome_prodotto");
            String descrizione = rs.getString("descrizione");
            double prezzo = rs.getDouble("prezzo");
            int quantita_disponibile = rs.getInt("quantita_disponibile");
            int quantita = rs.getInt("quantita");
            double prezzo_unitario = rs.getDouble("prezzo_unitario");
            Cliente c = new Cliente(id_cliente, nome, cognome, email, telefono);
            Prodotto p = new Prodotto(id_prodotto, nomeProdotto, descrizione, prezzo, quantita_disponibile);
            DettaglioOrdine dettaglioOrdine = new DettaglioOrdine(id_dettaglio_ordine, p, quantita, prezzo_unitario);
            o = new Ordine(id_ordine, c, data_ordine, dettaglioOrdine);
        }
        return o;
    }

    public void modificaOrdine(Ordine o) throws SQLException {
        // Obj_Ordine -> int id_ordine, Cliente cliente, LocalDate data_ordine, DettaglioOrdine dettaglioOrdine
        // Table -> id_ordine id_cliente data_ordine
        String sql = "UPDATE ordini SET id_cliente = ?, data_ordine = ? WHERE id_ordine = ?";
        PreparedStatement ps = DatabaseConn.getConnetion().prepareStatement(sql);
        ps.setInt(1, o.getCliente().getId_cliente());
        ps.setString(2, o.getData_ordine().toString());
        ps.setInt(3, o.getId_ordine());
        ps.executeUpdate();

        // Obj_Ordine.Dettaglio -> int id_dettaglio_ordine, Prodotto prodotto, int quantita, double prezzo_unitario
        // Table -> id_dettaglio_ordine id_ordine id_prodotto quantità  prezzo_unitario
        sql = "UPDATE dettagli_ordine SET id_ordine = ?, id_prodotto = ?, quantita = ?, prezzo_unitario = ? " +
                "WHERE id_dettaglio_ordine = ?";
        ps = DatabaseConn.getConnetion().prepareStatement(sql);
        ps.setInt(1, o.getId_ordine());
        ps.setInt(2, o.getDettaglioOrdine().getProdotto().getId_prodotto());
        ps.setInt(3, o.getDettaglioOrdine().getQuantita());
        ps.setDouble(4, o.getDettaglioOrdine().getPrezzo_unitario());
        ps.setInt(5, o.getDettaglioOrdine().getId_dettaglio_ordine());
        ps.executeUpdate();
        System.out.println("Ordine n." + o.getId_ordine() + " modificato nel DB!");
    }

    public void eliminaOrdine(Ordine o) throws SQLException {
        String sql = "DELETE FROM ordini WHERE id_ordine = ?";
        PreparedStatement ps = DatabaseConn.getConnetion().prepareStatement(sql);
        ps.setInt(1, o.getId_ordine());
        ps.executeUpdate();
        System.out.println("Ordine n." + o.getId_ordine() + " eliminato dal DB!");
    }

    public List<Ordine> leggiTuttiOrdini() throws SQLException {
        String sql = "SELECT o.id_ordine, c.id_cliente, do.id_dettaglio_ordine, p.id_prodotto, " +
                "c.nome AS nome_cliente, c.cognome, c.email, c.telefono, " +
                "p.nome AS nome_prodotto, p.prezzo, p.descrizione, p.quantita_disponibile, " +
                "do.prezzo_unitario, do.quantita, o.data_ordine " +
                "FROM ordini AS o " +
                "INNER JOIN dettagli_ordine AS do ON o.id_ordine = do.id_ordine " +
                "INNER JOIN clienti AS c ON o.id_cliente = c.id_cliente " +
                "INNER JOIN prodotti AS p ON do.id_prodotto = p.id_prodotto";
        PreparedStatement ps = DatabaseConn.getConnetion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Ordine> lista = new ArrayList<Ordine>();
        while(rs.next()){
            int id_ordine = rs.getInt("id_ordine");
            int id_cliente = rs.getInt("id_cliente");
            String nome = rs.getString("nome_cliente");
            String cognome = rs.getString("cognome");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            LocalDate data_ordine = rs.getDate("data_ordine").toLocalDate();
            int id_dettaglio_ordine = rs.getInt("id_dettaglio_ordine");
            int id_prodotto = rs.getInt("id_prodotto");
            String nomeProdotto = rs.getString("nome_prodotto");
            String descrizione = rs.getString("descrizione");
            double prezzo = rs.getDouble("prezzo");
            int quantita_disponibile = rs.getInt("quantita_disponibile");
            int quantita = rs.getInt("quantita");
            double prezzo_unitario = rs.getDouble("prezzo_unitario");
            Cliente c = new Cliente(id_cliente, nome, cognome, email, telefono);
            Prodotto p = new Prodotto(id_prodotto, nomeProdotto, descrizione, prezzo, quantita_disponibile);
            DettaglioOrdine dettaglioOrdine = new DettaglioOrdine(id_dettaglio_ordine, p, quantita, prezzo_unitario);
            lista.add(new Ordine(id_ordine, c, data_ordine, dettaglioOrdine));
        }
        return lista;
    }

}
