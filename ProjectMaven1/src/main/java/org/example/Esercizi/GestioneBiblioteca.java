package org.example.Esercizi;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.Set;

public class GestioneBiblioteca {

    private static Logger log = LoggerFactory.getLogger(GestioneBiblioteca.class);
    private static Faker fake = new Faker(new Locale("it-IT"));
    private static Biblioteca b = new Biblioteca();

    public static void main(String[] args) {

        try {
            // Crea n libri in biblioteca
            creaLibriInBiblioteca(10);
            // Crea n lettori in biblioteca
            creaLettoriInBiblioteca(5);

            Lettore let1 = b.trovaLettoreDaID(3);
            Libro lib1 = b.getListaLibriDisponibili().get(2);
            b.prestaLibro(let1, lib1.getIsbn());

            Lettore let2 = b.trovaLettoreDaID(1);
            Libro lib2 = b.getListaLibriDisponibili().get(8);
            b.prestaLibro(let2, lib2.getIsbn());

            // Genero degli errori
            //Lettore let3 = b.trovaLettoreDaID(56); // Non esiste
            //Lettore let3 = b.trovaLettoreDaID(4);
            //Libro lib3 = b.getListaLibriDisponibili().get(15); // Non esiste
            //b.prestaLibro(let3, "3958723095"); // isbn non esiste

            System.out.println("*****************");

            // Stampa un elenco di libri disponibili in biblioteca
            stampaLibriDisponibili();

            System.out.println("*****************");

            // Stampa un elenco di lettori registrati
            stampaLettoriRegistrati();

            System.out.println("*****************");

            // Stampa un elenco di prestiti
            b.stampaPrestiti();

            System.out.println("*****************");

            b.restituisciLibro(b.trovaLettoreDaID(3), lib1.getIsbn());

            b.stampaPrestiti();

            System.out.println("*****************");
            // Stampa un elenco di libri disponibili in biblioteca
            stampaLibriDisponibili();


        } catch (PrestitoException e) {
            log.error(e.getMessage());
        } catch (LibroException e) {
            log.error(e.getMessage());
        } catch (LettoreException e) {
            log.error(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

    public static void creaLibriInBiblioteca(int numLibri) throws LibroException {
        for(int i=0; i<numLibri; i++) {
            Libro l = new Libro(
                    fake.code().isbn10(),
                    fake.book().title(),
                    fake.book().author(),
                    fake.number().numberBetween(1965, 2024));
            b.aggiungiLibro(l);
        }
    }

    public static void creaLettoriInBiblioteca(int numLettori) throws LettoreException {
        for(int i=0; i<numLettori; i++) {
            Lettore l = new Lettore(
                    fake.name().fullName(),
                    fake.internet().emailAddress()
            );
            b.registraLettore(l);
        }
    }

    public static void stampaLibriDisponibili() {
        System.out.println("***** Libri Disponibili *****");
        for(Libro lib : b.getListaLibriDisponibili()) {
            System.out.println(lib);
        }
    }

    public static void stampaLettoriRegistrati() {
        System.out.println("----- Lettori Registrati -----");
        for(Lettore let : b.getLettoriRegistrati()){
            System.out.println(let);
        }
    }


}
