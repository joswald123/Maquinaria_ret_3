package co.usa.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto3.reto3.model.Category;
import co.usa.reto3.reto3.repository.crud.CategoryCrudRepository;

@Repository
public class CategoryRepository {
	
	@Autowired
	private CategoryCrudRepository categoryCrudRepository;
	
	// GET
	public List<Category> getAll(){
		return(List<Category>)categoryCrudRepository.findAll();
	}
	
	// GET BY ID
	public Optional<Category> getCategory(int id){
		return categoryCrudRepository.findById(id);
	}
	
	// POST
	public Category save(Category c) {
		return categoryCrudRepository.save(c);
	}
	
	// UPDATE
	public Category update(Category c) {
		return categoryCrudRepository.save(c);
	}
	
	// DELETE
	public void delete(int id) {
		categoryCrudRepository.deleteById(id);
	}

}
