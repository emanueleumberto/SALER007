package Esercizi.Es4_GestionBiblioteca;

public class Biblioteca {

    private String nome;
    private Libro[] catalogoLibri;
    private Utente[] utentiRegistrati;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.catalogoLibri = new Libro[10];
        this.utentiRegistrati = new Utente[10];
    }

    public void aggiungiLibro(Libro libro) {
        // Controllo se il libro è già presente nel catalogo
        for(int i=0; i<this.catalogoLibri.length; i++) {
            if(this.catalogoLibri[i] != null && this.catalogoLibri[i].getISBN().equals(libro.getISBN())) {
                System.out.println(libro.getDettagli() + " già presente nel sistema!!!!");
                return;
            }
        }
        // Inserisco il libro nel catalogo
        for(int i=0; i< this.catalogoLibri.length; i++) {
            if(this.catalogoLibri[i] == null) {
                this.catalogoLibri[i] = libro;
                System.out.println(libro.getDettagli() + " inserito nel sistema!!!!");
                return;
            }
        }

    }

    public void registraUtente(Utente utente) {
        // Controllo se l'utente è già registrato
        for(int i=0; i<this.utentiRegistrati.length; i++) {
            if(this.utentiRegistrati[i] != null
                    && this.utentiRegistrati[i].getIDUtente().equals(utente.getIDUtente())) {
                System.out.println(utente.getNome() + " " + utente.getCognome() + " è già presente nel sistema!!!!");
                return;
            }
        }
        // Inserisco l'utente nella lista
        for(int i=0; i< this.utentiRegistrati.length; i++) {
            if(this.utentiRegistrati[i] == null) {
                this.utentiRegistrati[i] = utente;
                System.out.println(utente.getNome() + " " + utente.getCognome() + " inserito nel sistema!!!!");
                return;
            }
        }

    }

    public void mostraCatalogo() {
        System.out.println("Catalogo Libri: ");
        for(int i=0; i< catalogoLibri.length; i++) {
            if(catalogoLibri[i] != null) {
                System.out.println(i + " - " + catalogoLibri[i].getDettagli());;
            }
        }
    }

    public void mostraUtentiRegistrati() {
        System.out.println("Lista Utenti registrati: ");
        for(int i=0; i< utentiRegistrati.length; i++) {
            if(utentiRegistrati[i] != null) {
                System.out.println(i + " - " + utentiRegistrati[i].getIDUtente() + " | " + utentiRegistrati[i].getNome() + " " + utentiRegistrati[i].getCognome());
            }
        }
    }

    public void prestitoLibro(String idUtente, String ISBN) {
        Libro l = cercaLibro(ISBN); // null || Libro
        Utente u = cercaUtente(idUtente); // null || Utente
        if(l != null && u != null) {
            u.prendereInPrestito(l);
            System.out.println("Libro " + l.getISBN() + " registrato a " + u.getIDUtente());
        }
    }

    public void restituzioneLibro(String idUtente, String ISBN) {
        Libro l = cercaLibro(ISBN); // null || Libro
        Utente u = cercaUtente(idUtente); // null || Utente
        if(l != null && u != null) {
            u.restituireLibro(l);
            System.out.println("Libro " + l.getISBN() + " restituito da " + u.getIDUtente());
        }
    }

    public Libro cercaLibro(String ISBN) {
        for(int i=0; i< catalogoLibri.length; i++) {
            if(catalogoLibri[i] != null && catalogoLibri[i].getISBN().equals(ISBN)) {
                return catalogoLibri[i];
            }
        }
        return null;
    }

    public Utente cercaUtente(String idUtente) {
        for(int i=0; i< utentiRegistrati.length; i++) {
            if(utentiRegistrati[i] != null && utentiRegistrati[i].getIDUtente().equals(idUtente)) {
                return utentiRegistrati[i];
            }
        }
        return null;
    }
}
