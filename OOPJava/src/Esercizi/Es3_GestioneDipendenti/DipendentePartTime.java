package Esercizi.Es3_GestioneDipendenti;

public class DipendentePartTime extends Dipendente {

    public DipendentePartTime(String matricola, String nomeCompleto, Dipartimento dipartimento) {
        super(matricola, nomeCompleto, dipartimento);
    }

    public double calculateSalary() {
        return getStipendio() - (getStipendio() * 0.4);
    }

    @Override
    public String info() {
        /*return this.getMatricola() + " - "
                + this.getNomeCompleto() + " - "
                + this.getDipartimento() + " - " + calculateSalary();*/
        return super.info() + " - " + calculateSalary();
    }

}
