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

import co.usa.reto3.reto3.model.Client;
import co.usa.reto3.reto3.service.ClientService;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	// Get a List of Clients
	@GetMapping("/all")
	public List<Client> getClients(){
		return clientService.gelAll();
	}
	
	// Get by id a client
	@GetMapping("/{id}")
	public Optional<Client> getClient(@PathVariable("id") int id){
		return getClient(id);	
	}
	
	// POST a client
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Client save(@RequestBody Client c) {
		return clientService.save(c);
	}
	
	// Update a client
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Client update(@RequestBody Client c) {
		return clientService.update(c);
	}
	
	// Delete a client
	@DeleteMapping("/{idClient}")
	public void delete(@PathVariable("idClient") int id) {
		clientService.delete(id);
	}

}
