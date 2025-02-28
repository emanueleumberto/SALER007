package org.example.esercizio;

import com.github.javafaker.Faker;
import org.example.esercizio.DAO.ClienteDAO;
import org.example.esercizio.DAO.OrdineDAO;
import org.example.esercizio.DAO.ProdottoDAO;
import org.example.esercizio.entities.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.Locale;

public class GestioneOrdini {

    private static Faker fake = new Faker(new Locale("it-IT"));
    private static ClienteDAO clienteDao = new ClienteDAO();
    private static ProdottoDAO prodottoDao = new ProdottoDAO();
    private static OrdineDAO ordineDao = new OrdineDAO();

    public static void main(String[] args) {

        try {
            //clienteDao.popolaDb(5);
            //prodottoDao.popolaDb(5);
            //ordineDao.popolaDb(3);

            //System.out.println("**** Clienti ****");
            //clienteDao.leggiTuttiIClienti().forEach(System.out::println);

            //System.out.println("**** Prodotti ****");
            //prodottoDao.leggiTuttiIProdotti().forEach(System.out::println);

            System.out.println("**** Ordini ****");
            ordineDao.leggiTuttiOrdini().forEach(System.out::println);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
