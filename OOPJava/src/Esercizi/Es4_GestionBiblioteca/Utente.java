package Esercizi.Es4_GestionBiblioteca;

import java.sql.SQLOutput;

public class Utente {

    private String IDUtente;
    private String nome;
    private String cognome;
    private Libro[] listaPrestiti;

    public Utente(String IDUtente, String nome, String cognome) {
        this.IDUtente = IDUtente;
        this.nome = nome;
        this.cognome = cognome;
        this.listaPrestiti = new Libro[3];
    }

    public String getIDUtente() { return this.IDUtente; }
    public String getNome() { return this.nome; }
    public String getCognome() { return this.cognome; }

    public void prendereInPrestito(Libro libro) {
        if(libro.isDisponibile()) {
            for(int i=0; i<this.listaPrestiti.length; i++) {
                if(this.listaPrestiti[i] == null) {
                    libro.prestareLibro();
                    this.listaPrestiti[i] = libro;
                    return;
                }
            }
            System.out.println("Hai già 3 libri in prestito, restituisci qualcosa");
        } else {
            System.out.println("Libro non disponibile, torna tra qualche giorno");
        }
    }

    public void restituireLibro(Libro libro) {
        for(int i=0; i<this.listaPrestiti.length; i++) {
            if(this.listaPrestiti[i] != null
                    && this.listaPrestiti[i].getISBN().equals(libro.getISBN())) {
                libro.restituireLibro();
                this.listaPrestiti[i] = null;
                return;
            }
        }
        System.out.println("Il libro che vuoi restituire non è a te assegnato!");
    }

    public void mostraLibriInPrestito() {
        System.out.println("Libri di " + this.nome + " " + this.cognome + ": ");
        for(int i=0; i<this.listaPrestiti.length; i++) {
            if(this.listaPrestiti[i] != null) {
                System.out.println("     - " + this.listaPrestiti[i].getDettagli());
            }
        }
    }

}
