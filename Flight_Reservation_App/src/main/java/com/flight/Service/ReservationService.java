package com.flight.Service;

import com.flight.dto.ReservationRequest;
import com.flight.entities.Reservation;

public interface ReservationService {
	Reservation bookFlight(ReservationRequest request);
}
