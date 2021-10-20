package co.usa.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto3.reto3.model.Machine;
import co.usa.reto3.reto3.repository.crud.MachineCrudRepository;

@Repository
public class MachineRepository {
	
	
	@Autowired
	private MachineCrudRepository machineCrudRepository;
	
	// GET
	public List<Machine> getAll() {
		return(List<Machine>)machineCrudRepository.findAll();
	}
	
	// GET BY ID
	public Optional<Machine> getMachine(int id){
		return machineCrudRepository.findById(id);
	}
	
	// POST
	public Machine save(Machine m){
		return machineCrudRepository.save(m);
	}
	
	// UPDATE
	public Machine update(Machine m){
		return machineCrudRepository.save(m);
	}
	
	// DELETE
	public void delete(int id) {
		machineCrudRepository.deleteById(id);
	}

}
