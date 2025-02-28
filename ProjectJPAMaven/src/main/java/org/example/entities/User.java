package org.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 50)
    private String fisrtname;
    @Column(nullable = false, length = 50)
    private String lastname;
    @Column(nullable = true)
    private Integer age;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    @Embedded
    private Address address;

    // Solo se voglio la relazione bidirezionale
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Passport passport;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

}
