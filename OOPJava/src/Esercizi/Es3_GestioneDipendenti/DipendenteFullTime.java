package Esercizi.Es3_GestioneDipendenti;

public class DipendenteFullTime extends Dipendente {

    public DipendenteFullTime(String matricola, String nomeCompleto, Dipartimento dipartimento) {
        super(matricola, nomeCompleto, dipartimento);
    }

    public double calculateSalary() {
        return getStipendio();
    }

    @Override
    public String info() {
        /*return this.getMatricola() + " - "
                + this.getNomeCompleto() + " - "
                + this.getDipartimento() + " - " + calculateSalary();*/
        return super.info() + " - " + calculateSalary();
    }

    // Overloading
   /* public void test() {
        System.out.println("Sono il metodo test senza paramentri");
    }

    public void test(int n) {
        System.out.println("Sono il metodo test con un paramentro");
    }

    public void test(int n, String s) {
        System.out.println("Sono il metodo test con un paramentro");
    }

    public void test(String n) {
        System.out.println("Sono il metodo test con un paramentro");
    }

    public void test(String s, int n) {
        System.out.println("Sono il metodo test con un paramentro");
    }*/

}
