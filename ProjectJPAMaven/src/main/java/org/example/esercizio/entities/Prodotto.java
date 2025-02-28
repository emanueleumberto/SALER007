package org.example.esercizio.entities;

import javax.persistence.*;

@Entity
@Table(name = "prodotti")
@NamedQuery(name = "Prodotto.findAll", query = "SELECT p FROM Prodotto p")
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_prodotto;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = true)
    private String descrizione;
    @Column(nullable = false)
    private Double prezzo;
    @Column(nullable = false)
    private Integer quantità_disponibile;

    public Prodotto() { }

    public Prodotto(String nome, String descrizione, Double prezzo, Integer quantità_disponibile) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.quantità_disponibile = quantità_disponibile;
    }

    public Integer getId_prodotto() {
        return id_prodotto;
    }

    public void setId_prodotto(Integer id_prodotto) {
        this.id_prodotto = id_prodotto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public Integer getQuantità_disponibile() {
        return quantità_disponibile;
    }

    public void setQuantità_disponibile(Integer quantità_disponibile) {
        this.quantità_disponibile = quantità_disponibile;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "id_prodotto=" + id_prodotto +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", prezzo=" + prezzo +
                ", quantità_disponibile=" + quantità_disponibile +
                '}';
    }
}
