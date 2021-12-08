package com.revature.models;

import java.io.Serializable;

public class Account implements Serializable{
/* Global Variables */
	//The instance variable names do NOT need to match the DB column names
	private int id;
	private double balance;
	private int accOwner;
	private boolean active;

	
/* Constructors */
	//No-args constructor
	public Account() {
		
	}
	
	//ALL parameters EXCEPT id
	public Account(double balance, int accOwner, boolean active) {
		super();
		this.balance = balance;
		this.accOwner = accOwner;
		this.active = active;
	}	
	

	//ALL parameters
	public Account(int id, double balance, int accOwner, boolean active) {
		super();
		this.id = id;
		this.balance = balance;
		this.accOwner = accOwner;
		this.active = active;
	}

	
/* Getters & Setters */
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccOwner() {
		return accOwner;
	}

	public void setAccOwner(int accOwner) {
		this.accOwner = accOwner;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
/* Java Bean Overrides */
	//...
	
	
	
}
