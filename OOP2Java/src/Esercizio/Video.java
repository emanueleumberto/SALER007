package Esercizio;

public class Video extends ElementoRiproducibile implements GestioneVolume, GestioneLuminosita {

    private int volume;
    private int luminosita;

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo, durata);
        this.volume = volume;
        this.luminosita = luminosita;
    }

    public int getVolume() {
        return volume;
    }

    public int getLuminosita() {
        return luminosita;
    }

    @Override
    public void play() {
        for(int i=0; i<this.getDurata(); i++) {
            System.out.println(this.getTitolo() +
                                "!".repeat(this.getVolume()) +
                                "*".repeat(this.getLuminosita()));
        }
    }

    @Override
    public void abbassaVolume() {
        // Istruzioni
        if(this.volume > 0) {
            this.volume--;
            System.out.println("Volume regolato " + this.volume);
        } else {
            System.out.println("Volume minimo raggiunto");
        }
    }

    @Override
    public void alzaVolume() {
        // Istruzioni
        if(this.volume < 10) {
            this.volume++;
            System.out.println("Volume regolato " + this.volume);
        } else {
            System.out.println("Volume massimo raggiunto");
        }
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
        return super.toString() + " Volume: " + this.volume + " Luminosità: " + this.luminosita;
    }
}
