// RoomRepository.java
package com.example.hotelbooking.repositories;

import com.example.hotelbooking.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByHotelId(Long hotelId);
}