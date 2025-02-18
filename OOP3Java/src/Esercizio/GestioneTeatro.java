package Esercizio;

import java.util.Scanner;

public class GestioneTeatro {
    public static void main(String[] args) {
        Teatro t1 = new Teatro("Petruzzelli", 10);
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("Quale posto vuoi prenotare? Inserisci un numero da 1 a " + t1.getTotalePosti() + ": ");

            try {
                int numPosto = Integer.parseInt(sc.nextLine());
                t1.prenotaPosto(numPosto);
                // t1.prenotaPosto(3);  // Posto libero
                // t1.prenotaPosto(25); // Posto maggiore della capienza massima
                // t1.prenotaPosto(3);  // Posto occupato
                // t1.prenotaPosto(8);  // Posto libero
            } catch (PostoGiaOccupatoException e) {
                System.out.println(e.getMessage());
            } catch (PostoNonValidoException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e){
                System.out.println("Devi inserire un valore numerico da da 1 a " + t1.getTotalePosti());
            } catch (Exception e) {
                System.out.println("Errore!!!");
            } finally {
                System.out.println(t1);
            }
        }
    }
}
