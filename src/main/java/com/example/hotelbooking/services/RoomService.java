// RoomService.java
package com.example.hotelbooking.services;

import com.example.hotelbooking.entities.Room;
import com.example.hotelbooking.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getByHotel(Long hotelId) { return roomRepository.findByHotelId(hotelId); }
    public Room create(Room room) { return roomRepository.save(room); }
}