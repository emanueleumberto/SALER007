package org.example.Esercizi.EsercizioBiblioteca;

public class Lettore {

    private static int count = 0;
    private int id;
    private String nome;
    private String email;

    public Lettore(String nome, String email) {
        this.id = ++count;
        this.nome = nome;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "id: " + id + ", nome: " + nome + ", email: " + email;
    }
}
