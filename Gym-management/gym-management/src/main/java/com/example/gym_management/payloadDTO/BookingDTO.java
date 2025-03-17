package com.example.gym_management.payloadDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingDTO {

    private String gymClassName;
    private LocalTime startTime;
    private String username;

}
