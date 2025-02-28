package org.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, name = "course_name")
    private String name;
    @Column(nullable = true, name = "course_hour")
    private int hour;

    // Solo se voglio la relazione bidirezionale
    @ManyToMany(mappedBy = "coursesList")
    private List<User> userList = new ArrayList<User>();

    public Course() { }

    public Course(String name, int hour) {
        this.name = name;
        this.hour = hour;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getHour() { return hour; }
    public void setHour(int hour) { this.hour = hour; }
    public List<User> getUserList() { return userList; }
    public void setUserList(List<User> userList) { this.userList = userList; }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hour=" + hour +
                //", userList=" + userList + // da un problema di overflow
                '}';
    }
}
