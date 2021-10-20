package co.usa.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto3.reto3.model.Reservation;
import co.usa.reto3.reto3.repository.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	// GET CRUD
	public List<Reservation> getAll(){
		return(List<Reservation>) reservationRepository.getAll();
	}
	
	// GET BY ID CRUD
	public Optional<Reservation> getReservation(int id){
		return reservationRepository.getReservation(id);
	}
	
	
	// POST CRUD
	public Reservation save(Reservation r) {
		if(r.getIdReservation() == null) {
			return reservationRepository.save(r);
		}else {
			Optional<Reservation> reservationAux=reservationRepository.getReservation(r.getIdReservation());
			if(reservationAux.isEmpty()) {
				return reservationRepository.save(r);
			}else {
				return r;
			}
		}
	}
	
	// PUT CRUD
	public Reservation update(Reservation r) {
		Optional<Reservation> reservationAux = reservationRepository.getReservation(r.getIdReservation());
		if (reservationAux != null) {
			return reservationRepository.save(r);
		} else {
			return r;
		}
	}
		
	
	// DELETE CRUD
	public void delete(int id) {
		reservationRepository.delete(id);
	}
	
}
