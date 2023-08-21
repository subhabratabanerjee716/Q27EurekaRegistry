package com.Hotel.microservice.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hotel.microservice.entities.Hotel;
import com.Hotel.microservice.exceptions.ResourceNotFoundException;
import com.Hotel.microservice.repositories.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository hotelrepo;
	
	@Override
	public Hotel create(Hotel hotel) {
		
		String randomId= UUID.randomUUID().toString();
		
		hotel.setId(randomId);
		
		return hotelrepo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {

		return hotelrepo.findAll();
	}

	@Override
	public Hotel get(String id) throws ResourceNotFoundException  {

		
	 Hotel h= hotelrepo.findById(id);
	 
	 if(h== null) {
		 
		 
		 throw new ResourceNotFoundException("No hotel with user id "+id+" was found .");
		 
	 }
	 
	 
	 return h;
	
		
	}

}
