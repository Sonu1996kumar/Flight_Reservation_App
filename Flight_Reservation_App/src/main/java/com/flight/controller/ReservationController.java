package com.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flight.Service.ReservationService;
import com.flight.dto.ReservationRequest;
import com.flight.entities.Reservation;

@Controller
public class ReservationController {
	@Autowired
	private ReservationService reservationService;

	@RequestMapping("/confirmReservation")
	public String confirmReservation(ReservationRequest request, ModelMap model) {
		Reservation reservationId = reservationService.bookFlight(request);
		model.addAttribute("reservationId", reservationId.getId());
		return "confirmReservation";
	}
}