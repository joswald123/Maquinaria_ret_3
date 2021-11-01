package co.usa.reto3.reto3.repository.crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.usa.reto3.reto3.model.Reservation;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
	
	// Consult JPQL  
	@Query("SELECT r.client, COUNT(r.client) FROM Reservation AS r GROUP BY r.client ORDER BY COUNT(r.client) DESC")
	public List<Object[]> countTotalReservationByClient();
	
	public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
	
	public List<Reservation> findAllByStatus(String status);
	
}
