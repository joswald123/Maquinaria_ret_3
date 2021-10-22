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

import co.usa.reto3.reto3.model.Category;
import co.usa.reto3.reto3.service.CategoryService;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	// GET a list of Categories
	@GetMapping("/all")
	public List<Category> getCategories(){
		return categoryService.getAll();
	}
	
	// Get a category by Id
	@GetMapping("{/id}")
	public Optional<Category> getCategory(@PathVariable ("id") int id){
		return getCategory(id);
	}
	
	// Post a new category
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Category save(@RequestBody Category c) {
		return categoryService.save(c);
	}
	
	// Update a category
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Category update(@RequestBody Category c) {
		return categoryService.update(c);
	}
	
	// Delete a category
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") int id) {
		categoryService.delete(id);
	}
	
	

}
