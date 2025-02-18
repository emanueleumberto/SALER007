package org.example;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args ) {
        Logger log = LoggerFactory.getLogger(Main.class);
        Faker fake = new Faker(new Locale("it-IT"));

        //System.out.println("Inizio Caricamento...");
        log.info("Inizio Caricamento...");
        User[] listaUtenti = new User[3];
        try {
            for (int i = 0; i < listaUtenti.length; i++) {
                listaUtenti[i] = new User(
                        fake.name().firstName(),
                        fake.name().lastName(),
                        fake.address().city(),
                        fake.number().numberBetween(18, 80));
            }
        } catch (RuntimeException e) {
            log.error(e.getMessage());
        }
        //System.out.println("Caricamento Completato");
        log.info("Caricamento Completato");
        /*for(int i=0; i< listaUtenti.length; i++) {
            System.out.println(listaUtenti[i]);
        }*/

        //Configurare Logback per scrivere su un file
        //Crea un file logback.xml nella cartella src/main/resources/
        //Logger log = LoggerFactory.getLogger(Main.class);

        log.info("Logger INFO");
        log.error("Logger ERROR");
        log.debug("Logger DUBUG");
        log.warn("Logger WARNING");

    }
}
