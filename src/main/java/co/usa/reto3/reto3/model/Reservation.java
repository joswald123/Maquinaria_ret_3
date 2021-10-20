package co.usa.reto3.reto3.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReservation;
	private Date startDate;
	private Date devolutionDate;
	private String status = "created";

	@ManyToOne
	@JoinColumn(name = "machineId")
	@JsonIgnoreProperties({ "machine", "client", "reservations" })
	public Machine machine;

	@ManyToOne
	@JoinColumn(name = "clientIdClient")
	@JsonIgnoreProperties({ "client", "messages", "reservations" })
	public Client client;
	
	@OneToOne
	@JsonIgnoreProperties("score")
	private Score score;

	// Constructor empty
	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	// Getters & Setters
	public Integer getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDevolutionDate() {
		return devolutionDate;
	}

	public void setDevolutionDate(Date devolutionDate) {
		this.devolutionDate = devolutionDate;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	// Getter & Setter for Machine



	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	// Getter & Setter for Client

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	// Getter & Setter for Score

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Reservation [idReservation=" + idReservation + ", startDate=" + startDate + ", devolutionDate="
				+ devolutionDate + ", status=" + status + "]";
	}

	

}
