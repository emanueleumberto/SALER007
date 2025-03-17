package com.example.gym_management.payloadDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GymClassDTO {

    private String gymClassName;
    private LocalTime startTime;
    private Integer numClientMax;
    private String usernameInstructor;

}

/*
    {
        "gymClassName": "Yoga",
        "startTime": "18:00",
        "numClientMax": 10,
        "usernameInstructor": "mariorossi"
    }
*/
