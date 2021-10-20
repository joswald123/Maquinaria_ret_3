package co.usa.reto3.reto3.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "messages")
public class Message implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMessage;
	private String messageText;
	
//	Relation with Machine table
	@ManyToOne
	@JoinColumn(name="machineId")
	@JsonIgnoreProperties({"messages", "reservations"})
	public Machine machine;
	
//	Relation with Client table
	@ManyToOne
	@JoinColumn(name="clientIdClient")
	@JsonIgnoreProperties({"messages", "reservations"})
	public Client client;
	
	
	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Integer idMessage) {
		this.idMessage = idMessage;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
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

	@Override
	public String toString() {
		return "Message [idMessage=" + idMessage + ", messageText=" + messageText + "]";
	}

	
	
	
}
