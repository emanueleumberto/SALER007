package Esercizi.Es3_GestioneDipendenti;

public class Dipendente {

    private String matricola;
    private String nomeCompleto;
    private double stipendioBase;
    private double stipendio;
    private Dipartimento dipartimento;

    public Dipendente(String matricola, String nomeCompleto, Dipartimento dipartimento) {
        this.matricola = matricola;
        this.nomeCompleto = nomeCompleto;
        this.dipartimento = dipartimento;
        this.stipendioBase = 1200.00;
        this.stipendio = calcolaStipendio();
    }

    public double calcolaStipendio() {
        if(this.dipartimento.equals(Dipartimento.PRODUZIONE)) {
            return this.stipendioBase + (this.stipendioBase * 0.2);
        } else if(this.dipartimento.equals(Dipartimento.AMMINISTRAZIONE)) {
            return this.stipendioBase + (this.stipendioBase * 0.6);
        } else if(this.dipartimento.equals(Dipartimento.VENDITE)) {
            return this.stipendioBase + (this.stipendioBase * 0.4);
        } else {
            return this.stipendioBase;
        }
    }

    public String getMatricola() { return this.matricola; }
    public String getNomeCompleto() { return this.nomeCompleto; }
    public double getStipendioBase() { return this.stipendioBase; }
    public double getStipendio() { return this.stipendio; }

    public Dipartimento getDipartimento() { return dipartimento; }
    public void setDipartimento(Dipartimento dipartimento) { this.dipartimento = dipartimento; }

    public String info() {
        return this.matricola + " - " + this.nomeCompleto + " - " + this.dipartimento + " - " + this.stipendio;
    }
}
