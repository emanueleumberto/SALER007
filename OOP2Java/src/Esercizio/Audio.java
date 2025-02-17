package Esercizio;

public class Audio extends ElementoRiproducibile {

    private int volume;

    public Audio(String titolo, int durata, int volume) {
        super(titolo, durata);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public void play() {
        // Istruzioni
    }

    @Override
    public String toString() {
        return super.toString() + " Volume: " + this.volume;
    }
}
