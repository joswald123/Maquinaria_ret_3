package co.usa.reto3.reto3.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="client")
public class Client implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idClient;
	private String name;
	private String email;
	private String password;
	private Integer age;
	
	// Relations between tables
	@OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
	@JsonIgnoreProperties("client")
	public List<Message> messages;
	
	@OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
	@JsonIgnoreProperties("client")
	public List<Reservation> reservations;
	
	
	public Client() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
//	 Getters & Setters for Client

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> message) {
		this.messages = message;
	}
	
	// Getter & Setter for Reservations

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", age=" + age + "]";
	}
	
	
	
}
