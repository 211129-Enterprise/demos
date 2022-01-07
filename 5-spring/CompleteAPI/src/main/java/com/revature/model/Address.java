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
	
	private @NonNull String street; // 123 Fake Street
	private @NonNull String secondary; // apt 0
	
	@Length(min=2, max=2)
	private @NonNull String state; // nj
	
	private @NonNull String city; // Trenton
	
	private @NonNull String zip; // 07033-1028
	
	@ManyToMany(mappedBy="addresses")
	private @NonNull Set<User> owners; // create an addresses field in User Class
}
