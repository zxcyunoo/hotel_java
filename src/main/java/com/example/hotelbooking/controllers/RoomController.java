// RoomController.java
package com.example.hotelbooking.controllers;

import com.example.hotelbooking.entities.Room;
import com.example.hotelbooking.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/by-hotel/{hotelId}")
    public List<Room> getByHotel(@PathVariable Long hotelId) {
        return roomService.getByHotel(hotelId);
    }

    @PostMapping
    public Room create(@RequestBody Room room) {
        return roomService.create(room);
    }
}