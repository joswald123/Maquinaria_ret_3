package co.usa.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto3.reto3.model.AdminUser;
import co.usa.reto3.reto3.repository.crud.AdminUserCrudRepository;

@Repository
public class AdminUserRepository {
	
	@Autowired
	private AdminUserCrudRepository adminuserCrudRepository;
	
	// GET 
	public List<AdminUser> getAll(){
		return(List<AdminUser>)adminuserCrudRepository.findAll();
	}
	
	// GET BY ID
	public Optional<AdminUser> getAdminUser(int id){
		return adminuserCrudRepository.findById(id);
	
	}
	
	// POST
	public AdminUser save(AdminUser a) {
		return adminuserCrudRepository.save(a);
	}
	
	// PUT
	public AdminUser update(AdminUser a) {
		return adminuserCrudRepository.save(a);
	}
	
	// DELETE
	public void delete(int i) {
		adminuserCrudRepository.deleteById(i);
	}
	
	
	

}
