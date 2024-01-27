package com.flight.Service;

import java.util.Optional;

import com.flight.dto.ReservationRequest;
import com.flight.entities.Reservation;

public interface ReservationService {
	Reservation bookFlight(ReservationRequest request);

	Optional<Reservation> checkInById(long id);
}
