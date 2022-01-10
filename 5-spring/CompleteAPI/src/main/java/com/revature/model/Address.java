package com.revature.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="addresses")
@Data @NoArgsConstructor @AllArgsConstructor
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@EqualsAndHashCode(exclude = {"owners"}) @ToString(exclude= {"owners"}) // This is important to prevent Hibernate loop -> https://stackoverflow.com/questions/53540056/what-causes-spring-boot-fail-safe-cleanup-collections-to-occur
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
	@JsonView({ JsonViewProfiles.User.class, JsonViewProfiles.Address.class })
	private int id;
	
	private String street; // 22 Pine St.
	private String secondary; // Apt. 3
	
	@Length(min=2, max=2)
	private @NonNull String state; // NJ
	
	private String city; // Trenton
	private String zip; // 07033-0102

	@ManyToMany(mappedBy = "addresses") // this will be the name of the prop in User.java
	@JsonView(JsonViewProfiles.Address.class) // https://stackoverflow.com/questions/67886252/spring-boot-jpa-infinite-loop-many-to-many
	private Set<User> owners; // create an addresses field in the User class
	
	public Address(String street, String secondary, @Length(min = 2, max = 2) String state, String city) {
		super();
		this.street = street;
		this.secondary = secondary;
		this.state = state;
		this.city = city;
	}
}
