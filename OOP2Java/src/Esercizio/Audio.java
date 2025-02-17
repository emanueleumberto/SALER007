package Esercizio;

public class Audio extends ElementoRiproducibile implements GestioneVolume {

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
        /*for(int i=0; i<this.getDurata(); i++) {
            System.out.print(this.getTitolo());
            for (int j=0; j<this.getVolume(); j++){
                System.out.print("!");
            }
            System.out.println();
        }*/
        for(int i=0; i<this.getDurata(); i++) {
            System.out.println(this.getTitolo() + "!".repeat(this.getVolume()));
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
        } else {
            System.out.println("Volume massimo raggiunto");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " Volume: " + this.volume;
    }


}
