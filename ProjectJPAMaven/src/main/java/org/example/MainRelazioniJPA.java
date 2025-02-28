package org.example;

import com.github.javafaker.Faker;
import org.example.DAO.CompanyDAO;
import org.example.DAO.CourseDAO;
import org.example.DAO.PassportDAO;
import org.example.DAO.UserDAO;
import org.example.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Locale;

public class MainRelazioniJPA {

    private static Faker fake = new Faker(new Locale("it-IT"));
    private static UserDAO userDao = new UserDAO();
    private static CompanyDAO companyDao = new CompanyDAO();
    private static PassportDAO passportDao = new PassportDAO();
    private static CourseDAO courseDao = new CourseDAO();

    public static void main(String[] args) {

        // Creo un indirizzo
        //Address a = new Address("Via Marconi", "Roma", 50);
        // Creo un utente e gli assegno l'indirizzo appena creato
        //User u = new User("Mario", "Rossi", 45, "m.rossi@example.com", "Pa$$w0rd!", a);
        //userDao.saveUser(u); // Salvo il nuovo utente nel DB

        // Devo creare un passaporto (User)
        //User u = userDao.getUser(1); // Leggo un utente dal DB per avere un id valido
        //Passport p = new Passport("AB001", LocalDate.now(), u);
        //passportDao.savePassport(p); // Salvo il nuovo passaporto nel DB

        // Creo un Azienda
        //Company c = new Company("Pippo S.p.a.");
        //companyDao.saveCompany(c); // Salvo la nuova azienda nel DB

        // Creo un Corso
        //Course co = new Course("Java", 100);
        //courseDao.saveCourse(co); // Salvo il nuovo corso nel DB

        // Voglio assegnare una Azienda ad un Utente
        //User u = userDao.getUser(1); // Leggo un utente dal DB per avere un id valido
        //Company c = companyDao.getComapany(1); // Leggo un azienda dal DB per avere un id valido
        //u.setCompany(c); // Inserisco una azienda nella proprietà company di un utente
        //userDao.saveUser(u); // Aggiorno l'utente nel DB con il riferimento alla azienda letta

        // Voglio assegnare un Corso ad un Utente
        //User u = userDao.getUser(1); // Leggo un utente dal DB per avere un id valido
        //Course co = courseDao.getCourse(1); // Leggo un Corso dal DB per avere un id valido
        //u.getCoursesList().add(co); // Inserisco un corso nella proprietà courseList di un utente
        //userDao.saveUser(u); // Aggiorno l'utente nel DB con il riferimento al nuovo corso letto

        // Stampo tutti i dati di un utente
        //User u = userDao.getUser(1);
        //System.out.println(u);
        //System.out.println(u.getAddress());
        //System.out.println(u.getCompany());
        //System.out.println(u.getCoursesList());
        //System.out.println(u.getPassport());
    }

}
