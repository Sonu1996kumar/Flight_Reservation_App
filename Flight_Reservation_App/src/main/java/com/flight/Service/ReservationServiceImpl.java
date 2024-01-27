package com.flight.Service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.dto.ReservationRequest;
import com.flight.entities.Flight;
import com.flight.entities.Passenger;
import com.flight.entities.Reservation;
import com.flight.repositories.FlightRepository;
import com.flight.repositories.PassengerRepository;
import com.flight.repositories.ReservationRepository;
import com.flight.utilities.EmailUtil;
import com.flight.utilities.PDFgenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private PassengerRepository passengerRepo;
	@Autowired
	private FlightRepository flightRepo;
	@Autowired
	private ReservationRepository reservationRepo;
	@Autowired
	private PDFgenerator pdfGenerator;
	@Autowired
	private EmailUtil emailUtil;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepo.save(passenger);
		long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		String filePath = "C:\\SpringBootPr\\Flight_Reservation_App" + reservation.getId()+ ".pdf";
		reservationRepo.save(reservation);
		pdfGenerator.generateItinerary(reservation, filePath);
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		return reservation;
	}

	@Override
	public  Optional<Reservation> checkInById(long id) {
		Optional<Reservation> findById = reservationRepo.findById(id);
		return findById;
		
	}
}
