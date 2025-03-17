package com.example.gym_management.payloadDTO;

import com.example.gym_management.enumerations.MembershipType;
import com.example.gym_management.security.entity.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseMembershipDTO {

    private Long id;
    private MembershipType type;
    private LocalDate startMembership;
    private LocalDate endMembership;
    private Boolean active;
    private String clientName;
    private String username;
    private String email;

}

/*
    {
        "id": 2,
        "type": "MONTHLY",
        "startMembership": "2025-03-17",
        "endMembership": "2025-04-17",
        "active": true,
        "username": "mariorossi"
    }
*/

