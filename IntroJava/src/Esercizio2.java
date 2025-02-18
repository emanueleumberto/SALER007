import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
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
        LocalDate now = LocalDate.now();
        //System.out.println(now.getYear());
        //boolean bisBool = annoBisestile(now.getYear());
        //System.out.println(bisBool);

        // Esercizio 3.1 SWITCH
        //String d = stampaMese(now);
        // Esercizio 3.2 SWITCH
        //String s = stampaStagione(now);
        //System.out.println("Oggi è il giorno: " + d + " (" + s + ")");

        // Esercizio 4.1 WHILE
        //String testo = inserisciStringa();
        //System.out.println(testo);
        // Esercizio 4.2 WHILE
        //suddividiStringa("Ciao");

        // Esercizio 5.1 FOR
        //contoAllRovescia();
        // Esercizio 5.2 FOR
        popolaArray();
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

    // Esercizio 3.1 SWITCH
    public static String stampaMese(LocalDate date) {
        //System.out.println(date);
        int m = date.getMonthValue();
        int day = date.getDayOfMonth();
        int year = date.getYear();
        String month = "";
        switch (m) {
            case 1: { month = "Gennaio"; break; }
            case 2: { month = "Febbraio"; break; }
            case 3: { month = "Marzo"; break; }
            case 4: { month = "Aprile"; break; }
            default: { break; }
        }

        //System.out.println(day + "-" + month + "-" + year);
        return day + "-" + month + "-" + year;

//        String month2 = "";
//        switch (m) {
//            case 1 -> month2 = "Gennaio";
//            case 2 -> month2 = "Febbraio";
//            case 3 -> month2 = "Marzo";
//            case 4 -> month2 = "Aprile";
//            default -> month2 = "----";
//        }

//        String month3 = switch(m) {
//                case 1 -> "Gennaio";
//                case 2 -> "Febbraio";
//                case 3 -> "Marzo";
//                case 4 -> "Aprile";
//                default -> "----";
//        };

    }

    // Esercizio 3.2 SWITCH
    public static String stampaStagione(LocalDate date) {
        int m = date.getMonthValue();
        String stagione = switch(m) {
                case 12, 1, 2 -> "Inverno";
                case 3, 4, 5 -> "Primavera";
                case 6, 7, 8 -> "Estate";
                case 9, 10, 11 -> "Autunno";
                default -> "----";
        };
        //System.out.println("La stagione attuale è " + stagione);
        return stagione;
    }

    // Esercizio 4.1 WHILE
    public static String inserisciStringa() {
        String str;
        do {
            System.out.print("Inserisci una stringa di almeno 5 caratteri: ");
            str = sc.nextLine();
        } while (str.length() < 5);
        return str;
    }

    // Esercizio 4.2 WHILE
    public static void suddividiStringa(String str) {
        //String[] strSplit =  str.split("");
        int i = 0;
        String testo = "";
        while(i<str.length()) {
            if(i == str.length()-1) {
                testo += str.charAt(i);
                // testo += strSplit[i];
            } else {
                testo += str.charAt(i) + ",";
                // testo += strSplit[i] + ",";
            }
            i++;
        }
        System.out.println(testo);
    }

    // Esercizio 5.1 FOR
    public static void contoAllRovescia() {
        System.out.print("Inserisci un numero: ");
        int num = Integer.parseInt(sc.nextLine());
        for(int i=num; i>=0; i--) {
            System.out.println(i + "/" + num);
        }
    }

    // Esercizio 5.2 FOR
    public static void popolaArray() {
        System.out.print("Inserisci la lunghezza di un array: ");
        int pos = Integer.parseInt(sc.nextLine());
        String[] arrStr = new String[pos];
        for(int i=0; i< arrStr.length; i++) {
            arrStr[i] = inserisciStringa();
        }
        System.out.println(Arrays.toString(arrStr));
        for(int i=0; i< arrStr.length; i++) {
            suddividiStringa(arrStr[i]);
        }
    }
}
