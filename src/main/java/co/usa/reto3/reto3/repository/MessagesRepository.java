package co.usa.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto3.reto3.model.Message;
import co.usa.reto3.reto3.repository.crud.MessagesCrudRepository;

@Repository
public class MessagesRepository {
	
	@Autowired
	private MessagesCrudRepository messagesCrudRepository;
	
	// GET CRUD
	public List<Message> getAll(){
		return(List<Message>) messagesCrudRepository.findAll();
	
	}
	
	// GET BY ID CRUD
	public Optional<Message> getMessages(int id){
		return messagesCrudRepository.findById(id);
	}
	
	// POST CRUD
	public Message save(Message m) {
		return messagesCrudRepository.save(m);
	}
	
	// PUT CRUD
	public Message update(Message m) {
		return messagesCrudRepository.save(m);
	}
	
	// DELETE CRUD
	public void delete (int id) {
		messagesCrudRepository.deleteById(id);
	}

}
