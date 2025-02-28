package org.example.esercizio.DAO;

import com.github.javafaker.Faker;
import org.example.esercizio.entities.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

public class ClienteDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private EntityManager em = emf.createEntityManager();
    private static Faker fake = new Faker(new Locale("it-IT"));

    public void salvaCliente(Cliente c) throws SQLException {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        System.out.println("Cliente " + c.getNome() + " " + c.getCognome() + " salvato nel DB!");
    }

    public Cliente leggiCliente(int id) throws SQLException {
        return em.find(Cliente.class, id);
    }

    public void eliminaCliente(Cliente c) throws SQLException {
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
        System.out.println("Cliente " + c.getNome() + " " + c.getCognome() + " eliminato dal DB!");
    }

    public List<Cliente> leggiTuttiIClienti() throws SQLException {
        Query q = em.createNamedQuery("Cliente.findAll", Cliente.class);
        return q.getResultList();
    }

    public void popolaDb(int n) throws SQLException {
        for (int i = 0; i < n; i++) {
            String name = fake.name().firstName();
            String last = fake.name().lastName();
            String email = name.toLowerCase().charAt(0)+"."+last.toLowerCase()+"@example.com";
            String phone = fake.phoneNumber().cellPhone();
            Cliente c = new Cliente(name,last,email,phone);
            salvaCliente(c);
        }
    }
}
