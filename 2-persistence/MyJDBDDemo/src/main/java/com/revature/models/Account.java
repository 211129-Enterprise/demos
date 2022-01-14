package com.revature.models;

import java.io.Serializable;

//Java Bean
public class Account implements Serializable {
	private int id;
	private double balance;
	private int ownerId;
	private boolean active;
	
	public Account() {
		
	}

	public Account(int id, double balance, int ownerId, boolean active) {
		super();
		this.id = id;
		this.balance = balance;
		this.ownerId = ownerId;
		this.active = active;
	}

	public Account(double balance, int ownerId, boolean active) {
		super();
		this.balance = balance;
		this.ownerId = ownerId;
		this.active = active;
	}
	
	//Getters and Setters
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

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	//Hash code and equals methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ownerId;
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
		Account other = (Account) obj;
		if (active != other.active)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (id != other.id)
			return false;
		if (ownerId != other.ownerId)
			return false;
		return true;
	}

	//To String
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", ownerId=" + ownerId + ", active=" + active + "]";
	}
	
	
}
