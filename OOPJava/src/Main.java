import Esercizi.Es1_Rettangolo.Rettangolo;

public class Main {

    public static void main(String[] args) {

        // Una classe in java è un raggruppamento concettuale di oggetti
        // che hanno caratteristiche e comportamenti simili

        Automobile a1 = new Automobile("Fiat", "500L", 1200, "Bianco", CategoriaAutomobile.SUV);
//        Automobile a1 = new Automobile();
//        a1.marca = "Fiat";
//        a1.modello = "500L";
//        a1.cilindrata = 1200;
//        a1.colore = "Bianco";
        a1.targa = "AB123CD";
        a1.start();
        a1.info();
        System.out.println(a1);
        System.out.println("*********************************************");

        Automobile a2 = new Automobile("Ford", "Fiesta", 1500, "Nero", CategoriaAutomobile.UTILITARIA);
//        a2.marca = "Ford";
//        a2.modello = "Fiesta";
//        a2.cilindrata = 1500;
//        a2.colore = "Nero";
        a2.info();
        System.out.println(a2);
        System.out.println("*********************************************");

        // Non creo una copia di a2
        Automobile a3 = a2; // creo un puntatore alla zona di memoria dove è salvato a2
        a3.info();
        System.out.println(a3);
        a3 = null;
        a2 = null;
        System.out.println(a3);



        // Esercizi
        // Rettangolo
        Rettangolo r1 = new Rettangolo(5, 10 );
//        r1.altezza = 5;
//        r1.larghezza = 10;
//        r1.stampaRettangolo();

        Rettangolo r2 = new Rettangolo(150, 80);
//        r2.altezza = 150;
//        r2.larghezza = 80;
//        r2.stampaRettangolo();


        // I 4 pilastri fondamentali dei linguaggi OOP
        // -> Incapsulamento
        //      Ci permette di nasconere dettagli implementativi (membri definiti private) da una classe.
        // -> Ereditarietà
        //      Ci permette di ereditare in una classe figlia tutti i mebri della classe padre
        // -> Astrazione
        //      Ci permette di astrarre oggi troppo generici
        // -> Polimorfismo
        //      Ci permette di definire classe e oggetti che possono avere molteplici tipi

        // Incapsulamento OOP (Information Hiding)
        // public | private | protected | default o package
        Animal an1 = new Animal("Bobby", 2, "Dog", "--");
        an1.name = ""; // public
        an1.age = 0; // protected
        //an1.type = ""; // private
        an1.category = ""; // package

    }

}
