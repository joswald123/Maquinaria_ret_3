package co.usa.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto3.reto3.model.Reservation;
import co.usa.reto3.reto3.repository.crud.ReservationCrudRepository;

@Repository
public class ReservationRepository {
	
	@Autowired
	private ReservationCrudRepository reservationCrudRepository;
	
	// GET
	public List<Reservation> getAll(){
		return(List<Reservation>)reservationCrudRepository.findAll();
	
	}
	
	// GET BY ID
	public Optional<Reservation> getReservation(int id){
		return reservationCrudRepository.findById(id);
	}
	
	// POST
	public Reservation save(Reservation r) {
		return reservationCrudRepository.save(r);
	}
	
	// UPDATE PUT
	public Reservation update(Reservation r) {
		return reservationCrudRepository.save(r);
	}
	
	// DELETE
	public void delete(int id) {
		reservationCrudRepository.deleteById(id);
	}
	
}
