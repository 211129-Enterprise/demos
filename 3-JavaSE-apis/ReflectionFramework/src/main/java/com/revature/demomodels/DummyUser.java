package com.revature.demomodels;

import java.util.Objects;

import com.revature.annotations.Column;
import com.revature.annotations.Entity;
import com.revature.annotations.Id;
import com.revature.annotations.JoinColumn;

@Entity(tableName="users")
public class DummyUser {
	
	@Id(columnName="user_id") // this has been marked as a primary key
	private int id;
	
	@Column(columnName="first_name")
	private String firstName;
	
	@Column(columnName="last_name")
	private String lastName;
	
	@JoinColumn(columnName="test_relation")
	private DummyOtherClass testRelation;
	
	//Foreign Key
	
	public DummyUser() {
		
	}

	public DummyUser(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public DummyUser(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DummyUser other = (DummyUser) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		return "DummyUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	
}
