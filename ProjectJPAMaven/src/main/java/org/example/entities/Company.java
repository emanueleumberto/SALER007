package org.example.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, name = "company_name")
    private String companyName;

    // Solo se voglio la relazione bidirezionale
    @OneToMany(mappedBy = "company")
    private List<User> employees;

}
