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
		if(m.getId() != null) {
			Optional<Machine> mAux=machineRepository.getMachine(m.getId());
			if(!mAux.isEmpty()) {
				if(m.getName() != null) {
					mAux.get().setName(m.getName());
				}
				if(m.getBrand() != null) {
					mAux.get().setBrand(m.getBrand());
				}
				if(m.getYear() != null) {
					mAux.get().setYear(m.getYear());
				}
				if(m.getDescription() != null) {
					mAux.get().setDescription(m.getDescription());
				}
				return machineRepository.save(mAux.get());
			}
			
		}
		return m;
	}
	

	
	// DELETE CRUD
	public void delete(int id) {
		machineRepository.delete(id);
	}

}
