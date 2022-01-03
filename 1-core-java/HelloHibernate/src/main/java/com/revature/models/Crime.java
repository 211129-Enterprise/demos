package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity; // this is the JPA specification package
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// JPA is the java persistance api

@Entity
@Table(name="crimes")
public class Crime {
	
	@Id
	@Column(name="crime_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int crimeId;
	
	@Column(name="crime_name", unique=true, nullable=false)
	private String crimeName;
	
	private String description;
	
	public Crime() {
		
	}
	
	// 2 contructors, one with an id and one without

	public Crime(String crimeName, String description) {
		super();
		this.crimeName = crimeName;
		this.description = description;
	}

	public Crime(int crimeId, String crimeName, String description) {
		super();
		this.crimeId = crimeId;
		this.crimeName = crimeName;
		this.description = description;
	}

	public int getCrimeId() {
		return crimeId;
	}

	public void setCrimeId(int crimeId) {
		this.crimeId = crimeId;
	}

	public String getCrimeName() {
		return crimeName;
	}

	public void setCrimeName(String crimeName) {
		this.crimeName = crimeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
