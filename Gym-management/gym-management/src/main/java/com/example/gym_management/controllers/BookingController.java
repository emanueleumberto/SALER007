package com.example.gym_management.controllers;

import com.example.gym_management.payloadDTO.BookingDTO;
import com.example.gym_management.services.GymClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired GymClassService gymClassService;

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> bookingClass(@RequestBody  BookingDTO bookingDTO) {
        gymClassService.createBooking(bookingDTO);
        return new ResponseEntity<>("Class " + bookingDTO.getGymClassName() + " Booking created!!", HttpStatus.OK);
    }

    @DeleteMapping("/{classId}/{userId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> deleteBookingClass(@PathVariable Long classId, @PathVariable Long userId) {
        gymClassService.deleteBooking(classId, userId);
        return new ResponseEntity<>("Booking deleted! ", HttpStatus.OK);
    }

}
