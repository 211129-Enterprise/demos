package com.revature.models;

public class SuperVillain {
	private String name;
	private String superPower;
	private double bounty;
	
	public SuperVillain() {
		
	}

	public SuperVillain(String name, String superPower, double bounty) {
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
	
}
