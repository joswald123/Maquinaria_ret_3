package co.usa.reto3.reto3.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto3.reto3.model.Client;
import co.usa.reto3.reto3.model.Reservation;
import co.usa.reto3.reto3.model.custom.CountClient;
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
	
	// TopClient List
	public List<CountClient> getTopClient() {
		List<CountClient> resp = new ArrayList<>();
		List<Object[]> report = reservationCrudRepository.countTotalReservationByClient();
		for (int i=0; i < report.size(); i++) {
//			Client client = (Client) report.get(i)[0];
//			Long quantity = (Long) report.get(i)[1];
//			CountClient countClient = new CountClient(quantity, client);
//			resp.add(countClient);
			
			resp.add(new CountClient((Long) report.get(i)[1], (Client) report.get(i)[0]));
		}
		return resp;
	}
	
	// Find dates by periods
	public List<Reservation> getReservationByPeriod(Date dateOne, Date dateTwo){
		return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
	}
	
	// Find By Status
	public List<Reservation> getReservationByStatus(String status){
		return reservationCrudRepository.findAllByStatus(status);
	}
	
	
}
