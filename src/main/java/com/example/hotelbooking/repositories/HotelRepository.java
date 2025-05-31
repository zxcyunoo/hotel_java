// HotelRepository.java
package com.example.hotelbooking.repositories;

import com.example.hotelbooking.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {}