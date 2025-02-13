package Ereditarieta;

public class Automobile extends Veicolo {
    // è un > Automobile è anche un veicolo?
    private int cilindrata;
    private int numPorte;

    public Automobile(String marca, String modello, String colore, int cilindrata, int numPorte) {
        super(marca, modello, colore);
        this.cilindrata = cilindrata;
        this.numPorte = numPorte;
    }

    public int getCilindrata() { return this.cilindrata; }

    public int getNumPorte() { return this.numPorte; }

    public String info() {
        return "Automobile: "
                + this.getMarca() + " "  + this.getModello()
                + " Colore: " + this.getColore()
                + " Porte: " + this.getNumPorte()
                + " Cilindrata: " + this.getCilindrata() + "cc";
    }
}
