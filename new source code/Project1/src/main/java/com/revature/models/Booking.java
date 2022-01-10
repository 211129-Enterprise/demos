package com.revature.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Booking")
public class Booking {
	
	@Id
	@Column(name="booking_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookingid;
	
	@Column(name="customer_id")
	private int customerid; // Foreign key
	
	@Column(name="flight_id")
	private int flightid; // Foreign key
	
	@Column(name="travel_class")
	private String travelclass;
	
	@Column(name="flight_charge")
	private double flightcharge;
	
	@Column(name="booking_date")
	private String bookingdate;
	
	@OneToMany(mappedBy="bookingHolder", fetch=FetchType.LAZY)
	private List<Customer> customers = new ArrayList<Customer>();
	
	
	public Booking() {
		
	}


	public Booking(int bookingid, int customerid, int flightid, String travelclass, double flightcharge,
			String bookingdate, List<Customer> customers) {
		super();
		this.bookingid = bookingid;
		this.customerid = customerid;
		this.flightid = flightid;
		this.travelclass = travelclass;
		this.flightcharge = flightcharge;
		this.bookingdate = bookingdate;
		this.customers = customers;
	}
	
	


	public Booking(int customerid, int flightid, String travelclass, double flightcharge, String bookingdate) {
		super();
		this.customerid = customerid;
		this.flightid = flightid;
		this.travelclass = travelclass;
		this.flightcharge = flightcharge;
		this.bookingdate = bookingdate;
	}


	public Booking(int customerid, int flightid, String travelclass, double flightcharge, String bookingdate,
			List<Customer> customers) {
		super();
		this.customerid = customerid;
		this.flightid = flightid;
		this.travelclass = travelclass;
		this.flightcharge = flightcharge;
		this.bookingdate = bookingdate;
		this.customers = customers;
	}


	public int getBookingid() {
		return bookingid;
	}


	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}


	public int getCustomerid() {
		return customerid;
	}


	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}


	public int getFlightid() {
		return flightid;
	}


	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}


	public String getTravelclass() {
		return travelclass;
	}


	public void setTravelclass(String travelclass) {
		this.travelclass = travelclass;
	}


	public double getFlightcharge() {
		return flightcharge;
	}


	public void setFlightcharge(Double flightcharge) {
		this.flightcharge = flightcharge;
	}


	public String getBookingdate() {
		return bookingdate;
	}


	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}


	public List<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


	@Override
	public String toString() {
		return "Booking [bookingid=" + bookingid + ", customerid=" + customerid + ", flightid=" + flightid
				+ ", travelclass=" + travelclass + ", flightcharge=" + flightcharge + ", bookingdate=" + bookingdate
				+ ", customers=" + customers + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(bookingdate, bookingid, customerid, customers, flightcharge, flightid, travelclass);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return Objects.equals(bookingdate, other.bookingdate) && bookingid == other.bookingid
				&& customerid == other.customerid && Objects.equals(customers, other.customers)
				&& Objects.equals(flightcharge, other.flightcharge) && flightid == other.flightid
				&& Objects.equals(travelclass, other.travelclass);
	}
	
	
	

}
