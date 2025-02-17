package Classes;

import Enumerations.Carburante;

public class Camion extends Veicolo {

    private double carico;

    public Camion(String marca, String modello, String colore, Carburante carburante, double carico) {
        super(marca, modello, colore, carburante);
        this.carico = carico;
    }

    public double getCarico() {
        return carico;
    }

    public void setCarico(double carico) {
        this.carico = carico;
    }

    @Override
    public void start() {
        System.out.println("Start Camion");
    }

    @Override
    public void stop() {
        System.out.println("Stop Camion");
    }

    @Override
    public String toString() {
        return super.toString() + " Carico: " + this.carico;
    }
}
