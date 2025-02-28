package org.example.DAO;

import org.example.entities.Passport;
import org.example.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PassportDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private EntityManager em = emf.createEntityManager();

    public void savePassport(Passport passport) {
        em.getTransaction().begin();
        em.persist(passport);
        em.getTransaction().commit();
    }

    public void removePassport(Passport passport) {
        em.getTransaction().begin();
        em.remove(passport);
        em.getTransaction().commit();
    }

    public Passport getPassport(Integer id) {
        return em.find(Passport.class, id);
    }

    public List<Passport> getAllPassport() {
        Query q = em.createNamedQuery("Passport.findAll", Passport.class);
        return q.getResultList();
    }

}
