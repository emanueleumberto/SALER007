package org.example.esercizio.entities;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "ordini")
@NamedQuery(name = "Ordine.findAll", query = "SELECT o FROM Ordine o")
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ordine;
    @Column(name = "data_ordine", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDate dataOrdine;

    @OneToOne(mappedBy = "ordine")
    private DettaglioOrdine dettaglio;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Ordine() { }

    public Ordine( Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getId_ordine() {
        return id_ordine;
    }

    public void setId_ordine(Integer id_ordine) {
        this.id_ordine = id_ordine;
    }

    public LocalDate getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(LocalDate dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public DettaglioOrdine getDettaglio() {
        return dettaglio;
    }

    public void setDettaglio(DettaglioOrdine dettaglio) {
        this.dettaglio = dettaglio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id_ordine=" + id_ordine +
                ", dataOrdine=" + dataOrdine +
                ", dettaglio=" + dettaglio +
                ", cliente=" + cliente +
                '}';
    }
}
