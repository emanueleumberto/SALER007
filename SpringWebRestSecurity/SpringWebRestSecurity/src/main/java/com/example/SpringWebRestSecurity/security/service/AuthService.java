package com.example.SpringWebRestSecurity.security.service;


import com.example.SpringWebRestSecurity.security.payload.LoginDto;
import com.example.SpringWebRestSecurity.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
