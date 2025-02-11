public class Automobile {

    // Una classe è un raggruppamento concettuale
    // che definisce le caratteristiche condivise tra tutti gli oggetti

    // Membri di una classe

    // Attributi o proprietà di istanza
    public String marca;
    public String modello;
    public int cilindrata;
    public String colore;
    public boolean motoreAcceso = false;

    // Metodi di istanza
    public void start() {
        motoreAcceso = true;
        System.out.println("Start auto!");
    }
    public void stop() {
        motoreAcceso = false;
        System.out.println("Stop auto!");
    }


}
