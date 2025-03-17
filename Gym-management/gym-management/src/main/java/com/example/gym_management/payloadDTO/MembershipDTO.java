package com.example.gym_management.payloadDTO;

import com.example.gym_management.enumerations.MembershipType;
import com.example.gym_management.security.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MembershipDTO {

    private MembershipType type;
    private String username;

    /*
        {
            "type": "MONTHLY", // QUARTERLY, YEARLY
            "username": "mariorossi"
        }
    */

}
