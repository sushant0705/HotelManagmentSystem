package com.hotel.hms.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hms.model.hotel;
import com.hotel.hms.service.hotelService;

import jakarta.validation.Valid;

@RestController
public class hotelController {
	@Autowired
	hotelService hotelservice;

	//test the application
	//http://localhost:7775/test
	@PostMapping("/test")
	public String test() {
		return "Application successfully started";
	}
	
	//add product using request param
	//http://localhost:7775/addbyrequestparam
	@PostMapping("/addbyrequestparam")
	public hotel addbyrequestparam(@RequestParam int bookingId,@RequestParam String guestName,@RequestParam int roomNumber) {
		hotel h=hotel.builder().guestName(guestName).roomNumber(roomNumber).build();
		return hotelservice.addbyrequestparam(h);
	}
	
	//add product using path variable
	//http://localhost:7775/addbypathvariable
	@PostMapping("/addbypathvariable/{bookingId}/{guestName}/{roomNumber}")
	public hotel addbypathvariable(@PathVariable int bookingId,@PathVariable  String guestName,@PathVariable  int roomNumber) {
		hotel h=hotel.builder().guestName(guestName).roomNumber(roomNumber).build();
		return hotelservice.addbypathvariable(h);
	}
	
	//add product using path variable
	//http://localhost:7775/addbyrequestbody
	@PostMapping("/addbyrequestbody")
	public hotel addbyreponsebody(@Valid @RequestBody hotel h) {
		return hotelservice.addbyrequestbody(h);
	}
	
	//add product using path variable
	//http://localhost:7775/addmultiplebyrequestbody
	@PostMapping("/addmultiplebyrequestbody")
	public List<hotel> addmultiplebyrequestbody(@RequestBody List<hotel> hotels) {
		return hotelservice.addmultiplebyrequestbody(hotels);
	}
	
	//get all bookings 
	//http://localhost:7775/getallbookings
	@GetMapping("/getallbookings")
	public List<hotel> getallbookings(){
		return hotelservice.getallbookings();
	}
	
	//get all bookings 
	//http://localhost:7775/getallbookingsbyid
	@GetMapping("/getallbookingsbyid/{bookingId}")
	public Optional<hotel> getallbookingsbyid(@PathVariable int bookingId){
		return hotelservice.getallbookingsbyid(bookingId);
	}
	
	//get all bookings 
	//http://localhost:7775/findByGuestName
	@GetMapping("/findByGuestName/{guestName}")
	public List<hotel> findByGuestName(@PathVariable String guestName){
		return hotelservice.findByGuestName(guestName);
	}
	
	//delete booking
	//http://localhost:7775/deletebyroomnumber
	@DeleteMapping("deletebyroomnumber/{roomNumber}")
	public String deletebyroomnumber(@PathVariable int roomNumber) {
		hotelservice.deletebyroomnumber(roomNumber);
		return roomNumber+"successfully deleted from hms";
	}
	
	//update booking
	//http://localhost:7775/updatebyroomnumber
	@PutMapping("/updatebyroomnumber/{roomNumber}")
	public String updatebyroomnumber(@Valid @RequestBody hotel newvalues,@PathVariable int roomNumber) {
		hotelservice.updatebyroomnumber(newvalues,roomNumber);
		return roomNumber+" Succsfully updated";
	}
}
