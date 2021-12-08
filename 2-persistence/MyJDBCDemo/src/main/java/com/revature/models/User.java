package com.revature.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

//Java Bean
public class User implements Serializable {

	//ID
	//USERNAME
	//PASSWORD
	//ROLE
	private int id;//represented in our DB as a SERIAL PRIMARY KEY
	private String username;
	private String password;
	private Role role; //this will correlate to the ENUM type in our DB
	
	//data structure that represents all the accounts a User has
	private List<Account> accounts;

	//no-args construtor to satisfy java bean design pattern
	public User() {
		
	}
	
	
	
	
	
	//Fully paramertized constructor
	public User(int id, String username, String password, Role role, List<Account> accounts) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.accounts = accounts;
	}
	
	//fully parameterized except for the Id (because if we create a user in our java app to send to DB)
	//This allows me to create a User object without intializing the ID, because I will
	//Create it within my "business layer" aka Java Application before I send it to the DB
	//The DB will then create an ID for the user because of the SERIAL primary key
	public User(String username, String password, Role role, List<Account> accounts) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.accounts = accounts;
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getUsername() {
		return username;
	}





	public void setUsername(String username) {
		this.username = username;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public Role getRole() {
		return role;
	}





	public void setRole(Role role) {
		this.role = role;
	}





	public List<Account> getAccounts() {
		return accounts;
	}





	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id && Objects.equals(password, other.password) && role == other.role
				&& Objects.equals(username, other.username);
	}





	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	//getters and setters
	
	//hashcode & equals overridden methods
	
	//toString
	
	
	
	
	
}
