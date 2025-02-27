package org.example.esercizi;

import com.github.javafaker.Faker;
import org.example.esercizi.DAO.ClienteDAO;
import org.example.esercizi.DAO.ProdottoDAO;
import org.example.esercizi.classes.Cliente;
import org.example.esercizi.classes.Prodotto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class DatabaseConn {

    private Faker fake = new Faker(new Locale("it-IT"));
    private String url = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "root";
    private String db_name = "gestione_ordini";
    private static Connection conn;
    private Statement st;
    private ClienteDAO clienteDao = new ClienteDAO();
    private ProdottoDAO prodottoDao = new ProdottoDAO();


    public DatabaseConn() throws SQLException {
        conn = DriverManager.getConnection(url, user, pass);
        st = conn.createStatement();
        createDatabase();
        createTableClienti();
        createTableProdotti();
        createTableOrdini();
        createTableDettagliOrdine();
    }

    public static Connection getConnetion() {
        return conn;
    }

    private void createDatabase() throws SQLException {
        String sql = "CREATE DATABASE IF NOT EXISTS " + db_name;
        st.executeUpdate(sql);
        conn = DriverManager.getConnection(url+db_name, user, pass);
        st = conn.createStatement();
    }

    private void createTableClienti() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS clienti(" +
                "id_cliente INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "nome VARCHAR(100) NOT NULL, " +
                "cognome VARCHAR(100) NOT NULL, " +
                "email VARCHAR(150) NOT NULL UNIQUE, " +
                "telefono VARCHAR(20) NULL" +
                ")";
        st.executeUpdate(sql);
    }

    private void createTableProdotti() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS prodotti(" +
                "id_prodotto INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "nome VARCHAR(100) NOT NULL, " +
                "descrizione TEXT NULL, " +
                "prezzo DECIMAL(10,2) NOT NULL, " +
                "quantita_disponibile INT NOT NULL " +
                ")";
        st.executeUpdate(sql);
    }

    private void createTableOrdini() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS ordini(" +
                "id_ordine INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "id_cliente INT NOT NULL, " +
                "data_ordine TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "CONSTRAINT ordini_clienti_fk FOREIGN KEY(id_cliente) " +
                "REFERENCES clienti(id_cliente)" +
                "ON DELETE CASCADE ON UPDATE CASCADE" +
                ")";
        st.executeUpdate(sql);
    }

    private void createTableDettagliOrdine() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS dettagli_ordine(" +
                "id_dettaglio_ordine INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "id_ordine INT NOT NULL, " +
                "id_prodotto INT NOT NULL, " +
                "quantita INT NOT NULL, " +
                "prezzo_unitario DECIMAL(10,2) NOT NULL, " +
                "CONSTRAINT dettagli_ordini_ordini_fk FOREIGN KEY(id_ordine) " +
                "REFERENCES ordini(id_ordine)" +
                "ON DELETE CASCADE ON UPDATE CASCADE, " +
                "CONSTRAINT dettagli_ordini_prodotti_fk FOREIGN KEY(id_prodotto) " +
                "REFERENCES prodotti(id_prodotto)" +
                "ON DELETE CASCADE ON UPDATE CASCADE" +
                ")";
        st.executeUpdate(sql);
    }

    public void popolaDBClienti(int n) throws SQLException {
        for (int i = 0; i < n ; i++) {
            String firstName = fake.name().firstName();
            String lastName = fake.name().lastName();
            String email = firstName.toLowerCase().charAt(0) + "." + lastName.toLowerCase() + "@example.com";
            String phone = fake.phoneNumber().cellPhone();
            clienteDao.creaCliente(new Cliente(firstName, lastName, email, phone));
        }
    }

    public void popolaDBProdotti(int n) throws SQLException {
        for (int i = 0; i < n ; i++) {
            //nome, descrizione, prezzo, quantita_disponibile
            String nome = fake.commerce().productName();
            String descr = fake.commerce().productName() +
                    " (" + fake.commerce().material() + ") " +
                    fake.lorem().paragraph();
            double prezzo = Double.parseDouble(fake.commerce().price(10, 999.99).replace(",", "."));
            int quantita = fake.number().numberBetween(0,10);
            prodottoDao.creaProdotto(new Prodotto(nome, descr, prezzo, quantita));
        }
    }
}
