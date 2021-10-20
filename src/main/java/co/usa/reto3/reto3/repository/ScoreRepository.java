package co.usa.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto3.reto3.model.Score;
import co.usa.reto3.reto3.repository.crud.ScoreCrudRepository;

@Repository
public class ScoreRepository {
	
	@Autowired
	private ScoreCrudRepository scoreCrudRepository;
	
	// GET
	public List<Score> getAll(){
		return(List<Score>)scoreCrudRepository.findAll();
	}
	
	// GET BY ID
	public Optional<Score> getScore(int id){
		return scoreCrudRepository.findById(id);
	}
	
	// POST
	public Score save(Score s) {
		return scoreCrudRepository.save(s);
	}
	
	// PUT
	public Score update(Score s) {
		return scoreCrudRepository.save(s);
	}
	
	// DELETE
	public void delete(int id) {
		scoreCrudRepository.deleteById(id);
	}
	

}
