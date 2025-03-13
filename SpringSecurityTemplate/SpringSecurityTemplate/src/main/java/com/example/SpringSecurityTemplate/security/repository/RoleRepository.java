package com.example.SpringSecurityTemplate.security.repository;

import com.example.SpringSecurityTemplate.security.entity.ERole;
import com.example.SpringSecurityTemplate.security.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
