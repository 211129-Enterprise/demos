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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="addresses")
@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
	private int id;
	
	private @NonNull String street;
	
	private @NonNull String secondary; // Apt #
	
	@Length(min=2, max=2)
	private @NonNull String state; // IL
	
	private @NonNull String city;
	
	private @NonNull String zip; 
	
	@ManyToMany(mappedBy="addresses")
	private @NonNull Set<User> owners;
	
	
}
