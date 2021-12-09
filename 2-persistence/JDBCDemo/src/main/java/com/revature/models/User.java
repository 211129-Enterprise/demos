package com.revature.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;



public class User implements Serializable {
	
	// id
	// username
	// password
	// role
	
	private int id; // represented in our DB as a Serial Primary key
	private String username;
	private String password;
	private Role role;
	
	private List<Account> accounts;
	
	public User() {
		
	}
	

	public User(String username, String password, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}


	public User(int id, String username, String password, Role role, List<Account> accounts) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.accounts = accounts;
	}

	public User(String username, String password, Role role, List<Account> accounts) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.accounts = accounts;
	}

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
	
	// data structure that represents all the accounts a user has
	
	
}
