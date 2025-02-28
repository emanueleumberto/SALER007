package org.example.esercizio.DAO;

import com.github.javafaker.Faker;
import org.example.esercizio.entities.Cliente;
import org.example.esercizio.entities.DettaglioOrdine;
import org.example.esercizio.entities.Ordine;
import org.example.esercizio.entities.Prodotto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

public class OrdineDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private EntityManager em = emf.createEntityManager();
    private Faker fake = new Faker(new Locale("it-IT"));
    private ClienteDAO clienteDao = new ClienteDAO();
    private ProdottoDAO prodottoDao = new ProdottoDAO();

    public int salvaOrdine(Ordine o) throws SQLException {
        em.getTransaction().begin();
        em.persist(o);
        em.flush();
        em.getTransaction().commit();
        System.out.println("Ordine salvato nel DB!");
        return o.getId_ordine();
    }

    public void salvaDettaglioOrdine(DettaglioOrdine o) throws SQLException {
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
        System.out.println("Dettaglio Ordine salvato nel DB!");
    }

    public Ordine leggiOrdine(int id) throws SQLException {
        return em.find(Ordine.class, id);
    }

    public void eliminaOrdine(Ordine o) throws SQLException {
        em.getTransaction().begin();
        em.remove(o);
        em.getTransaction().commit();
        System.out.println("Ordine n." + o.getId_ordine() + " eliminato dal DB!");
    }

    public List<Ordine> leggiTuttiOrdini() throws SQLException {
        Query q = em.createNamedQuery("Ordine.findAll", Ordine.class);
        return q.getResultList();
    }

    public void popolaDb(int n) throws SQLException {
        List<Cliente> listaClienti = clienteDao.leggiTuttiIClienti();
        List<Prodotto> listaProdotti = prodottoDao.leggiTuttiIProdotti();
        for (int i = 0; i < n; i++) {
            Cliente c = clienteDao.leggiCliente(fake.number().numberBetween(0, listaClienti.size()-1));
            Prodotto p = prodottoDao.leggiProdotto(fake.number().numberBetween(0, listaProdotti.size()-1));
            int qt = fake.number().numberBetween(1,3);

            Ordine o = new Ordine(c);
            int idOrdine = salvaOrdine(o);

            DettaglioOrdine d = new DettaglioOrdine(qt,leggiOrdine(idOrdine), p);
            salvaDettaglioOrdine(d);

        }
    }

}
