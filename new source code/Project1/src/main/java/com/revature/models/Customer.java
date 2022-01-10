package com.revature.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Customer")
public class Customer {
	
	@Id
	@Column(name="customer_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerid;
	
	@Column(name="first_name", unique=true, nullable=false)
	private String firstname;
	
	@Column(name="last_name", unique=true, nullable=false)
	private String lastname;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Flight> flights; 
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="booking_fk")
	private Booking bookingHolder;
	
	public Customer() {
		
		
	}

	public Customer(int customerid, String firstname, String lastname, List<Flight> flights) {
		super();
		this.customerid = customerid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.flights = flights;
	}

	public Customer(String firstname, String lastname, List<Flight> flights) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.flights = flights;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", flights=" + flights + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerid, firstname, flights, lastname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return customerid == other.customerid && Objects.equals(firstname, other.firstname)
				&& Objects.equals(flights, other.flights) && Objects.equals(lastname, other.lastname);
	}
	
	
	
	
	
	
	

}
