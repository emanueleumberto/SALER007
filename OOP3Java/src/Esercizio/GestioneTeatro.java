package Esercizio;

import java.util.Scanner;

public class GestioneTeatro {
    public static void main(String[] args) {
        Teatro t1 = new Teatro("Petruzzelli", 10);
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("Quale posto vuoi prenotare? Inserisci un numero da 1 a " + t1.getTotalePosti() + ": ");
            int numPosto = sc.nextInt();
            try {
                t1.prenotaPosto(numPosto);
                // t1.prenotaPosto(3);  // Posto libero
                // t1.prenotaPosto(25); // Posto maggiore della capienza massima
                // t1.prenotaPosto(3);  // Posto occupato
                // t1.prenotaPosto(8);  // Posto libero
            } catch (PostoGiaOccupatoException e) {
                System.out.println(e.getMessage());
            } catch (PostoNonValidoException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println(t1);
            }
        }
    }
}
