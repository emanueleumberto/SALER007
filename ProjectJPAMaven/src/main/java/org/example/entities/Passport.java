package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "passports")
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


}
