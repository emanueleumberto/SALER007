package com.example.gym_management.security.repository;

import com.example.gym_management.security.entity.ERole;
import com.example.gym_management.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
