package Esercizi.Es2_GestoreTelefonico;

import java.util.Arrays;

public class Sim {

    public String numeroTelefono;
    public double credito;
    public Chiamata[] ultimeChiamate;
    public Gestore gestore;

    public Sim(String numeroTelefono, Gestore gestore) {
        this.numeroTelefono = numeroTelefono;
        this.credito = 0;
        this.ultimeChiamate = new Chiamata[5];
        this.gestore = gestore;
    }

    public void stampaSim() {
        System.out.println("Sim numero: " + this.numeroTelefono + " (" + this.gestore + ")");
        System.out.println("Credito: " + this.credito);
        System.out.println("Chiamate Effettuate: ");
        for (int i=0; i< ultimeChiamate.length; i++) {
            if(ultimeChiamate[i] != null) {
                System.out.println("     - " + ultimeChiamate[i].numeroChiamato + " (" + ultimeChiamate[i].durataMinuti + ")");
            }
        }
    }

    public void caricaCredito(double credito) {
        this.credito += credito;
        System.out.println("Ricarica da €" + credito + " effettuata sul numero " + this.numeroTelefono );
    }

    public void chiama(Chiamata chiamata) {
        if (this.credito > 0) {
            System.out.println("Chiamata effettuata!!");
            salvaUltimeChiamate(chiamata);
            aggiornaCredito(chiamata.durataMinuti);
        } else {
            System.out.println("Non hai credito sufficiente!!!!!!");
        }
    }

    public void salvaUltimeChiamate(Chiamata chiamata) {
        //ultimeChiamate[0] = chiamata;
        for(int i=0; i<ultimeChiamate.length; i++) {
            if(ultimeChiamate[i] == null) {
                ultimeChiamate[i] = chiamata;
                break;
            }
        }
    }

    public void aggiornaCredito(double minuti) {
        double importoSpeso = minuti * 0.20;
        this.credito -= importoSpeso;
    }


}
