package org.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
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
}
