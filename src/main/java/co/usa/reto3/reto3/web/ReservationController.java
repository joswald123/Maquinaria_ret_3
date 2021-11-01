package co.usa.reto3.reto3.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.reto3.reto3.model.Reservation;
import co.usa.reto3.reto3.model.custom.CountClient;
import co.usa.reto3.reto3.model.custom.StatusAmount;
import co.usa.reto3.reto3.service.ReservationService;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	// GET a list of Reservations
	@GetMapping("/all")
	public List<Reservation> getReservations(){
		return reservationService.getAll();
	}
	
	// GET a Reservation by Id
	@GetMapping("/{id}")
	public Optional<Reservation> getReservation(@PathVariable("id") int id){
		return reservationService.getReservation(id);
	}
	
	// POST a Reservation
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation save(@RequestBody Reservation r) {
		return reservationService.save(r);
	}
	
	// PUT a Reservation
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation update(@RequestBody Reservation r) {
		return reservationService.update(r);
	}
	
	// DELETE 
	@DeleteMapping("/{idReservation}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("idReservation")int id) {
		reservationService.delete(id);
	}
	
	// GET TopClient List
	@GetMapping("/report-clients")
	public List<CountClient> getCountClient(){
		return reservationService.getTopClient();
	}
	
	//GET Date by period
	@GetMapping("/report-dates/{dateOne}/{dateTwo}")
	public List<Reservation> getDatesReport(@PathVariable("dateOne") String date1, @PathVariable("dateTwo") String date2){
		return reservationService.getReservationByPeriod(date1, date2);
		
	}
	
	// GET Status
	@GetMapping("/report-status")
	public StatusAmount getReservationStatus() {
		return reservationService.getStatusAmount();
	}
}
