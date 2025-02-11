public class AutomobileMain {

    public static void main(String[] args) {
        Automobile panda = new Automobile();
        panda.marca = "Fiat";
        panda.modello = "Panda";
        panda.cilindrata = 1000;
        panda.colore = "Bianco";
        panda.start();

        System.out.println(panda.motoreAcceso);

        Automobile panda2 = new Automobile();
        panda2.marca = "Fiat";
        panda2.modello = "Panda";
        panda2.cilindrata = 1000;
        panda2.colore = "Bianco";

        System.out.println(panda2.motoreAcceso);
    }

}
