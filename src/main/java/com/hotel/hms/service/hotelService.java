package com.hotel.hms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hms.model.hotel;
import com.hotel.hms.repository.hotelRepository;

@Service
public class hotelService {
	@Autowired
	hotelRepository hotelrepository;

	public hotel addbyrequestparam(hotel h) {
		return hotelrepository.save(h);
	}

	public hotel addbypathvariable(hotel h) {
		return hotelrepository.save(h);
	}

	public hotel addbyrequestbody(hotel h) {
		return hotelrepository.save(h);
	}

	public List<hotel> addmultiplebyrequestbody(List<hotel> hotels) {
		return hotelrepository.saveAll(hotels);
	}

	public List<hotel> getallbookings() {
		return hotelrepository.findAll();
	}

	public Optional<hotel> getallbookingsbyid(int bookingId) {
		return hotelrepository.findById(bookingId);
	}

	public List<hotel> findByGuestName(String guestName) {
		return hotelrepository.findByGuestName(guestName);
	}

	public void deletebyroomnumber(int roomNumber) {
		 hotelrepository.deleteById(roomNumber);
	}

	public hotel updatebyroomnumber(hotel newValues, int roomNumber) {
	    hotel existing = hotelrepository.findById(roomNumber).orElse(null);
	    if (existing != null) {
	        existing.setGuestName(newValues.getGuestName());
	        existing.setRoomNumber(newValues.getRoomNumber());
	        return hotelrepository.save(existing);
	    }
	    return null;
	}



}
