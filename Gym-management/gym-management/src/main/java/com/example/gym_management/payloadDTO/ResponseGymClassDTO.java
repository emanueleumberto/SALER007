package com.example.gym_management.payloadDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseGymClassDTO {

    private Long id;
    private String gymClassName;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer numClientMax;
    private String usernameInstructor;

}
