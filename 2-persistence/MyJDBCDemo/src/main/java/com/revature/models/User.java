package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Java Bean
public class User implements Serializable {
	
	/*
	 * id
	 * username
	 * password
	 * role
	 */
	
	private int id; // represented in our DB as a SERIAL PRIMARY KEY
	private String username;
	private String pwd;
	private String role; // this will correlate to the ENUM type in our DB
	
	// data structure that represents all the accounts a User has
	private List<Account> accounts;

	// public no-args constructor to satisfy Java Bean design
	public User() {
		
	}
	
	// a few constructors
	public User(int id, String username, String pwd, String role, List<Account> accounts) {
		super();
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.role = role;
		this.accounts = accounts;
	}
	
	/* fully parameterized EXCEPT for the ID (because what if we create a User in our Java App to send to the DB)
	 * This allows me to create a User object without initializing the ID, because I will
	 * create it within my "business layer" aka Java Application before I send it to the DB.
	 * the DB will then create an ID for the user because of the SERIAL PRIMARY KEY.
	 */
	public User(String username, String pwd, String role, List<Account> accounts) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.role = role;
		this.accounts = accounts;
	}

	
	// getters & setters
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
	
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}
	
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	// override toString, hashCode, equals
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pwd=" + pwd + ", role=" + role + ", accounts="
				+ accounts + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(accounts, id, pwd, role, username);
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
		return Objects.equals(accounts, other.accounts) && id == other.id && Objects.equals(pwd, other.pwd)
				&& Objects.equals(role, other.role) && Objects.equals(username, other.username);
	}
	
}
