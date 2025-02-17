package Esercizio;

import java.util.Scanner;

public class RiproduttoreMultimediale {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Audio a = new Audio("MiaCanzone", 4, 6);
        //a.play();

        Video v = new Video("MioVideo", 8, 6, 4);
        //v.play();

        Immagine im = new Immagine("MiaImmagine", 8);
        //i.show();

        ElementoMultimediale[] multimedia = new ElementoMultimediale[5];
        multimedia[0] = a;
        multimedia[1] = v;
        multimedia[2] = im;
        multimedia[3] = null;
        multimedia[4] = null;

        do {
            for (int i=0; i< multimedia.length; i++) {
                if(multimedia[i] != null) {
                    System.out.println(i + 1 + " - " + multimedia[i].getTitolo());
                } else {
                    System.out.println(i + 1 + " - Empty" );
                }
            }
            System.out.print("Quale Elemento multimediale vuoi riprodurre? oppure 0 per finire");
            int ele = Integer.parseInt(sc.nextLine());
            for (int i=0; i< multimedia.length; i++) {
                if(ele == 0) {return;}
                if(i+1 == ele) {
                    if(multimedia[i] != null) {
                        if(multimedia[i] instanceof ElementoRiproducibile) {
                            ElementoRiproducibile e = (ElementoRiproducibile) multimedia[i];
                            e.play();
                        } else if(multimedia[i] instanceof Immagine) {
                            Immagine imm = (Immagine) multimedia[i];
                            imm.show();
                        } else {
                            System.out.println("Elemento sconosciuto!!!");
                        }
                    } else {
                        System.out.println("Empty");
                    }
                }
            }
        } while(true);
    }
}
