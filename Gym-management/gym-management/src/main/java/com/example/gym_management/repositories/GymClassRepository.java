package com.example.gym_management.repositories;

import com.example.gym_management.models.GymClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymClassRepository extends JpaRepository<GymClass, Long> {

    List<GymClass> findByGymClassName(String gymClassName);

}
