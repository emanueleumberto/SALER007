package Classes;

import Enumerations.Carburante;

public class Moto extends Veicolo {

    private int cilindrata;

    public Moto(String marca, String modello, String colore, Carburante carburante, int cilindrata) {
        super(marca, modello, colore, carburante);
        this.cilindrata = cilindrata;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    @Override
    public void start() {
        System.out.println("Start Moto");
    }
    @Override
    public void stop() {
        System.out.println("Stop Moto");
    }

    @Override
    public String toString() {
        return super.toString() + " Cilindrata: " + this.cilindrata;
    }
}
