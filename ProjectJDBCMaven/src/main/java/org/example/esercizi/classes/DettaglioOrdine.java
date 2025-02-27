package org.example.esercizi.classes;

public class DettaglioOrdine {

    private int id_dettaglio_ordine;
    private Prodotto prodotto;
    private int quantita;
    private double prezzo_unitario;

    public DettaglioOrdine(Prodotto prodotto, int quantita) {
        this.prodotto = prodotto;
        this.quantita = quantita;
        this.prezzo_unitario = prodotto.getPrezzo();
    }

    public DettaglioOrdine(int id_dettaglio_ordine, Prodotto prodotto, int quantita, double prezzo_unitario) {
        this.id_dettaglio_ordine = id_dettaglio_ordine;
        this.prodotto = prodotto;
        this.quantita = quantita;
        this.prezzo_unitario = prezzo_unitario;
    }

    public int getId_dettaglio_ordine() {
        return id_dettaglio_ordine;
    }

    public void setId_dettaglio_ordine(int id_dettaglio_ordine) {
        this.id_dettaglio_ordine = id_dettaglio_ordine;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double getPrezzo_unitario() {
        return prezzo_unitario;
    }

    public void setPrezzo_unitario(double prezzo_unitario) {
        this.prezzo_unitario = prezzo_unitario;
    }

    @Override
    public String toString() {
        return "DettaglioOrdine{" +
                "id_dettaglio_ordine=" + id_dettaglio_ordine +
                ", prodotto=" + prodotto +
                ", quantita=" + quantita +
                ", prezzo_unitario=" + prezzo_unitario +
                '}';
    }
}
