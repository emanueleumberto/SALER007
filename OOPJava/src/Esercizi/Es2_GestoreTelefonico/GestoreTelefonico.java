package Esercizi.Es2_GestoreTelefonico;

public class GestoreTelefonico {
    public static void main(String[] args) {
        Sim s1 = new Sim("+39 333.44.55.678", Gestore.VODAFONE);
        s1.caricaCredito(5);

        Chiamata c1 = new Chiamata("+39 345.99.88.765");
        s1.chiama(c1);

        Chiamata c2 = new Chiamata("+39 333.12.34.567");
        s1.chiama(c2);

        Chiamata c3 = new Chiamata("+39 328.98.76.543");
        s1.chiama(c3);

        s1.stampaSim();
    }
}
