package Esercizio;

public abstract class ElementoRiproducibile extends ElementoMultimediale {

    private int durata;

    public ElementoRiproducibile(String titolo, int durata) {
        super(titolo);
        this.durata = durata;
    }

    public int getDurata() {
        return durata;
    }

    public abstract void play();

    @Override
    public String toString() {
        return super.toString() + " durata: " + this.durata;
    }
}
