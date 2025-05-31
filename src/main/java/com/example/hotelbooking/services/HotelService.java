// HotelService.java
package com.example.hotelbooking.services;

import com.example.hotelbooking.entities.Hotel;
import com.example.hotelbooking.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getAll() { return hotelRepository.findAll(); }
    public Hotel getById(Long id) { return hotelRepository.findById(id).orElseThrow(); }
    public Hotel create(Hotel hotel) { return hotelRepository.save(hotel); }
}
