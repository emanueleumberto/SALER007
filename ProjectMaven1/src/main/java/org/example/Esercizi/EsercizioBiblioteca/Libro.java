package org.example.Esercizi.EsercizioBiblioteca;

public class Libro {

    private String isbn;
    private String titolo;
    private String autore;
    private int annoPubblicazione;

    public Libro(String isbn, String titolo, String autore, int annoPubblicazione) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    @Override
    public String toString() {
        return isbn + " - titolo: " + titolo + ", autore: " + autore + ", annoPubblicazione: " + annoPubblicazione;
    }
}
