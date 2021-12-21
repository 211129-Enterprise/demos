package com.revature.models;

import java.util.Objects;

public class SuperVillian {
	
	private String name;
	private String superPower;
	private double bounty;
	
	public SuperVillian() {
		
	}

	public SuperVillian(String name, String superPower, double bounty) {
		super();
		this.name = name;
		this.superPower = superPower;
		this.bounty = bounty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuperPower() {
		return superPower;
	}

	public void setSuperPower(String superPower) {
		this.superPower = superPower;
	}

	public double getBounty() {
		return bounty;
	}

	public void setBounty(double bounty) {
		this.bounty = bounty;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bounty, name, superPower);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuperVillian other = (SuperVillian) obj;
		return Double.doubleToLongBits(bounty) == Double.doubleToLongBits(other.bounty)
				&& Objects.equals(name, other.name) && Objects.equals(superPower, other.superPower);
	}

	@Override
	public String toString() {
		return "SuperVillian [name=" + name + ", superPower=" + superPower + ", bounty=" + bounty + "]";
	}
	
	

}
