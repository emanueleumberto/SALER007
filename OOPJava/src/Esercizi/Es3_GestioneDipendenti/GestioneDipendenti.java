package Esercizi.Es3_GestioneDipendenti;

public class GestioneDipendenti {

    public static void main(String[] args) {
        Dipendente d1 = new Dipendente("0001", "Mario Rossi", Dipartimento.PRODUZIONE);
        Dipendente d2 = new Dipendente("0002", "Giuseppe Verdi", Dipartimento.AMMINISTRAZIONE);
        Dipendente d3 = new Dipendente("0003", "Francesca Neri", Dipartimento.VENDITE);

        System.out.println(d1.info());
        System.out.println(d2.info());
        System.out.println(d3.info());
    }

}
