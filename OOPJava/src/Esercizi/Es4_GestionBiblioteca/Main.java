package Esercizi.Es4_GestionBiblioteca;

public class Main {

    public static void main(String[] args) {
        Libro l1 = new Libro("Harry Potter", "J.K.Rowling", "AB001");
        Libro l2 = new Libro("Single con criceto", "Milena Michiko Flasar", "AB002");
        Libro l3 = new Libro("Anniversario", "Andrea Bajani", "AB003");
        Libro l4 = new Libro("Angelo di pietra", "Marcello Simoni", "AB004");

        Utente u1 = new Utente("U001", "Mario", "Rossi");
        Utente u2 = new Utente("U002", "Giuseppe", "Verdi");


        u1.prendereInPrestito(l2);
        u1.prendereInPrestito(l1);
        u1.prendereInPrestito(l3);
        u1.prendereInPrestito(l4);
        u1.mostraLibriInPrestito();

        u2.prendereInPrestito(l2);
        u2.prendereInPrestito(l4);
        u2.mostraLibriInPrestito();

        u1.restituireLibro(l1);
        u1.mostraLibriInPrestito();

        u2.restituireLibro(l2);
        u2.mostraLibriInPrestito();


    }

}
