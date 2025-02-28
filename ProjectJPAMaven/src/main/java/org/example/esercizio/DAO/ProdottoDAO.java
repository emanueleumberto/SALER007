package org.example.esercizio.DAO;

import com.github.javafaker.Faker;
import org.example.esercizio.entities.Prodotto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

public class ProdottoDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private EntityManager em = emf.createEntityManager();
    private static Faker fake = new Faker(new Locale("it-IT"));

    public void salvaProdotto(Prodotto p) throws SQLException {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        System.out.println("Prodotto " + p.getNome() + " salvato nel DB!");
    }

    public Prodotto leggiProdotto(int id) throws SQLException {
        return em.find(Prodotto.class, id);
    }

    public void eliminaProdotto(Prodotto p) throws SQLException {
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        System.out.println("Prodotto " + p.getNome() + " eliminato dal DB!");
    }

    public List<Prodotto> leggiTuttiIProdotti() throws SQLException {
        Query q = em.createNamedQuery("Prodotto.findAll", Prodotto.class);
        return q.getResultList();
    }

    public void popolaDb(int n) throws SQLException {
        for (int i = 0; i < n; i++) {
            String name = fake.commerce().productName();
            String desc = fake.commerce().material() + " " + fake.commerce().color();
            double price = Double.parseDouble(fake.commerce().price().replace(",", "."));
            int qt = fake.number().numberBetween(1,5);
            Prodotto p = new Prodotto(name,desc,price,qt);
            salvaProdotto(p);
        }
    }

}
