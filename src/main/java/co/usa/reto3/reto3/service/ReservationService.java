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
		if(r.getIdReservation() != null){
			Optional<Reservation> rAux = reservationRepository.getReservation(r.getIdReservation());
			if(!rAux.isEmpty()) {
				if(r.getStartDate() != null) {
					rAux.get().setStartDate(r.getStartDate());
				}
				if(r.getDevolutionDate() != null) {
					rAux.get().setDevolutionDate(r.getDevolutionDate());
				}
				if(r.getScore() != null) {
					rAux.get().setScore(r.getScore());
				}
				if(r.getStatus() != null) {
					rAux.get().setStatus(r.getStatus());
				}
				return reservationRepository.save(rAux.get());
				
			}
		}
		return r;
	}
		
	
	// DELETE CRUD
	public void delete(int id) {
		reservationRepository.delete(id);
	}
	
}
