package co.usa.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto3.reto3.model.Client;
import co.usa.reto3.reto3.repository.crud.ClientCrudRepository;

@Repository
public class ClientRepository {

	@Autowired
	private ClientCrudRepository clientCrudRepository;
	
	// GET
	public List<Client> gettAll(){
		return(List<Client>)clientCrudRepository.findAll();
	}
	
	// GET BY ID
	public Optional<Client> getClient(int id){
		return clientCrudRepository.findById(id);
	}
	
	// POST
	public Client save(Client c) {
		return clientCrudRepository.save(c);
	}
	
	// UPDATE
		public Client update(Client c) {
			return clientCrudRepository.save(c);
		}
		
	// DELETE
	public void delete(int id) {
		clientCrudRepository.deleteById(id);
	}
}
