package com.revature.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="super_villains")
public class SuperVillain {
	@Id
	@Column(name="svill_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sVillId;
	
	@Column(name="svill_name", unique=true, nullable=false)
	private String sVillName;
	@Column(name="super_power")
	private String superPower;
	
	private double bounty; // this will automatically be generated as a column called "bounty"
	
	// separate joins table would best describe this relationship
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY) // Lazy fetching means that the data won't be loaded into memory until we call getCrimes();
	private List<Crime> crimes;
	
	// This will be a foreign key pointing to some record of a SuperPrison in our SuperPrisons table
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="prison_fk")
	private SuperPrison superPrisonHolder; // this is a foreign key pointing to the superprison where the supervillain
	
	public SuperVillain() {
		
	}

	public SuperVillain(String sVillName, String superPower, double bounty, List<Crime> crimes,
			SuperPrison superPrisonHolder) {
		super();
		this.sVillName = sVillName;
		this.superPower = superPower;
		this.bounty = bounty;
		this.crimes = crimes;
		this.superPrisonHolder = superPrisonHolder;
	}
	
	public SuperVillain(int sVillId, String sVillName, String superPower, double bounty, List<Crime> crimes,
			SuperPrison superPrisonHolder) {
		super();
		this.sVillId = sVillId;
		this.sVillName = sVillName;
		this.superPower = superPower;
		this.bounty = bounty;
		this.crimes = crimes;
		this.superPrisonHolder = superPrisonHolder;
	}

	public int getsVillId() {
		return sVillId;
	}

	public void setsVillId(int sVillId) {
		this.sVillId = sVillId;
	}

	public String getsVillName() {
		return sVillName;
	}

	public void setsVillName(String sVillName) {
		this.sVillName = sVillName;
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

	public List<Crime> getCrimes() {
		return crimes;
	}

	public void setCrimes(List<Crime> crimes) {
		this.crimes = crimes;
	}

	public SuperPrison getSuperPrisonHolder() {
		return superPrisonHolder;
	}

	public void setSuperPrisonHolder(SuperPrison superPrisonHolder) {
		this.superPrisonHolder = superPrisonHolder;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(bounty, crimes, sVillId, sVillName, superPower, superPrisonHolder);
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
				&& Objects.equals(crimes, other.crimes) && sVillId == other.sVillId
				&& Objects.equals(sVillName, other.sVillName) && Objects.equals(superPower, other.superPower)
				&& Objects.equals(superPrisonHolder, other.superPrisonHolder);
	}

	@Override
	public String toString() {
		return "SuperVillain [sVillId=" + sVillId + ", sVillName=" + sVillName + ", superPower=" + superPower
				+ ", bounty=" + bounty + ", crimes=" + crimes + ", superPrisonHolder=" + superPrisonHolder + "]";
	}
	
	
	
}
