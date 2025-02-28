package org.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    @JoinTable(
            name = "users_courses",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> coursesList = new ArrayList<Course>();


    public User() { }

    public User(String fisrtname, String lastname, Integer age, String email, String password, Address address) {
        this.fisrtname = fisrtname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getFisrtname() { return fisrtname; }
    public void setFisrtname(String fisrtname) { this.fisrtname = fisrtname; }
    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
    public Passport getPassport() { return passport; }
    public void setPassport(Passport passport) { this.passport = passport; }
    public Company getCompany() { return company; }
    public void setCompany(Company company) { this.company = company; }
    public List<Course> getCoursesList() { return coursesList; }
    public void setCoursesList(List<Course> coursesList) { this.coursesList = coursesList; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fisrtname='" + fisrtname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                ", passport=" + passport +
                ", company=" + company +
                ", coursesList=" + coursesList +
                '}';
    }
}
