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

import co.usa.reto3.reto3.model.Message;
import co.usa.reto3.reto3.service.MessagesService;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MessagesController {
	
	@Autowired
	private MessagesService messagesService;
	
	// Get a list of Messages
	@GetMapping("/all")
	public List<Message> getMessages(){
		return messagesService.getAll();
	}
	
	// Get a Message by id
	@GetMapping("/{id}")
	public Optional<Message> getMessages(@PathVariable("id") int id){
		return getMessages(id);
	}
	
	// Post a new Message
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Message save(@RequestBody Message m) {
		return messagesService.save(m);
	}
	
	// Put a message
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Message update(@RequestBody Message m) {
		return messagesService.update(m);
	}
	
	// Delete a message
	@DeleteMapping("/delete/{idMessage}")
	public void delete(@PathVariable("idMessage")int id) {
		messagesService.delete(id);
	}
	


}
