package org.example;

import com.github.javafaker.Faker;
import org.example.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Locale;

/**
 * Hello world!
 *
 */
public class Main  {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private static EntityManager em = emf.createEntityManager();
    private static Faker fake = new Faker(new Locale("it-IT"));

    public static void main( String[] args ) {
        //User u = new User("Mario", "Rossi", 45, "m.rossi@example.com", "Pa$$w0rd!");
        //saveUser(u);

        /*for (int i = 0; i < 10; i++) {
            String name = fake.name().firstName();
            String last = fake.name().lastName();
            int age = fake.number().numberBetween(18,80);
            String email = name.toLowerCase()+"."+last.toLowerCase()+"@example.com";
            String pass = fake.internet().password();
            User u = new User(name, last, age, email, pass);
            saveUser(u);
        }*/

        //User userFind = getUser(5);
        //System.out.println(userFind);

        //userFind.setPassword("Pa$$w0rd!");
        //saveUser(userFind);

        //removeUser(userFind);

        //getAllUsers().forEach(System.out::println);
        //getUsersByName("Flavio").forEach(System.out::println);
    }

    public static void saveUser(User u) {
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
    }

    public static User getUser(int id) {
        return em.find(User.class, id);
    }

    public static void removeUser(User u) {
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
    }

    public static List<User> getAllUsers() {
        //Query q = em.createQuery("SELECT u FROM User u", User.class);
        Query q = em.createNamedQuery("User.findAll", User.class);
        return q.getResultList();
    }

    public static List<User> getUsersByName(String n) {
        Query q = em.createQuery("SELECT u FROM User u WHERE u.fisrtname = :name", User.class);
        q.setParameter("name", n);
        return q.getResultList();
    }


}
