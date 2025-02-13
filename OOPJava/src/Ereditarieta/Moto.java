package Ereditarieta;

public class Moto extends Veicolo {
    // è un > Moto è anche un veicolo?
    private int cilindrata;
    private boolean valigie;

    public Moto(String marca, String modello, String colore, int cilindrata) {
        super(marca, modello, colore);
        this.cilindrata = cilindrata;
        this.valigie = false;
    }

    public int getCilindrata() { return this.cilindrata; }

    public boolean isValigie() { return this.valigie; }

    public void setValigie(boolean valigie) { this.valigie = valigie; }

    public String info() {
        return "Moto: "
                + this.getMarca() + " "  + this.getModello()
                + " Colore: " + this.getColore()
                + " Valigie: " + this.isValigie()
                + " Cilindrata: " + this.getCilindrata() + "cc";
    }
}
