import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("Hello World");

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Inserisci Due numeri da calcolare:");
            System.out.print("Inserisci il primo numero: ");
            try {
                int n1 = Integer.parseInt(sc.nextLine());
                System.out.print("Inserisci il secondo numero: ");
                int n2 = Integer.parseInt(sc.nextLine());
                calcolaValori(n1, n2);
            } catch (NumberFormatException e) {
                System.out.println("Devi inserire un numero!!!");
            } catch (ArithmeticException e) {
                System.out.println("Non puoi dividere per 0");
            } catch (MoltiplicazionePerDieciException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Errore!!!!");
            } finally {
                // Le istruzioni inserite in questo blocco
                // vengono sempre eseguite
                System.out.println("Finally");
            }
        }

        /*calcolaValori(10, 5);
        calcolaValori(10, 0);
        calcolaValori(5, 10);*/
        /*try {
            calcolaValori(10, 5);
            calcolaValori(10, 0);
            calcolaValori(5, 10);
        } catch (Exception e) {
            System.out.println("Programma in errore!!!");
        }*/



    }

    public static void calcolaValori(int x, int y) throws MoltiplicazionePerDieciException {
        Test t = new Test(x, y);
        if(t.moltiplicazione() == 10) {
            throw new MoltiplicazionePerDieciException("Non puoi avere come risultato 10");
        }
        System.out.println(t);
        /*try {
            System.out.println(t);
        } catch (Exception e) {
            System.out.println("Errore!!!");
        }*/
    }
}
