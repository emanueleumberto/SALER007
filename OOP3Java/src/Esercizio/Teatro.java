package Esercizio;

import java.util.Arrays;

public class Teatro {
    private String nome;
    private boolean[] posti;

    public Teatro(String nome, int numPosti) {
        this.nome = nome;
        this.posti = inizializzaPosti(numPosti);
    }

    public int getTotalePosti() {
        return this.posti.length;
    }

    public boolean[] inizializzaPosti(int numPosti) {
        boolean[] arr = new boolean[numPosti];
        for(int i=0; i< arr.length; i++) {
            arr[i] = false;
        }
        return arr;
    }

    public void prenotaPosto(int numeroPosto) throws PostoGiaOccupatoException, PostoNonValidoException {
        // Se la prenotazione è valida, segna il posto come occupato e conferma la prenotazione.
        if(!controlloPostiTeatro()) {
            System.out.println("Sold Out!!!");
        } else {
            if (numeroPosto <= 0 || numeroPosto - 1 > posti.length) {
                throw new PostoNonValidoException("Devi inserire un posto da 1 a " + (posti.length));
            } else {
                if (!posti[numeroPosto - 1]) {
                    posti[numeroPosto - 1] = true;
                    System.out.println("Prenotazione posto " + numeroPosto + " effettuata!");
                } else {
                    throw new PostoGiaOccupatoException("Posto n." + numeroPosto + " occupato");
                }
            }
        }
    }

    public boolean controlloPostiTeatro() {
        for (int i=0; i<posti.length; i++) {
            if(!posti[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Teatro: " + nome +", posti=" + Arrays.toString(posti);
    }
}
