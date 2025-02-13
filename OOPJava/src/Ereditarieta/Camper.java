package Ereditarieta;

public class Camper extends Veicolo {
    // è un > Camper è anche un veicolo?
    private int cilindrata;
    private int postiLetto;

    public Camper(String marca, String modello, String colore, int cilindrata, int postiLetto) {
        super(marca, modello, colore);
        this.cilindrata = cilindrata;
        this.postiLetto = postiLetto;
    }

    public int getCilindrata() { return this.cilindrata; }

    public int getPostiLetto() { return this.postiLetto; }

    public void setPostiLetto(int postiLetto) { this.postiLetto = postiLetto; }

    public String info() {
        return "Camper: "
                + this.getMarca() + " "  + this.getModello()
                + " Colore: " + this.getColore()
                + " Posti Letto: " + this.getPostiLetto()
                + " Cilindrata: " + this.getCilindrata() + "cc";
    }
}
