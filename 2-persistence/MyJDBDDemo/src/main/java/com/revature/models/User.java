package com.revature.models;

import java.io.Serializable;
import java.util.List;

//Java Bean
//Serializable, no args constructor, overrise hash and toequals, getters and setters, private fields
public class User implements Serializable {

	private int id; // repersented in our DB as a serial primary key
	private String userName;
	private String password;
	private Role role;// correlates the enum type in our db
	private List<Account> accounts;// data structure to represent all the accounts a user has

	// no args constructor
	public User() {

	}

	// fully parameterized constructor
	public User(int id, String userName, String password, Role role, List<Account> accounts) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.accounts = accounts;
	}

	// fully parameterized constructor except for the id field
	// create a user without
	public User(String userName, String password, Role role, List<Account> accounts) {
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.accounts = accounts;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	// Hash Code and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role != other.role)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	//toString method
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}

}
