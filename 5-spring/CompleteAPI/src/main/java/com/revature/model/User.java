package com.revature.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email; // Java Persistence API
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern; // JPA specification vs. Hibernate implementatino and Spring Data's role with both

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data // generates getters/setter, toString, hashCode, and equals() method automatically
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView({ JsonViewProfiles.User.class, JsonViewProfiles.Address.class })
	private int id;
	
	// make sure that the length of these fields is > 1
	@Length(min=2)
	private String firstName;
	private String lastName;
	
	@NotBlank
	@Length(min=5)
	@Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*") // use regex to make sure only alphanumeric chars allowed, no spaces
	private String username;
	
	@NotBlank
	private String password;
	
	@Email // from javax.validation.constraints this ensures every email property contains @
	private String email;
	
	// Here since we're defining the JoinTable in the user class, we declare that User.java OWNS the relationship
	
    @ManyToMany
	@JoinTable(name = "users_address",
    joinColumns = @JoinColumn(name= "user_id"),
    inverseJoinColumns = @JoinColumn(name = "address_id"))
    @JsonView(JsonViewProfiles.User.class)
	private Set<Address> addresses;

	public User(@Length(min = 1) String firstName, String lastName,
			@Length(min = 5) @NotBlank @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*") String username,
			@NotEmpty String password, @Email String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
	}

}
