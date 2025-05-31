// BookingController.java
package com.example.hotelbooking.controllers;

import com.example.hotelbooking.entities.Booking;
import com.example.hotelbooking.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking create(@RequestBody Booking booking) {
        return bookingService.create(booking);
    }

    @GetMapping("/by-guest")
    public List<Booking> getByGuest(@RequestParam String guestName) {
        return bookingService.getByGuest(guestName);
    }
}