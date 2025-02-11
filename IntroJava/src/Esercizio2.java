import java.time.LocalDate;
import java.util.Scanner;

public class Esercizio2 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Scrivere i seguenti metodi:
        // Esercizio 1 IF-ELSE
        //boolean strBool = stringaPariDispari();
        //System.out.println(strBool);

        // Esercizio 2.1 IF-ELSE
        //boolean bisBool = annoBisestile();
        //System.out.println(bisBool);

        // Esercizio 2.2 IF-ELSE
        //LocalDate now = LocalDate.now();
        //System.out.println(now.getYear());
        //boolean bisBool = annoBisestile(now.getYear());
        //System.out.println(bisBool);

    }

    // Esercizio 1 IF-ELSE
    public static boolean stringaPariDispari() {
        System.out.print("Inserisci un testo: ");
        String testo = sc.nextLine();
        System.out.println("Lunghezza del testo: " + testo.length());
        if(testo.length() % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Esercizio 2.1 IF-ELSE
    public static boolean annoBisestile() {
        System.out.print("Inserisci un anno: ");
        int anno = Integer.parseInt(sc.nextLine());
        // (Per essere un anno bisestile deve essere divisibile per 4,
        // qualora sia divisibile per 100 deve essere anche divisibile per 400)
        if(anno % 400 == 0) {
            return true;
        } else if(anno % 4 == 0 && anno % 100 != 0) {
            return true;
        } else {
            return false;
        }

    }

    // Esercizio 2.2 IF-ELSE
    public static boolean annoBisestile(int anno) {
        if(anno % 400 == 0) {
            return true;
        } else if(anno % 4 == 0 && anno % 100 != 0) {
            return true;
        } else {
            return false;
        }

    }
}
