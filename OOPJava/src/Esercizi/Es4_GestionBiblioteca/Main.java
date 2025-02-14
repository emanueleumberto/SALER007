package Esercizi.Es4_GestionBiblioteca;

public class Main {

    public static void main(String[] args) {
        Libro l1 = new Libro("Harry Potter", "J.K.Rowling", "AB001");
        System.out.println(l1.getDettagli());
        l1.prestareLibro();
        System.out.println(l1.getDettagli());
        l1.prestareLibro();
        l1.restituireLibro();
        System.out.println(l1.getDettagli());
        l1.restituireLibro();
    }

}
