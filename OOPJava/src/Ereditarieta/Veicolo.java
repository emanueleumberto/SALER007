package Ereditarieta;

public class Veicolo {

    private String marca;
    private String modello;
    private String colore;

    public Veicolo(String marca, String modello, String colore) {
        this.marca = marca;
        this.modello = modello;
        this.colore = colore;
    }

    public String getMarca() { return this.marca; }

    public String getModello() { return this.modello; }

    public String getColore() { return this.colore; }

    public void setColore(String colore) { this.colore = colore; }

}
