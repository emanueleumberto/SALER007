package Esercizi.Es4_GestionBiblioteca;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        // Creo una Biblioteca
        Biblioteca b1 = new Biblioteca("BiblioX");

        System.out.println("********************************************");

        // Creo dei libri di esempio
        /*Libro l1 = new Libro("Harry Potter", "J.K.Rowling", "AB001");
        Libro l2 = new Libro("Single con criceto", "Milena Michiko Flasar", "AB002");
        Libro l3 = new Libro("Anniversario", "Andrea Bajani", "AB003");
        Libro l4 = new Libro("Angelo di pietra", "Marcello Simoni", "AB004");*/

        // Creo degli utenti di esempio
        /*Utente u1 = new Utente("U001", "Mario", "Rossi");
        Utente u2 = new Utente("U002", "Giuseppe", "Verdi");*/

        // Inserisco i libri nel catalogo
        /*b1.aggiungiLibro(l1);
        b1.aggiungiLibro(l2);
        b1.aggiungiLibro(l3);
        b1.aggiungiLibro(l4);
        b1.aggiungiLibro(l1);*/

        // Inserisco gli utenti registrandoli alla biblioteca
        /*b1.registraUtente(u1);
        b1.registraUtente(u2);
        b1.registraUtente(u1);*/

        // Stampo il catalogo Libri
        //b1.mostraCatalogo();
        // Stampo l'elenco di Utenti registrati
        //b1.mostraUtentiRegistrati();

        // Prendo in prestito un libro
        /*b1.prestitoLibro("U001", "AB003");
        b1.prestitoLibro("U001", "AB004");
        b1.prestitoLibro("U002", "AB001");
        b1.restituzioneLibro("U001", "AB003");*/

        // Interfaccia tramite Scanner
        while(true) {
            stampaMenu();
            String scelta = sc.nextLine();
            switch (scelta) {
                case "1":
                    b1.mostraCatalogo();
                    break;
                case "2":
                    b1.mostraUtentiRegistrati();
                    break;
                case "3":
                    Libro l = registraLibro();
                    b1.aggiungiLibro(l);
                    break;
                case "4":
                    Utente u = registraUtente();
                    b1.registraUtente(u);
                    break;
                case "5":
                    System.out.print("Inserisci il codice ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Inserisci IDUtente: ");
                    String idUtente = sc.nextLine();
                    b1.prestitoLibro(idUtente, isbn);
                    break;
                case "6":
                    System.out.print("Inserisci il codice ISBN: ");
                    String cod = sc.nextLine();
                    System.out.print("Inserisci IDUtente: ");
                    String id = sc.nextLine();
                    b1.restituzioneLibro(id, cod);
                    break;
                case "0":
                    System.out.println("Fine Programma");
                    return;
                default:
                    System.out.println("Codice inserito errato!!");
            }
        }
    }

    public static void stampaMenu() {
        System.out.println("--- Menu Biblioteca ---");
        System.out.println("1 -> Stampa il catalogo dei libri");
        System.out.println("2 -> Stampa un elenco di utenti registrati");
        System.out.println("3 -> Inserisci un Libro");
        System.out.println("4 -> Registra un Utente");
        System.out.println("5 -> Prestito");
        System.out.println("6 -> Restituzione");
        System.out.println("0 -> Fine");
    }

    public static Libro registraLibro() {
        System.out.print("Inserisci il titolo: ");
        String titolo = sc.nextLine();
        System.out.print("Inserisci Autore: ");
        String autore = sc.nextLine();
        System.out.print("Inserisci ISBN");
        String ISBN = sc.nextLine();
        return new Libro(titolo,autore, ISBN);
    }

    public static Utente registraUtente() {
        System.out.print("Inserisci il nome: ");
        String nome = sc.nextLine();
        System.out.print("Inserisci il cognome: ");
        String cognome = sc.nextLine();
        System.out.print("Inserisci il codice univoco: ");
        String codice = sc.nextLine();
        return new Utente(codice, nome, cognome);
    }

}
