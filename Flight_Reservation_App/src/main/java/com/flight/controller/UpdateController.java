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

	// handler for bookingDetails
	@RequestMapping("/bookingDetails")
	public String bookingDetails() {
		return "BookingDetails";
	}

	@RequestMapping("/checkin")
	public String checkIn(@RequestParam(name = "flight_id", required = false, defaultValue = "-1") long id,
			Model model) {
		try {
			if (id <= 0) {
				model.addAttribute("msg", "Invalid flight ID:");
				return "SearchBookingDetails";
			}
			Optional<Reservation> checkInById = reservationService.checkInById(id);
			if (checkInById.isPresent()) {
				Reservation reservation = checkInById.get();
				model.addAttribute("reservation", reservation);
				return "BookingDetails";
			} else {
				model.addAttribute("msg", "Booking Not Found With Id " + id);
				return "SearchBookingDetails";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "Id Field Can't be empty ");
			return "SearchBookingDetails";
		}
	}

}
