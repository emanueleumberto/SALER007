package Classes;

import Enumerations.Carburante;

public class Camper extends Veicolo {

    private int numPosti;

    public Camper(String marca, String modello, String colore, Carburante carburante, int numPosti) {
        super(marca, modello, colore, carburante);
        this.numPosti = numPosti;
    }

    public int getNumPosti() {
        return numPosti;
    }

    public void setNumPosti(int numPosti) {
        this.numPosti = numPosti;
    }
    @Override
    public void start() {
        System.out.println("Start Camper");
    }
    @Override
    public void stop() {
        System.out.println("Stop Camper");
    }

    @Override
    public String toString() {
        return super.toString() + " Numero Posti: " + this.numPosti;
    }
}
