package org.example.DAO;

import org.example.entities.Company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CompanyDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private EntityManager em = emf.createEntityManager();

    public void saveCompany(Company company) {
        em.getTransaction().begin();
        em.persist(company);
        em.getTransaction().commit();
    }

    public void removeCompany(Company company) {
        em.getTransaction().begin();
        em.remove(company);
        em.getTransaction().commit();
    }

    public Company getComapany(Integer id) {
        return em.find(Company.class, id);
    }

    public List<Company> getAllCompany() {
        Query q = em.createNamedQuery("Company.findAll", Company.class);
        return q.getResultList();
    }

}
