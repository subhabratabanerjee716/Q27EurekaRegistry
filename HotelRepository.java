package com.Hotel.microservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hotel.microservice.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

	Hotel findById(String id);

}
