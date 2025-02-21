package org.example.Esercizi.EsercizioFinale;

import com.github.javafaker.Faker;

import java.io.File;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

public class GestioneOfficina {

    private static Faker fake = new Faker(new Locale("it-IT"));
    private static Officina off = new Officina("Officina F.lli Verdi");
    private static File file = new File("files/veicoli.txt");
    private static FileManager fileManager = new FileManager();

    public static void main(String[] args) {
        System.out.println("Lista Veicoli in officina");
        //creaVeicoliOfficina(4);


        //Veicolo v = off.cercaVeicolo("AB123CD").get();
        //v.aggiungiIntervento("Tagliando");
        //v.aggiungiIntervento("Sostituzione Cambio");
        //System.out.println(v);
        //off.rimuoviVeicolo(v.getTarga());
        //off.visualizzaVeicoli();
        //System.out.println("************");
        //off.filtraVeicoliPerMarca("Mercedes").forEach(System.out::println);
        //off.visualizzaVeicoli();

        // Gestione File
        //fileManager.scriviVeicoliSuFile(file, off.getVeicoli());
        Map<String, Veicolo> veicoliLettiDaFile =  fileManager.leggiVeicoliDaFile(file);
        caricaVeicoliOfficinaDaFile(veicoliLettiDaFile);
        //off.visualizzaVeicoli();

        //off.getVeicoli().values().forEach(e -> System.out.println(e));
        //off.getVeicoli().keySet().forEach(System.out::println);

        Optional<Veicolo> v = off.cercaVeicolo("VX107DM");
        //System.out.println(off.getVeicoli().get("VX107DM"));
        System.out.println(v.get().getInterventiManutenzione());
    }

    public static void creaVeicoliOfficina(int numVeicoli) {
        String[] marche = {"Fiat", "Ford", "Mercedes", "Bmw", "Renault", "Citroen"};
        String[] modelli = {"500", "Panda", "Captur", "ClasseA", "Fiesta", "Smart", "Coupè", "Serie5"};
        Veicolo v = new Veicolo("AB123CD", "Fiat", "Panda", 2000);
        off.aggiungiVeicolo(v);
        for (int i = 0; i < numVeicoli; i++) {
            String targa =  fake.letterify("??").toUpperCase() +
                            fake.number().numberBetween(100, 999) +
                            fake.letterify("??").toUpperCase();
            String marca = marche[fake.number().numberBetween(0, 5)];
            String modello = modelli[fake.number().numberBetween(0, 7)];
            int annoImmatricaolazione = fake.number().numberBetween(1990, 2025);

            off.aggiungiVeicolo(new Veicolo(targa, marca, modello, annoImmatricaolazione));
        }
    }

    public static void caricaVeicoliOfficinaDaFile(Map<String, Veicolo> veicoli) {
        veicoli.values().forEach(v -> {
            off.aggiungiVeicolo(v);
        });
    }
}
