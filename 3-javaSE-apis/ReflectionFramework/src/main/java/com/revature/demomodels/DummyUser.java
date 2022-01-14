package com.revature.demomodels;

import com.revature.annotations.Column;
import com.revature.annotations.Entity;
import com.revature.annotations.Id;
import com.revature.annotations.JoinColumn;

@Entity(tableName="users")
public class DummyUser {

	@Id(columnName="user_id") // this has been marked as a Primary Key
	private int id;
	
	@Column(columnName="first_name")
	private String firstName;
	
	@Column(columnName="last_name")
	private String lastname;
	
	// this is an example of how we might define a property that serves as a foreign key
	@JoinColumn(columnName="test_relation")
	private DummyOtherClass testRelation;
	

	public DummyUser() {
		
		
	}
	
	public DummyUser(int id, String firstName, String lastname) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastname = lastname;
	}

	public DummyUser(String firstName, String lastname) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "DummyUser [id=" + id + ", firstName=" + firstName + ", lastname=" + lastname + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		return result;
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
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	
	
	
}
