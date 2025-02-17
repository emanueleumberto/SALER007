package Classes;

import Enumerations.Carburante;
import Interfaces.Navigatore;

public class Automobile extends Veicolo implements Navigatore {

    private int numPorte;

    public Automobile(String marca, String modello, String colore, Carburante carburante, int numPorte) {
        super(marca, modello, colore, carburante);
        this.numPorte = numPorte;
    }

    public int getNumPorte() {
        return numPorte;
    }
    @Override
    public void start() {
        System.out.println("Start Auto");
    }
    @Override
    public void stop() {
        System.out.println("Stop Auto");
    }

    @Override
    public String toString() {
        return super.toString() + " numPorte: " + this.numPorte;
    }

    @Override
    public void startNavigatore() {

    }

    @Override
    public void stopNavigatore() {

    }

    @Override
    public void aggiornaNavigatore() {

    }
}
