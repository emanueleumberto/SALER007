package Esercizi.Es2_GestoreTelefonico;

public class Chiamata {

    public double durataMinuti;
    public String numeroChiamato;

    public Chiamata(String numeroChiamato) {
        this.durataMinuti = generaDurataMinutiRandom();
        this.numeroChiamato = numeroChiamato;
    }

    public double generaDurataMinutiRandom() {
        double minuti = Math.random() * 10;
        return minuti;
    }

}
