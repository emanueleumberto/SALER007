package Esercizi;

public class Rettangolo {

    public double altezza;
    public double larghezza;

    public Rettangolo(double altezza, double larghezza) {
        this.altezza = altezza;
        this.larghezza = larghezza;
    }

    public double calcolaPerimetro() {
        return (this.altezza*2) + (this.larghezza*2);
    }

    public double calcolaArea() {
        return this.larghezza * this.altezza;
    }

    public void stampaRettangolo() {
        System.out.println("Larghezza: " + this.larghezza);
        System.out.println("Altezza: " + this.altezza);
        System.out.println("Perimetro: " + this.calcolaPerimetro());
        System.out.println("Area: " + this.calcolaArea());
    }
}
