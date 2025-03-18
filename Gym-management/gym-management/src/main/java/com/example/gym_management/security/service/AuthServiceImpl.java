package com.example.gym_management.security.service;

import java.util.HashSet;
import java.util.Set;

import com.example.gym_management.security.entity.ERole;
import com.example.gym_management.security.entity.Role;
import com.example.gym_management.security.entity.User;
import com.example.gym_management.security.exception.MyAPIException;
import com.example.gym_management.security.payload.LoginDto;
import com.example.gym_management.security.payload.RegisterDto;
import com.example.gym_management.security.payload.UpdateRoleUserDTO;
import com.example.gym_management.security.repository.RoleRepository;
import com.example.gym_management.security.repository.UserRepository;
import com.example.gym_management.security.security.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;


    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String login(LoginDto loginDto) {
        
    	Authentication authentication = authenticationManager.authenticate(
        		new UsernamePasswordAuthenticationToken(
        				loginDto.getUsername(), loginDto.getPassword()
        		)
        ); 
    	System.out.println(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);
        System.out.println(token);
        return token;
    }

    @Override
    public String register(RegisterDto registerDto) {

        // add check for username exists in database
        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new MyAPIException(HttpStatus.BAD_REQUEST, "Username is already exists!.");
        }

        // add check for email exists in database
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new MyAPIException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
      if(registerDto.getRoles() != null) {
	        registerDto.getRoles().forEach(role -> {
	        	Role userRole = roleRepository.findByRoleName(getRole(role)).get();
	        	roles.add(userRole);
	        });
        } else {
        	Role userRole = roleRepository.findByRoleName(ERole.ROLE_CLIENT).get();
        	roles.add(userRole);
        }
        
        user.setRoles(roles);
        System.out.println(user);
        userRepository.save(user);

        return "User registered successfully!.";
    }

    @Override
    public String updateRoleUser(Long userId, UpdateRoleUserDTO updateRoleUserDTO) {
        User user = userRepository.findById(userId).get();
        Set<Role> roles = new HashSet<>();
        if(updateRoleUserDTO.getRoles() != null) {
            updateRoleUserDTO.getRoles().forEach(role -> {
                Role userRole = roleRepository.findByRoleName(getRole(role)).get();
                roles.add(userRole);
            });
        } else {
            Role userRole = roleRepository.findByRoleName(ERole.ROLE_CLIENT).get();
            roles.add(userRole);
        }

        user.setRoles(roles);
        userRepository.save(user);
        return "Update Role User successfully!.";
    }

    public ERole getRole(String role) {
    	if(role.equals("ADMIN")) return ERole.ROLE_ADMIN;
    	else if(role.equals("INSTRUCTOR")) return ERole.ROLE_INSTRUCTOR;
    	else return ERole.ROLE_CLIENT;
    }
    
}
