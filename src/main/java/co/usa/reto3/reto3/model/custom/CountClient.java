package co.usa.reto3.reto3.model.custom;

import co.usa.reto3.reto3.model.Client;

public class CountClient {
	
	private Long total;
	private Client client;
	
	// Constructor 
	public CountClient(Long total, Client client) {
		this.total = total;
		this.client = client;
	}

	// Getters & Setters modify the object access
	public Long getTotal() {
		return total;
	}


	public void setTotal(Long total) {
		this.total = total;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}
	
	

}
