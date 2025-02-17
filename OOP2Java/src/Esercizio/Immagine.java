package Esercizio;

public class Immagine extends ElementoMultimediale implements GestioneLuminosita {

    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    public int getLuminosita() {
        return luminosita;
    }

    public void show() {
        System.out.println(this.getTitolo() + "*".repeat(this.luminosita));
    }

    @Override
    public void aumentaLuminosita() {
        if(this.luminosita < 10) {
            this.luminosita++;
            System.out.println("Luminosità regolata " + this.luminosita);
        } else {
            System.out.println("Luminosità massima raggiunta");
        }
    }

    @Override
    public void diminuisciLuminosita() {
        if(this.luminosita > 0) {
            this.luminosita--;
            System.out.println("Luminosità regolata " + this.luminosita);
        } else {
            System.out.println("Luminosità minima raggiunta");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " Luminosità: " + this.luminosita;
    }
}
