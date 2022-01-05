package com.revature.classes;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import com.revature.accounts.Checking;
import com.revature.util.Role;

public class Customers extends Person implements Serializable {

	static int accountRanking = 1;
	private Role role;
	private List<Checking> accounts;

	// Constructor
	// ===================================================================================
	public Customers() {
	}

	public Customers(Role role, List<Checking> accounts) {
		super();
		this.role = role;
		this.setAccounts(accounts);
	}
	public Customers(int id, String firstName, String middleInitial, String lastName, int accountRanking,
			int creditCheck, String socialSecurity, String userName, String passWord, boolean active) {
		super(id, firstName, middleInitial, lastName, accountRanking, creditCheck, socialSecurity, userName, passWord, active);
	}

	// toString
	// ======================================================================================
	@Override
	public String toString() {
		return "\n[" + super.toString() + "]";
	}
	
	// Getters &
	// setters===============================================================================


	public int getaccountRanking() {
		return accountRanking;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Checking> getChecking() {
		return null;
	}

	public void setChecking(List<Checking> ownedAccounts) {
	}

	// Hash code and Equals
	// ============================================================================
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(role);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customers other = (Customers) obj;
		return role == other.role;
	}

	public List<Checking> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Checking> accounts) {
		this.accounts = accounts;
	}

}