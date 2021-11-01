package co.usa.reto3.reto3.model.custom;

public class StatusAmount {
	
	private int completed;
	private int cancelled;
	
	// Constructor
	public StatusAmount(int completed, int cancelled) {
		this.completed = completed;
		this.cancelled = cancelled;
	}
	
	// Getter & Setter
	public int getCompleted() {
		return completed;
	}

	public void setCompleted(int completed) {
		this.completed = completed;
	}

	public int getCancelled() {
		return cancelled;
	}

	public void setCancelled(int cancelled) {
		this.cancelled = cancelled;
	}


}
