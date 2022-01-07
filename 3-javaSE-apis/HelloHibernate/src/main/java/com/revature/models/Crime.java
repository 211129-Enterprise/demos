package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// JPA is the Java Persistance API

@Entity
@Table(name="crimes") // now the table will show up as "crimes" instead of crime (the name of the class) in the database
public class Crime {
	
	@Id // ID Annotation specifies primary key
	@Column(name="crime_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)// this is equivalent to the Serial keyword 
	private int crimeId;
	@Column(name="crime_name",unique=true, nullable=false) // setting extra constraints to the column
	private String crimeName;
	//This will automatically be created as a column called "description"
	private String description;
	
	// 3 constructors: no-args, without id, with id
	public Crime() {
		
	}
	
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

	@Override
	public int hashCode() {
		return Objects.hash(crimeId, crimeName, description);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Crime other = (Crime) obj;
		return crimeId == other.crimeId && Objects.equals(crimeName, other.crimeName)
				&& Objects.equals(description, other.description);
	}

	@Override
	public String toString() {
		return "Crime [crimeId=" + crimeId + ", crimeName=" + crimeName + ", description=" + description + "]";
	}
	
	
}
