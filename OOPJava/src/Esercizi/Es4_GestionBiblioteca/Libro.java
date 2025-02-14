package Esercizi.Es4_GestionBiblioteca;

public class Libro {

    private String titolo;
    private String autore;
    private String ISBN;
    private boolean disponibile;

    public Libro(String titolo, String autore, String ISBN) {
        this.titolo = titolo;
        this.autore = autore;
        this.ISBN = ISBN;
        this.disponibile = true;
    }

    public String getISBN() { return this.ISBN; }
    public boolean isDisponibile() { return this.disponibile; }

    public String getDettagli(){
        /*String disp = "";
        if(disponibile == true) {
            disp = "Disponibile";
        } else {
            disp = "NON Disponibile";
        }*/
        // Operatore Ternario
        // var = condizione ? valore true : valore false
        String disp = disponibile ? "Disponibile" : "NON Disponibile";
        return "Libro: " + this.ISBN + " - " + this.titolo + " Autore: " + this.autore + " - " + disp;
    }

    public void prestareLibro() {
        if(this.disponibile){
            this.disponibile = false;
            System.out.println("Libro " + this.titolo + " preso in prestito");
        } else {
            System.out.println("Libro non disponibile");
        }
    }

    public void restituireLibro() {
        if(!this.disponibile){
            this.disponibile = true;
            System.out.println("Libro " + this.titolo + " restituito");
        } else {
            System.out.println("Errore!!!");
        }
    }

}
