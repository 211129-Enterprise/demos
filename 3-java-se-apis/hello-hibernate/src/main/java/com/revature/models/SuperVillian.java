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
@Table(name="super_villians")
public class SuperVillian {
	
	@Id
	@Column(name="svill_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int svillId;
	
	@Column(name="svill_name", unique=true, nullable=false)
	private String svillName;
	
	@Column(name="super_power")
	private String superPower;
	
	private double bounty; // This will automatically be generated as a column called "bounty"
	
	// Separate joins table would best describe this relationship
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY) // Lazy fetching means that the data won't be loaded into memory until we call getCrimes();
	private List<Crime> crimes; //Many-to-many relationship
	
	// This will be a foreign key pointing at some record of SuperPrison table
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="prison_fk")
	private SuperPrison superPrisonHolder; // This is a foreign key pointing to the super prision where the super villian is
	
	
	public SuperVillian() {
		
	}


	public SuperVillian(String svillName, String superPower, double bounty, List<Crime> crimes,
			SuperPrison superPrisonHolder) {
		super();
		this.svillName = svillName;
		this.superPower = superPower;
		this.bounty = bounty;
		this.crimes = crimes;
		this.superPrisonHolder = superPrisonHolder;
	}


	public SuperVillian(int svillId, String svillName, String superPower, double bounty, List<Crime> crimes,
			SuperPrison superPrisonHolder) {
		super();
		this.svillId = svillId;
		this.svillName = svillName;
		this.superPower = superPower;
		this.bounty = bounty;
		this.crimes = crimes;
		this.superPrisonHolder = superPrisonHolder;
	}


	public int getSvillId() {
		return svillId;
	}


	public void setSvillId(int svillId) {
		this.svillId = svillId;
	}


	public String getSvillName() {
		return svillName;
	}


	public void setSvillName(String svillName) {
		this.svillName = svillName;
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
		return Objects.hash(bounty, crimes, superPower, svillId, svillName);
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
				&& Objects.equals(crimes, other.crimes) && Objects.equals(superPower, other.superPower)
				&& svillId == other.svillId && Objects.equals(svillName, other.svillName);
	}


	@Override
	public String toString() {
		return "SuperVillian [svillId=" + svillId + ", svillName=" + svillName + ", superPower=" + superPower
				+ ", bounty=" + bounty + ", crimes=" + crimes + "]";
	}
	
	

}
