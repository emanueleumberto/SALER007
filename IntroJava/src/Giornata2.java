import java.util.Scanner;

public class Giornata2 {

    public static void main(String[] args) {

        // Algoritmi e strutture di controllo
        // IF ELSE - SWITCH
        // FOR - WHILE

        // if(condizione) { blocco di istruzioni }
        // if(condizione) { blocco di istruzioni } else { blocco di istruzioni }
        // if(condizione) { blocco di istruzioni }
        //      else if(condizione) { blocco di istruzioni }
        //      else if(condizione) { blocco di istruzioni }
        //      else if(condizione) { blocco di istruzioni }
        //      else { blocco di istruzioni }

        int x = -10;
        if (x > 0) {
            System.out.println("x > 0");
        } else if(x == 0) {
            System.out.println("x = 0");
        } else {
            System.out.println("x < 0");
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Inserisci il tuo nome ");
        //String name = sc.nextLine();
        String name = "Mario";
        if(name.length() < 2) {
            System.out.println("Inserisci un nome corretto");
        } else if(name.length() >= 2 && name.length() < 5) {
            System.out.println("Controlla i valori inseriti");
        } else {
            System.out.println("Ciao " + name);
        }


        // switch(espressione) {
        //      case 1:
        //          blocco di istruzione
        //      case 2:
        //          blocco di istruzione
        //      ...
        //      default:
        //          blocco di istruzione
        // }

        System.out.print("Inserisci un numero: ");
        int num = Integer.parseInt(sc.nextLine());
        switch (num) {
            case 0:
                System.out.println("Zero");
                break;
            case 1:
                System.out.println("Uno");
                break;
            case 2:
                System.out.println("Due");
                break;
            case 3:
                System.out.println("Tre");
                break;
            default:
                System.out.println("Hai inserito un valore errato");
        }



        System.out.println("FINE");

    }

}
