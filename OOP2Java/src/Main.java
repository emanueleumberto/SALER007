import Classes.*;
import Enumerations.Carburante;
import Interfaces.Navigatore;

public class Main {
    public static void main(String[] args) {

        System.out.println("Veicolo creati: " + Veicolo.count);

        Automobile a1 = new Automobile("Fiat", "Panda", "Bianco", Carburante.GPL, 3);
        Moto m1 = new Moto("Honda", "Hornet", "Nero", Carburante.BENZINA, 800);
        Camper c1 = new Camper("Laika", "Camping", "Bianco", Carburante.DIESEL, 5);
        Automobile a2 = new Automobile("Ford", "Fiesta", "Rosso", Carburante.DIESEL, 3);
        Automobile a3 = new Automobile("Mercedes", "ClasseA", "Blu", Carburante.BENZINA, 5);
        Moto m2 = new Moto("Ducati", "Monster", "Rosso", Carburante.BENZINA, 1000);
        Camion k1 = new Camion("Iveco", "AB123", "Verde", Carburante.DIESEL, 1000);

        Veicolo v = new Automobile("Ferrari", "TestaRossa", "Nero", Carburante.BENZINA, 3);

        System.out.println("Veicolo creati: " + Veicolo.count);

        Veicolo[] arrVeicoli = new Veicolo[5];
        arrVeicoli[0] = a1;
        arrVeicoli[1] = m1;
        arrVeicoli[2] = c1;
        arrVeicoli[3] = a2;
        arrVeicoli[4] = k1;

        for (int i=0; i< arrVeicoli.length; i++) {
            System.out.println(arrVeicoli[i] + " - " + arrVeicoli.getClass());

            arrVeicoli[i].start();
            if(arrVeicoli[i] instanceof Automobile) {
                System.out.println("Sono un Automobile");
            } else if(arrVeicoli[i] instanceof Moto) {
                System.out.println("Sono una Moto");
            } else if(arrVeicoli[i] instanceof Camper) {
                System.out.println("Sono un Camper");
            }
        }

        Main m = new Main();
        m.metodoNonStatic();

        Main.metodoStatic();

        Navigatore[] arrNavigatore = new Navigatore[3];
        arrNavigatore[0] = a1;
        arrNavigatore[1] = new Smartphone();

        for (int i=0; i< arrNavigatore.length; i++) {
            arrNavigatore[i].aggiornaNavigatore();
        }


    }

    public void metodoNonStatic() {
        System.out.println("Sono un metodo di istanza!");
    }

    public static void metodoStatic() {
        System.out.println("Sono un metodo di classe!");
    }
}