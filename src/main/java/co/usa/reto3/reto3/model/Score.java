package co.usa.reto3.reto3.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="score")
public class Score implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idScore;
	private Integer score;
	
	@OneToOne
	private Reservation reservation;
	
	public Score() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdScore() {
		return idScore;
	}

	public void setIdScore(Integer idScore) {
		this.idScore = idScore;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
	// Getter & Setter for Reservation

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	@Override
	public String toString() {
		return "Score [idScore=" + idScore + ", score=" + score + ", reservation=" + reservation + "]";
	}
	
	
	
	
}
