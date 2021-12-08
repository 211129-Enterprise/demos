package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable{
	
	// instance var names do not need to match db Column names.
	private int id;
	private double balance;
	private int accOwner;
	private boolean active;
	
	public Account ( ) {
		
	}

	public Account(int id, double balance, int accOwner, boolean active) {
		super();
		this.id = id;
		this.balance = balance;
		this.accOwner = accOwner;
		this.active = active;
	}

	public Account(double balance, int accOwner, boolean active) {
		super();
		this.balance = balance;
		this.accOwner = accOwner;
		this.active = active;
	}

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

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", accOwner=" + accOwner + ", active=" + active + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(accOwner, active, balance, id);
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
		return accOwner == other.accOwner && active == other.active
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance) && id == other.id;
	}
	
	
	
}
