package org.example.DAO;

import org.example.entities.Course;
import org.example.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CourseDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private EntityManager em = emf.createEntityManager();

    public void saveCourse(Course course) {
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
    }

    public void removeCourse(Course course) {
        em.getTransaction().begin();
        em.remove(course);
        em.getTransaction().commit();
    }

    public Course getCourse(Integer id) {
        return em.find(Course.class, id);
    }

    public List<Course> getAllCourse() {
        Query q = em.createNamedQuery("Course.findAll", Course.class);
        return q.getResultList();
    }

}
