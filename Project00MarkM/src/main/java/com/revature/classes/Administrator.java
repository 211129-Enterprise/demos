package com.revature.classes;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import com.revature.accounts.Checking;
import com.revature.util.Role;

public class Administrator extends Person implements Serializable {
	
	static int accountRanking = 3;
	private Role role;
	private List<Checking> accounts;
	
	//constructors======================================================================================================
	public Administrator() {
	}
	public Administrator(int id, Role role, List<Checking> accounts) {
			super();
			this.role = role;
			this.setAccounts(accounts);
	}
	public Administrator(int id, String firstName, String middleInitial, String lastName, int accountRanking,
			int creditCheck, String socialSecurity2, String userName, String passWord, boolean active) {
		super(id, firstName, middleInitial, lastName, accountRanking, creditCheck, socialSecurity2, userName, passWord, active);
	}
	
	//toString ==========================================================================================================	
	@Override
	public String toString() {
		return "\n[" + super.toString() + "]";
	}
	
	//Getters/Setters====================================================================================================
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public int getAccountRanking() {
		return accountRanking;
	}
	public int getaccountRanking() {
		return accountRanking;
	}
	public List<Checking> getChecking() {
		return null;
	}
	public void setChecking(List<Checking> ownedAccounts) {
	}
	//hash code and equals================================================================================================
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
		Administrator other = (Administrator) obj;
		return role == other.role;
	}
	public List<Checking> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Checking> accounts) {
		this.accounts = accounts;
	}

}
