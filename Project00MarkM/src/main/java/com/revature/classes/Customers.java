package com.revature.classes;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.revature.accounts.Checking;
import com.revature.util.Role;

@Entity
@Table(name="customer")
public class Customers extends Person implements Serializable {

	private static final long serialVersionUID = -6755322236624519095L;
	
	@Column(name ="acc_ranking", columnDefinition="Number(1,0)", updatable=false)
	private int accountRanking = 1;
	
	@Column(name="account_ranking", updatable=false)
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