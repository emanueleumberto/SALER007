import java.util.Scanner;

public class Esercizio1 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Soluzione Esercizi");

        // Implementare i seguenti metodi:
        int sum = somma();
        int dif = sottrai();
        int mol = moltiplica();
        int div = dividi();
        concatena(sum, dif, mol, div);
    }

    public static int somma() {
        // somma       -> Chiede ad un utente due numeri, li somma e ne restituisce il risultato
        //Scanner sc = new Scanner(System.in);
        System.out.print("Inserisci un numero da sommare: ");
        int num1 = Integer.parseInt(sc.nextLine());
        System.out.print("Inserisci un secondo numero: ");
        int num2 = Integer.parseInt(sc.nextLine());
        int s = num1 + num2;
        return s;
    }

    public static int sottrai() {
        // sottrai     -> Chiede ad un utente due numeri, li sottrae e ne restituisce il risultato
        //Scanner sc = new Scanner(System.in);
        System.out.print("Inserisci un numero da sottrarre: ");
        int num1 = Integer.parseInt(sc.nextLine());
        System.out.print("Inserisci un secondo numero: ");
        int num2 = Integer.parseInt(sc.nextLine());
        int s = num1 - num2;
        return s;
    }

    public static int moltiplica() {
        // moltiplica  -> Chiede ad un utente due numeri, li moltiplica e ne restituisce il risultato
        //Scanner sc = new Scanner(System.in);
        System.out.print("Inserisci un numero da moltiplicare: ");
        int num1 = Integer.parseInt(sc.nextLine());
        System.out.print("Inserisci un secondo numero: ");
        int num2 = Integer.parseInt(sc.nextLine());
        int s = num1 * num2;
        return s;
    }

    public static int dividi() {
        // dividi      -> Chiede ad un utente due numeri, li divide e ne restituisce il risultato
        //Scanner sc = new Scanner(System.in);
        System.out.print("Inserisci un numero da dividere: ");
        int num1 = Integer.parseInt(sc.nextLine());
        System.out.print("Inserisci un secondo numero: ");
        int num2 = Integer.parseInt(sc.nextLine());
        int s = num1 / num2;
        return s;
    }

    public static void concatena(int s, int d, int m, int dv) {
        //concatena   -> Prende in ingresso 4 valori (somma, moltiplica, sotttrai, dividi)
        // e stampa nel terminale una stringa con tutti i valori calcolati dai metodi precedenti
        System.out.println("Risultati dei calcoli precedenti: ");
        System.out.println("  - Somma: " + s);
        System.out.println("  - Differenza " + d);
        System.out.println("  - Moltiplica " + m);
        System.out.println("  - Dividi: " + dv);
    }
}
