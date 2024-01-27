package com.flight.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight.Service.ReservationService;
import com.flight.entities.Reservation;

@Controller
public class UpdateController {
	@Autowired
	private ReservationService reservationService;
	
	//handler for bookingDetails
	@RequestMapping("/bookingDetails")
	public String bookingDetails() {
		return "BookingDetails";
	}

	@RequestMapping("/checkin")
	public String checkIn(@RequestParam("flight_id") long id,Model model) {
		Optional<Reservation> checkInById = reservationService.checkInById(id);
		if(checkInById.isPresent()) {
		return "update";
		}
		model.addAttribute("msg","Booking Not Found With Id "+id);
		return"BookingDetails" ;
	}

}
