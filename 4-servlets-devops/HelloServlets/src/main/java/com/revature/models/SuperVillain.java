package com.revature.models;

<<<<<<< HEAD
import java.util.Objects;

public class SuperVillain {
	
=======
// Just a basic Java POJO!
public class SuperVillain {

>>>>>>> f3f3f52fd33d8857a40e61cc42c0f040b8df97ac
	private String name;
	private String superPower;
	private double bounty;
	
<<<<<<< HEAD
	
	
	public SuperVillain() {

	}


=======
	public SuperVillain() {
		
		
	}

>>>>>>> f3f3f52fd33d8857a40e61cc42c0f040b8df97ac
	public SuperVillain(String name, String superPower, double bounty) {
		super();
		this.name = name;
		this.superPower = superPower;
		this.bounty = bounty;
	}

<<<<<<< HEAD

	@Override
	public String toString() {
		return "SuperVillain [name=" + name + ", superPower=" + superPower + ", bounty=" + bounty + "]";
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
=======
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

>>>>>>> f3f3f52fd33d8857a40e61cc42c0f040b8df97ac
	public void setBounty(double bounty) {
		this.bounty = bounty;
	}

<<<<<<< HEAD

	@Override
	public int hashCode() {
		return Objects.hash(bounty, name, superPower);
	}
=======
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(bounty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((superPower == null) ? 0 : superPower.hashCode());
		return result;
	}

>>>>>>> f3f3f52fd33d8857a40e61cc42c0f040b8df97ac
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuperVillain other = (SuperVillain) obj;
<<<<<<< HEAD
		return Double.doubleToLongBits(bounty) == Double.doubleToLongBits(other.bounty)
				&& Objects.equals(name, other.name) && Objects.equals(superPower, other.superPower);
	}
	
	
	
	
	
=======
		if (Double.doubleToLongBits(bounty) != Double.doubleToLongBits(other.bounty))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (superPower == null) {
			if (other.superPower != null)
				return false;
		} else if (!superPower.equals(other.superPower))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SuperVillain [name=" + name + ", superPower=" + superPower + ", bounty=" + bounty + "]";
	}

>>>>>>> f3f3f52fd33d8857a40e61cc42c0f040b8df97ac
	
}
