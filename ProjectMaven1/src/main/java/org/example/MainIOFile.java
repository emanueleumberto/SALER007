package org.example;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainIOFile {

    private static File file = new File("file/test.txt");

    public static void main(String[] args) {
        // Gestione I/O su file
        // La JDK mi mette a disposizione numerose librerie per la gestione di file
        // Una delle librerie più utilizzate per la lettura e scrittura di file
        // Apache Commons IO

        // Stringa newLine per andare a capo nel file
        String newLine = System.getProperty("line.separator");

        /*try {
            //scriviFile("Prova inserimento testo!!!" + newLine);
            //String testoDaFile = leggiFile();
            //System.out.println(testoDaFile);
            rimuoviFile();
            rimuoviDirectory();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/


        Faker fake = new Faker(new Locale("it-IT"));
        List<User> listaUtenti = new ArrayList<User>();
        for (int i = 0; i < 5; i++) {
            listaUtenti.add(new User(
                    fake.name().firstName(),
                    fake.name().lastName(),
                    fake.address().city(),
                    fake.number().numberBetween(18, 80))
            );
        }

        // Scrittura su file
        /*listaUtenti.forEach(u -> {
            String utente = u.getName() + "," + u.getLastname() + "," + u.getCity() + "," + u.getAge() + ";";
            try {
                scriviFile(utente+newLine);
            } catch (IOException e) {
                System.out.println("Errore!!!");
            }
        });*/

        // Lettura su file
        try {
            List<User> utentiLettiDaFile = new ArrayList<User>();
            String contenutoFile = leggiFile();
            //System.out.println(contenutoFile);
            String[] rows = contenutoFile.split(";");
            //System.out.println(Arrays.toString(rows));
            for (String row : rows) {
                String[] propUtente = row.split(",");
                User u = new User(propUtente[0], propUtente[1], propUtente[2], Integer.parseInt(propUtente[3]));
                utentiLettiDaFile.add(u);
            }

            utentiLettiDaFile.forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void scriviFile(String testo) throws IOException {
        FileUtils.writeStringToFile(file, testo, true);
        System.out.println("Testo salvato su file");
    }

    public static String leggiFile() throws IOException {
        String testo = FileUtils.readFileToString(file, "UTF-8");
        return testo;
    }

    public static void rimuoviFile() throws IOException {
        FileUtils.deleteQuietly(file);
        System.out.println("File di testo eliminato!!");
    }

    public static void rimuoviDirectory() throws IOException {
        File file = new File("file/");
        FileUtils.deleteDirectory(file);
        System.out.println("Directory eliminata!!");
    }
}
