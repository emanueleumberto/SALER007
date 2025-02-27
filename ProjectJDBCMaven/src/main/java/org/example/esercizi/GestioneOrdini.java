package org.example.esercizi;

import org.example.esercizi.DAO.ClienteDAO;
import org.example.esercizi.DAO.OrdineDAO;
import org.example.esercizi.DAO.ProdottoDAO;
import org.example.esercizi.classes.Cliente;
import org.example.esercizi.classes.Ordine;
import org.example.esercizi.classes.Prodotto;

import java.sql.SQLException;

public class GestioneOrdini {
    public static void main(String[] args) {
        try {
            DatabaseConn db = new DatabaseConn();
            ClienteDAO clienteDao = new ClienteDAO();
            ProdottoDAO prodottiDAO = new ProdottoDAO();
            OrdineDAO ordineDAO = new OrdineDAO();

            //db.popolaDBClienti(10);
            //db.popolaDBProdotti(15);
            //db.popolaDBOrdini(12);

            // Test Clienti
            //Cliente cl = new Cliente("Mario", "Rossi", "m.rossi@example.com", "123.456.78.99");
            //clienteDao.creaCliente(cl);

            //Cliente clRead = clienteDao.leggiCliente(1);
            //System.out.println(clRead);

            //clRead.setEmail("mario.rossi@gmail.com");
            //clienteDao.modificaCliente(clRead);

            //clienteDao.eliminaCliente(clRead);

            // Test Prodotti
            //Prodotto pr = new Prodotto("Iphone", "Smartphone bellissimo!!", 799.99, 5);
            //prodottiDAO.creaProdotto(pr);

            //Prodotto prRead = prodottiDAO.leggiProdotto(1);
            //System.out.println(prRead);

            //prRead.setQuantita_disponibile(4);
            //prodottiDAO.modificaProdotto(prRead);

            //prodottiDAO.eliminaProdotto(prRead);

            // Test Ordini
            //Cliente co = clienteDao.leggiCliente(4);
            //Prodotto po = prodottiDAO.leggiProdotto(8);
            //Ordine or = new Ordine(co, po, 2);
            //ordineDAO.creaOrdine(or);

            //Ordine orRead = ordineDAO.leggiOrdine(2);
            //System.out.println(orRead);

            //orRead.getDettaglioOrdine().setQuantita(1);
            //ordineDAO.modificaOrdine(orRead);

            //ordineDAO.eliminaOrdine(orRead);

            //clienteDao.leggiTuttiIClienti().forEach(System.out::println);
            //prodottiDAO.leggiTuttiIProdotti().forEach(System.out::println);
            //ordineDAO.leggiTuttiOrdini().forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
