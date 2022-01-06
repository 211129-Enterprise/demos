package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data //Generates getters / setters, toString, hashCode, and equals methods automatically
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Length(min=2)
	private String firstName, lastName;
	
	@NotBlank
	@Length(min=5)
	@Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*") // Use regex to make sure only alphanumeric chars allowed, no spaces
	private String username;
	
	@NotBlank
	//@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}[]:;<>,.?/~_+-=|\\]).{8,32}$")
	private String password;
	
	@Email
	private String email;

	public User(@Length(min = 2) String firstName, String lastName,
			@NotBlank @Length(min = 5) @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*") String username,
			@NotBlank String password, @Email String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	

	
/* * * * * * * * WITHOUT LOMBOK * * * * * * * */	
//	public User(String firstName, String lastName, String userName, String email) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.userName = userName;
//		this.email = email;
//	}	
//	
//	public User(int id, String firstName, String lastName, String userName, String email) {
//		super();
//		this.id = id;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.userName = userName;
//		this.email = email;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
//				+ ", email=" + email + "]";
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(email, firstName, id, lastName, userName);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		User other = (User) obj;
//		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName) && id == other.id
//				&& Objects.equals(lastName, other.lastName) && Objects.equals(userName, other.userName);
//	}
//	
	
	

}
