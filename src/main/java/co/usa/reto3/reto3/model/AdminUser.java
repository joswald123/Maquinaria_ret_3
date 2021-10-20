package co.usa.reto3.reto3.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adminuser")
public class AdminUser implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAdminUser;
	private String name;
	private String email;
	private String password;
	
	public AdminUser() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdAdminUser() {
		return idAdminUser;
	}

	public void setIdAdminUser(Integer idAdminUser) {
		this.idAdminUser = idAdminUser;
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

	
	@Override
	public String toString() {
		return "AdminUser [idAdminUser=" + idAdminUser + ", name=" + name + ", email=" + email + ", password="
				+ password + "]";
	}
	
		
}
