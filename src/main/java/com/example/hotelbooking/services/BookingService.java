// BookingService.java
package com.example.hotelbooking.services;

import com.example.hotelbooking.entities.Booking;
import com.example.hotelbooking.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public Booking create(Booking booking) { return bookingRepository.save(booking); }
    public List<Booking> getByGuest(String guestName) { return bookingRepository.findByGuestName(guestName); }
}