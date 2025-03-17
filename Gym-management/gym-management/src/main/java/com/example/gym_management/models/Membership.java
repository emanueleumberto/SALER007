package com.example.gym_management.models;

import com.example.gym_management.enumerations.MembershipType;
import com.example.gym_management.security.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "meberships")
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MembershipType type;
    @Column(nullable = false)
    private LocalDate startMembership;
    @Column(nullable = false)
    private LocalDate endMembership;
    @Column(nullable = false)
    private boolean active;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false, unique = true)
    private User user;

}
