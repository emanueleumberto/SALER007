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
        //int num = Integer.parseInt(sc.nextLine());
        int num = 3;
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


        // while(condizione) { blocco di istruzioni }
//        int i = 0;
//        while(i < 5) {
//            System.out.println(i);
//            //i = i + 1;
//            //i += 3;
//            i++;
//        }

//        int j = 0;
//        while(true) {
//            System.out.println(j);
//            j++;
//            if(j == 5) {
//                break;
//            }
//        }

        while(true) {
            System.out.println("Inserisci un numero oppure 0 per uscire");
            int n = Integer.parseInt(sc.nextLine());
            if(n == 0) {
                break;
            } else {
                System.out.println(n);
            }
        }

        // do{ blocco di istruzioni } while(condizione)

        String user;
        String pass;
        do {
            System.out.print("username: ");
            user = sc.nextLine();
            System.out.print("password: ");
            pass = sc.nextLine();
        } while (!user.equals("admin") || !pass.equals("admin"));

        System.out.println("FINE");

        // for(inizializzazione, condizione, incremento) { blocco di istruzioni }
        for(int y=0; y<10; y++) {
            System.out.println(y);
        }

//        for(int y=0; y<10; y++) {
//            //System.out.println(y);
//            if(y == 5) {
//                break;
//            }
//        }

//        for(;true;) {
//            System.out.println("Inserisci un numero oppure 0 per uscire");
//            int n = Integer.parseInt(sc.nextLine());
//            if(n == 0) {
//                break;
//            } else {
//                System.out.println(n);
//            }
//        }

        System.out.print("Inserisci un numero: ");
        int b = Integer.parseInt(sc.nextLine());
        for(int r=0; r<b; r++) {
            for(int c=0; c<=r; c++) {
                System.out.print('*');
            }
            System.out.println();
        }

    }



}
