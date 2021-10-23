package co.usa.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto3.reto3.model.Score;
import co.usa.reto3.reto3.repository.ScoreRepository;

@Service
public class ScoreService {
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	// GET CRUD
	public List<Score> getAll(){
		return scoreRepository.getAll();
	}
	
	// GET BY ID CURD
	public Optional<Score> getScore(int id){
		return scoreRepository.getScore(id);
	}
	
	// POST CRUD
	public Score save(Score s) {
		if (s.getIdScore() == null) {
			return scoreRepository.save(s);
		} else {
			Optional<Score> scoreAux = scoreRepository.getScore(s.getIdScore());
			if (scoreAux.isEmpty()) {
				return scoreRepository.save(s);
			} else {
				return s;
			}
		}
	}
	
	// PUT CRUD
	public Score update(Score s) {
		if(s.getIdScore() != null) {
			Optional<Score> sAux=scoreRepository.getScore(s.getIdScore());
			if(!sAux.isEmpty()) {
				if(s.getScore() != null) {
					sAux.get().setScore(s.getScore());
				}
				return scoreRepository.save(sAux.get());
			}
		}
		return s;
	}

	
	// DELETE CRUD
	public void delete(int id) {
		scoreRepository.delete(id);
	}
}
