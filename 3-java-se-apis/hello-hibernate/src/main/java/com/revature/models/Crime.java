package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity; // <--- This is the JPA specification package
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// JPA is the Java Persistence API

@Entity
@Table(name="crimes") // Now the table will show up as "Crimes" instead of crime, the name of the class, in the database.
public class Crime {

	@Id // ID specifies a primary key
	@Column(name="crime_id") // The below would still be created as columns, but using @columns, we can specify stuff
	@GeneratedValue(strategy=GenerationType.IDENTITY) // This is equivalent to the SERIAL keyword
	private int crimeId;
	
	@Column(name="crime_name", unique=true, nullable=false) // Setting extra constraints specifically
	private String crimeName;
	
	// This will automatically create as a column called "description"
	private String description;

	
	// Three constructors: one with ID, one without an ID, one with no args
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
