package org.example.entities;

import javax.persistence.*;

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


}
