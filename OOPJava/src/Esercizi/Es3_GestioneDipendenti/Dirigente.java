package Esercizi.Es3_GestioneDipendenti;

public class Dirigente extends Dipendente {

    public Dirigente(String matricola, String nomeCompleto) {
        super(matricola, nomeCompleto, Dipartimento.AMMINISTRAZIONE);
    }

    public double calculateSalary() {
        return getStipendio() * 2;
    }

    @Override
    public String info() {
        /*return this.getMatricola() + " - "
                + this.getNomeCompleto() + " - "
                + this.getDipartimento() + " - " + calculateSalary();*/
        return super.info() + " - " + calculateSalary();
    }

}
