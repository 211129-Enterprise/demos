package com.revature.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.List;

// Java Bean
public class User implements Serializable{
	
	/*
	 * In the DB we had:
	 * - id
	 * - username
	 * - password
	 * - role
	 */
	private int id; // Represented in our DB as a SERIAL PRIMARY KEY
	private String username, password;
	private Role role; // This will correlate to the ENUM type in our DB
	
	
	// Also, we'll want a data structure to represent all the accounts a user has.
	private List<Account> accounts;


	
	// A few constructors
	public User() { //No-args constructor to satisfy Java Bean design pattern
		
	}
	
	// Fully parameterized constructor EXCEPT for the ID 
	// (because what if we create a user object in our Java App to send to DB)
	// This allows us to create a User object without initializing the ID, because I will
	// create it in my business layer / the java application and then send it to the database.
	// The DB will then create an ID for the user because of the SERIAL PRIMARY KEY
	public User(String username, String password, Role role, List<Account> accounts) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.accounts = accounts;
	}
	
	// Fully parameterized constructor WITH the ID
	public User(int id, String username, String password, Role role, List<Account> accounts) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.accounts = accounts;
	}

	
	
	
	// Getters and setters
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
	
	
	// Hashcode and equals overridden methods
	@Override
	public int hashCode() {
		return Objects.hash(id, password, role, username);
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
	
	
	
	
}
