package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {
	int id ;
	private double balance ;
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
	
	
	public Account( double balance, int ownerId, boolean active) {
		super();
	
		this.balance = balance;
		this.ownerId = ownerId;
		this.active = active;
	}
	
	
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(active, balance, id, ownerId);
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
		return active == other.active && Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& id == other.id && ownerId == other.ownerId;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", ownerId=" + ownerId + ", active=" + active + "]";
	}

	public int getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}

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
	
	
	
	
	
	
}
