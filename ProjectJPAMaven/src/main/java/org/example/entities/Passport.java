package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "passports")
@NamedQuery(name = "Passport.findAll", query = "SELECT p FROM Passport p")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String numberPassport;
    @Column(nullable = false)
    private LocalDate datePassport;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Passport() { }

    public Passport(String numberPassport, LocalDate datePassport, User user) {
        this.numberPassport = numberPassport;
        this.datePassport = datePassport;
        this.user = user;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNumberPassport() { return numberPassport; }
    public void setNumberPassport(String numberPassport) { this.numberPassport = numberPassport; }
    public LocalDate getDatePassport() { return datePassport; }
    public void setDatePassport(LocalDate datePassport) { this.datePassport = datePassport; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", numberPassport='" + numberPassport + '\'' +
                ", datePassport=" + datePassport +
                //", user=" + user + // da un problema di overflow
                '}';
    }
}
