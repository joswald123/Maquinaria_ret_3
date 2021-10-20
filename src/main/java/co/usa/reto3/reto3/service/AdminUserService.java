package co.usa.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto3.reto3.model.AdminUser;
import co.usa.reto3.reto3.repository.AdminUserRepository;

@Service
public class AdminUserService {
	
	@Autowired
	private AdminUserRepository adminuserRepository;
	
	//GET CRUD
	public List<AdminUser> getAll(){
		return adminuserRepository.getAll();
	}
	
	// GET CRUD BY ID 
	public Optional<AdminUser> getAdminUser(int id){
		return adminuserRepository.getAdminUser(id);
	}
	
	// POST CRUD
	public AdminUser save(AdminUser a) {
		if(a.getIdAdminUser() == null) {
			return adminuserRepository.save(a);
		}else {
			Optional<AdminUser> adminUserAux=adminuserRepository.getAdminUser(a.getIdAdminUser());
			if(adminUserAux.isEmpty()) {
				return adminuserRepository.save(a);
			}else {
				return a;
			}
		}
	}
	
	// UPDATE CRUD
	public AdminUser update(AdminUser a) {
		Optional<AdminUser> adminUserAux = adminuserRepository.getAdminUser(a.getIdAdminUser());
		if (adminUserAux != null) {
			return adminuserRepository.update(a);
		} else {
			return a;
		}
	}
	
	// DELETE CRUD
	public void delete(int id) {
		adminuserRepository.delete(id);
	}

	
	
	
	
}
