import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Giornata1 {
    public static void main(String[] args) {

        // Commenti a riga singola

        /*
            Commenti
            multi
            riga
         */

        /**
         *
         *  JavaDOC
         */

        // Variabili Primitive
        // boolean  -> 1-bit
        // char     -> 8-bit
        // byte     -> 8-bit -> -128 a 127
        // short    -> 16-bit -> -2'15 a 2'15 -1
        // int      -> 32-bit
        // long     -> 64-bit
        // float    -> 32-bit
        // double   -> 64-bit

        // Riservo una zona di memoria e la chiamo x
        // type name = value;
        int x = 10;
        System.out.println(x);
        boolean y = true;

        int a;
        a = 25;
        a = 11;

        // costante
        final char c = 'C';
        //c = 'D'; --> Errore

        String s = "Ciao a tutti";
        System.out.println(s.length());

        // Java è un linguaggio a tipizzazione forte
        // Conversione tra dati dello stesso tipo -> Casting
        int num1 = 25;
        long num2 = num1; // Conversione implicita
        short num3 = (short) num1; // Conversione esplicita

        double d = 25.5;
        int nd = (int) d; // 25

        char cc = (char) nd;
        int ccc = 'h';
        System.out.println(ccc);


        // Conversione tra dati di tipo diverso -> Parsing
        String txt = "25";
        int n = Integer.parseInt(txt);
        double dd = Double.parseDouble(txt);
        short ss = Short.parseShort(txt);

        // Array
        int[] arrNum = new int[3];
        // [(0)-(1)-(2)]
        arrNum[0] = 10;
        arrNum[1] = 20;
        arrNum[2] = 30;

        System.out.println(arrNum[1]);

        // Operatori
        // Aritmetici -> + - * / %
        int x1 = 10;
        int x2 = 3;
        int div = x1 / x2;
        int res = x1 % x2;
        System.out.println(div + " - " + res);
        // Relazionali -> > < >= <= == !=
        // Logici -> && || !

        // true && true  -> true
        // true && false -> false
        // false && true -> false
        // false && false -> false

        // true || true  -> true
        // true || false -> true
        // false || true -> true
        // false || false -> false

        // !true -> false
        // !false -> true

        int j1 = 25;
        int j2 = 50;
        int j3 = 75;
        int j4 = 100;
        boolean t = (j1 != j2) || (j3 > j4) ;
        System.out.println(!t);

        //int r = somma(5, 9);
        //somma(r,50);

        // Scanner
        Scanner sc = new Scanner(System.in);
        System.out.print("Inserisci un numero: ");
        int h1 = sc.nextInt();
        System.out.print("Inserisci un secondo numero: ");
        int h2 = sc.nextInt();
        //System.out.println(h1 + " - " + h2);
        int hr = somma(h1, h2);
        System.out.println("La somma dei numeri " + h1 + " e " + h2 + " è: " + hr);

    }

    // returnType methodName(argType argName) { // blocco di istruzioni }
    public static int somma(int x, int y) {
        int result = x + y;
        //System.out.println(result);
        return result;
    }

}