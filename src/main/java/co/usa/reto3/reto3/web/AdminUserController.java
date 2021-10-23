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

import co.usa.reto3.reto3.model.AdminUser;
import co.usa.reto3.reto3.service.AdminUserService;

@RestController
@RequestMapping("/api/AdminUser")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AdminUserController {
	
	@Autowired
	private AdminUserService adminuserService;
	
	// Get a list of Scores
		@GetMapping("/all")
		public List<AdminUser> getAdminUser(){
			return adminuserService.getAll();
		}
		
		// Get a Score by id
		@GetMapping("/{id")
		public Optional<AdminUser> getAdminUser(@PathVariable("id")int id){
			return getAdminUser(id);
		}
		
		// Save a score
		@PostMapping("/save")
		@ResponseStatus(HttpStatus.CREATED)
		public AdminUser save(@RequestBody AdminUser a) {
			return adminuserService.save(a);
		}
		
		// Edit a Score
		@PutMapping("/update")
		@ResponseStatus(HttpStatus.CREATED)
		public 	AdminUser update(@RequestBody AdminUser a) {
			return adminuserService.update(a);
		}
		
		// Delete a score
		@DeleteMapping("/{idAdminUser}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void delete(@PathVariable("idAdminUser") int id) {
			adminuserService.delete(id);
		}
		
	

}
