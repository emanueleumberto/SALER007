public class Automobile {

    // Attributi o Proprietà di istanza
    public String marca;
    public String modello;
    public int cilindrata;
    public String colore;
    public boolean motoreAcceso;
    public String targa;

    // metodo costruttore
    public Automobile(String marca, String modello, int cilindrata, String colore) {
        this.marca = marca;
        this.modello = modello;
        this.cilindrata = cilindrata;
        this.colore = colore;
        this.motoreAcceso = false;
    }

    // metodi di istanza
    public void start() {
        this.motoreAcceso = true;
        System.out.println("Start " + this.marca + " " + this.modello);
    }

    public void stop() {
        this.motoreAcceso = true;
        System.out.println("Stop " + this.marca + " " + this.modello);
    }

    public void info() {
        System.out.println("Automobile: " + this.marca + " " + this.modello);
        System.out.println("Cilindrata: " + this.cilindrata + "cc");
        System.out.println("Colore: " + this.colore);
        System.out.println("Targa: " + this.targa);
        if(this.motoreAcceso) {
            System.out.println("Motore Acceso");
        } else {
            System.out.println("Motore Spento");
        }
    }

}
