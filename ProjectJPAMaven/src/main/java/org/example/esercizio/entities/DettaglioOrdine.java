package org.example.esercizio.entities;

import javax.persistence.*;

@Entity
@Table(name = "dettagli_ordini")
public class DettaglioOrdine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_dettagli_ordini;
    @Column(nullable = false)
    private Integer quantità;
    @Column(nullable = false)
    private Double prezzo_unitario;

    @OneToOne
    @JoinColumn(name = "id_ordine")
    private Ordine ordine;

    @ManyToOne
    @JoinColumn(name = "id_prodotto")
    private Prodotto prodotto;

    public DettaglioOrdine() { }

    public DettaglioOrdine(Integer quantità, Ordine ordine, Prodotto prodotto) {
        this.quantità = quantità;
        this.prezzo_unitario = prodotto.getPrezzo();
        this.ordine = ordine;
        this.prodotto = prodotto;
    }

    public Integer getId_dettagli_ordini() {
        return id_dettagli_ordini;
    }

    public void setId_dettagli_ordini(Integer id_dettagli_ordini) {
        this.id_dettagli_ordini = id_dettagli_ordini;
    }

    public Integer getQuantità() {
        return quantità;
    }

    public void setQuantità(Integer quantità) {
        this.quantità = quantità;
    }

    public Double getPrezzo_unitario() {
        return prezzo_unitario;
    }

    public void setPrezzo_unitario(Double prezzo_unitario) {
        this.prezzo_unitario = prezzo_unitario;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    @Override
    public String toString() {
        return "DettaglioOrdine{" +
                "id_dettagli_ordini=" + id_dettagli_ordini +
                ", quantità=" + quantità +
                ", prezzo_unitario=" + prezzo_unitario +
                ", prodotto=" + prodotto +
                '}';
    }
}
