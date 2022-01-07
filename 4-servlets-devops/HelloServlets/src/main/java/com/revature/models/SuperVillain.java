package com.revature.models;

import java.util.Objects;

public class SuperVillain {
	
	private String name;
	private String superpower;
	private double bounty;
	
	public SuperVillain() {
		
	}

	public SuperVillain(String name, String superpower, double bounty) {
		super();
		this.name = name;
		this.superpower = superpower;
		this.bounty = bounty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getSuperpower() {
		return superpower;
	}

	public void setSuperpower(String superpower) {
		this.superpower = superpower;
	}

	public double getBounty() {
		return bounty;
	}

	public void setBounty(double bounty) {
		this.bounty = bounty;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bounty, name, superpower);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuperVillain other = (SuperVillain) obj;
		return Double.doubleToLongBits(bounty) == Double.doubleToLongBits(other.bounty)
				&& Objects.equals(name, other.name) && Objects.equals(superpower, other.superpower);
	}

	@Override
	public String toString() {
		return "SuperVillain [name=" + name + ", superpower=" + superpower + ", bounty=" + bounty + "]";
	}
	
}
