package co.usa.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto3.reto3.model.Message;
import co.usa.reto3.reto3.repository.MessagesRepository;

@Service
public class MessagesService {
	
	@Autowired
	private MessagesRepository messagesRepository;
	
	// GET CRUD
	public List<Message> getAll(){
		return(List<Message>) messagesRepository.getAll();
	}
	
	// GET ID BY CRUD
	public Optional<Message> getMessages(int id){
		return messagesRepository.getMessages(id);
	}
	
	// POST CRUD
	public Message save(Message m) {
		if (m.getIdMessage() == null) {
			return messagesRepository.save(m);
		} else {
			Optional<Message> messagesAux = messagesRepository.getMessages(m.getIdMessage());
			if (messagesAux.isEmpty()) {
				return messagesRepository.save(m);
			} else {
				return m;
			}
		}
	}
	
	// Update CRUD
	public Message update(Message m) {
		Optional<Message> messagesAux = messagesRepository.getMessages(m.getIdMessage());
		if (messagesAux != null) {
			return messagesRepository.save(m);
		} else {
			return m;
		}
	}
	
	
	// DELETE CRUD
	public void delete(int id) {
		messagesRepository.delete(id);
	}

}
