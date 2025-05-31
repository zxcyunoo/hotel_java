// HotelController.java
package com.example.hotelbooking.controllers;

import com.example.hotelbooking.entities.Hotel;
import com.example.hotelbooking.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping
    public List<Hotel> getAll() { return hotelService.getAll(); }

    @GetMapping("/{id}")
    public Hotel getById(@PathVariable Long id) { return hotelService.getById(id); }

    @PostMapping
    public Hotel create(@RequestBody Hotel hotel) { return hotelService.create(hotel); }
}