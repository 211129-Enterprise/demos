package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {

	//The instance var names do NOT need to match the DB column names
	private int id;
	private double balance;
	private int acc0wner;
	private boolean active;
	
	public Account() {
		
	}

	public Account(int id, double balance, int acc0wner, boolean active) {
		super();
		this.id = id;
		this.balance = balance;
		this.acc0wner = acc0wner;
		this.active = active;
	}

	public Account(double balance, int acc0wner, boolean active) {
		super();
		this.balance = balance;
		this.acc0wner = acc0wner;
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

	public int getAcc0wner() {
		return acc0wner;
	}

	public void setAcc0wner(int acc0wner) {
		this.acc0wner = acc0wner;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		return Objects.hash(acc0wner, active, balance, id);
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
		return acc0wner == other.acc0wner && active == other.active
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance) && id == other.id;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", acc0wner=" + acc0wner + ", active=" + active + "]";
	}

	
	
	
	
	
	
	
	
}
