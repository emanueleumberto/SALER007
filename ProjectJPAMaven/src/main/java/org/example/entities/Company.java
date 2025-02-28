package org.example.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
@NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, name = "company_name")
    private String companyName;

    // Solo se voglio la relazione bidirezionale
    @OneToMany(mappedBy = "company")
    private List<User> employees;

    public Company() { }

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public List<User> getEmployees() { return employees; }
    public void setEmployees(List<User> employees) { this.employees = employees; }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                //", employees=" + employees + // da un problema di overflow
                '}';
    }
}
