package co.usa.reto3.reto3.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="machine")
public class Machine implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String brand;
	private Integer year;
	private String description;
	
	@ManyToOne 
	@JoinColumn(name="categoryId")
	@JsonIgnoreProperties({"category", "machines"})
	public Category category;
	
	@OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "machine")
	@JsonIgnoreProperties({"messages","machine", "client"})
	public List<Message> messages;
	
	@OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "machine")
	@JsonIgnoreProperties({"reservations"})
	public List<Reservation> reservations;
	
	
	
	public Machine() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
	// Getter for Category

	public Category getCategory() {
		return category;
	}
	
	// Setter for Category

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	// Getter & Setter for Messages


	public List<Message> getMessages() {
		return messages;
	}


	public void setMessages(List<Message> messages) {
		this.messages = messages;
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
		return "Machine [id=" + id + ", name=" + name + ", brand=" + brand + ", year=" + year + ", description="
				+ description + "]";
	}


	
	
	
}
