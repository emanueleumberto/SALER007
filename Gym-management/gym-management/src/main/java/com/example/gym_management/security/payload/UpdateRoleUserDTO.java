package com.example.gym_management.security.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateRoleUserDTO {

    private Set<String> roles;

}

/*
    {"roles": ["MODERATOR", "USER"] }
*/
