package org.example.Esercizi;

public class Prodotto {

    private static int count = 0;
    private int id;
    private String nome;
    private String categoria;
    private double prezzo;
    private int quantitaDisponibile;

    public Prodotto(String nome, String categoria, double prezzo, int quantitaDisponibile) {
        this.id = ++count;
        this.nome = nome;
        this.categoria = categoria;
        this.prezzo = prezzo;
        this.quantitaDisponibile = quantitaDisponibile;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCategoria() { return categoria; }
    public double getPrezzo() { return prezzo; }
    public int getQuantitaDisponibile() { return quantitaDisponibile; }

    @Override
    public String toString() {
        return id + " nome='" + nome +  "(" + categoria + ")  €" + prezzo + " qt." + quantitaDisponibile;
    }
}
