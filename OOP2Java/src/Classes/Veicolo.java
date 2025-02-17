package Classes;

import Enumerations.Carburante;

public abstract class Veicolo {

    private String marca;
    private String modello;
    private String colore;
    private Carburante carburante;
    public static int count = 0;

    public Veicolo(String marca, String modello, String colore, Carburante carburante) {
        this.marca = marca;
        this.modello = modello;
        this.colore = colore;
        this.carburante = carburante;
        count++;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public String getColore() {
        return colore;
    }

    public Carburante getCarburante() {
        return carburante;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public abstract void start();

    public abstract void stop();

    @Override
    public String toString() {
        return  this.marca + " " + modello + ", colore: " + colore + " carburante: " + carburante ;
    }
}
