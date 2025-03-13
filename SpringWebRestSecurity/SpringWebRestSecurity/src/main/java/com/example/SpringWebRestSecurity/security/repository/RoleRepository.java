package com.example.SpringWebRestSecurity.security.repository;



import com.example.SpringWebRestSecurity.security.entity.ERole;
import com.example.SpringWebRestSecurity.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
