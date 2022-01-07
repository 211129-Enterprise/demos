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
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="addresses")
@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor // Gen constructor w/o id
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
	@JsonView({JsonViewProfile.User.class, JsonViewProfile.Address.class})
	private int id;
	
	private @NonNull String street; // 22 Pine Street
	
	private @NonNull String secondary; // Apt 3.
	
	@Length(min=2, max=2)
	private @NonNull String state; // NJ
	
	private @NonNull String city; // Trenton
	
	private @NonNull String zip; // 07033
	
	@ManyToMany(mappedBy="addresses") // This will be the name of the property in User.java
	@JsonView(JsonViewProfile.User.class)
	private @NonNull Set<User> owners; // Create an addresses field in the User class

}
