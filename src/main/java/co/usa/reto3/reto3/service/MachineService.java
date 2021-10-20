package co.usa.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto3.reto3.model.Machine;
import co.usa.reto3.reto3.repository.MachineRepository;

@Service
public class MachineService {
	
	@Autowired
	private MachineRepository machineRepository;
	
	// GET CRUD
	public List<Machine> getAll(){
		return(List<Machine>)machineRepository.getAll();
	}
	
	// GET BY ID CRUD	
	public Optional<Machine> getMachine(int id){
		return machineRepository.getMachine(id);
	}
	
	// POST CRUD
	public Machine save(Machine m) {
		if(m.getId() == null) {
			return machineRepository.save(m);
		}else {
			Optional<Machine> paux=machineRepository.getMachine(m.getId());
			if(paux.isEmpty()) {
				return machineRepository.save(m);
			}else {
				return m;
			}
		}
	}
	
	// Update CRUD
	public Machine update(Machine m) {
		Optional<Machine> maux = machineRepository.getMachine(m.getId());
		if (maux != null) {
			return machineRepository.update(m);
		} else {
			return m;
		}
	}

	
	// DELETE CRUD
	public void delete(int id) {
		machineRepository.delete(id);
	}

}
