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

import co.usa.reto3.reto3.model.Machine;
import co.usa.reto3.reto3.service.MachineService;

@RestController
@RequestMapping("/api/Machine")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MachineController {

	@Autowired
	private MachineService machineService;
	
	@GetMapping("/all")
	public List<Machine> getMachines(){
		return machineService.getAll();
	}
	
	@GetMapping("{/id}")
	public Optional<Machine> getMachine(@PathVariable ("id") int id){
		return getMachine(id);	
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Machine save(@RequestBody Machine m) {
		return machineService.save(m);
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Machine update(@RequestBody Machine m) {
		return machineService.update(m);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") int id) {
		machineService.delete(id);
	}
	
	
	
}
