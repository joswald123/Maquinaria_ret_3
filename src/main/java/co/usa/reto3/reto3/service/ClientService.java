package co.usa.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto3.reto3.model.Client;
import co.usa.reto3.reto3.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	// GET CRUD
	public List<Client> gelAll(){
		return clientRepository.gettAll();
		
	}
	
	// POST CRUD
	public Client save(Client c) {
		if(c.getIdClient() == null) {
			return clientRepository.save(c);
		}else {
			Optional<Client> clientAux=clientRepository.getClient(c.getIdClient());
			if(clientAux.isEmpty()) {
				return clientRepository.save(c);
			}else {
				return c;
			}
		}
	}
	
	// Update CRUD
	public Client update(Client c) {
		if(c.getIdClient() !=null) {
			Optional<Client> cAux = clientRepository.getClient(c.getIdClient());
			if(!cAux.isEmpty()) {
				if(c.getEmail() != null) {
					cAux.get().setEmail(c.getEmail());
				}
				if(c.getPassword() != null) {
					cAux.get().setPassword(c.getPassword());
				}
				if(c.getName() != null) {
					cAux.get().setName(c.getName());
				}
				if(c.getAge() != null) {
					cAux.get().setAge(c.getAge());
				}
				return clientRepository.save(cAux.get());
			}
		}
		return c;
	}

	// DELETE CRUD
	public void delete(int id) {
		clientRepository.delete(id);
	}
	
	
}
