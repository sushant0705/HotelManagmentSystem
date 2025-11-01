package com.hotel.hms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.hms.model.hotel;

@Repository
public interface hotelRepository extends JpaRepository<hotel, Integer> {

	List<hotel> findByGuestName(String guestName);
	
	

	
	
}
