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

import co.usa.reto3.reto3.model.Score;
import co.usa.reto3.reto3.service.ScoreService;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ScoreController {

	@Autowired
	private ScoreService scoreService;
	
	// Get a list of Scores
	@GetMapping("/all")
	public List<Score> getScores(){
		return scoreService.getAll();
	}
	
	// Get a Score by id
	@GetMapping("/{id")
	public Optional<Score> getScore(@PathVariable("id")int id){
		return getScore(id);
	}
	
	// Save a score
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Score save(@RequestBody Score s) {
		return scoreService.save(s);
	}
	
	// Edit a Score
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Score update(@RequestBody Score s) {
		return scoreService.update(s);
	}
	
	// Delete a score
	@DeleteMapping("/delete/{idScore}")
	public void delete(@PathVariable("idScore") int id) {
		scoreService.delete(id);
	}
		
	
	
}
