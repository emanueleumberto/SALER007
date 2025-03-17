package com.example.gym_management.models;

import com.example.gym_management.security.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "gym_classes")
public class GymClass {

    // Classi di Allenamento (Gym Classes)
    // I Corsi hanno un istruttore assegnato.
    // Gli utenti possono prenotarsi alle classi disponibili.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String gymClassName;
    @Column(nullable = false)
    private LocalTime startTime;
    @Column(nullable = false)
    private LocalTime endTime;
    @Column(nullable = false)
    private Integer numClientMax;

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    private User instructor;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "bookings",
            joinColumns = @JoinColumn(name = "gym_class_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> gymClassClients = new ArrayList<>();

}
