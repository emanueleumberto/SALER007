package com.example.gym_management.security.service;

import com.example.gym_management.security.payload.LoginDto;
import com.example.gym_management.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
