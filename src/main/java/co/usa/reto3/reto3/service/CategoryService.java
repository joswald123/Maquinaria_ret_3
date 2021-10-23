package co.usa.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto3.reto3.model.Category;
import co.usa.reto3.reto3.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	// GET CRUD
	public List<Category> getAll(){
		return(List<Category>)categoryRepository.getAll();
	}
	
	// GET BY ID CRUD	
	public Optional<Category> getCategory(int id){
		return categoryRepository.getCategory(id);
	}
	
	// POST CRUD
	public Category save(Category c) {
		if(c.getId() == null) {
			return categoryRepository.save(c);
		}else {
			Optional<Category> cAux=categoryRepository.getCategory(c.getId());
			if(cAux.isEmpty()) {
				return categoryRepository.save(c);
			}else {
				return c;
			}
		}
	}
	
	// Update CRUD
	public Category update(Category c) {
		if (c.getId() != null) {
			Optional<Category> cAux = categoryRepository.getCategory(c.getId());
			if(!cAux.isEmpty()) {
				if(c.getName() != null) {
					cAux.get().setName(c.getName());
				}
				if(c.getDescription()!= null) {
					cAux.get().setDescription(c.getDescription());
				}
				return categoryRepository.save(cAux.get());
			}
		}
		return c;
	}
	
  
	
	// DELETE CRUD
	public void delete(int id) {
		categoryRepository.delete(id);
	}


}
