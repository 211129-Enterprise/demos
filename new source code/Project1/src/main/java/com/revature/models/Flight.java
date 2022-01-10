package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="flight")
public class Flight {

	
	@Id
	@Column(name="Flight_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int flightid;
	
	@Column(name="flight_name", unique=true, nullable=false)
	private String flightname;
	
	@Column(name="flight_type", nullable=false)
	private String flighttype;
	
	@Column(name="source", nullable=false)
	private String source;
	
	@Column(name="destination", nullable=false)
	private String destination;
	
	public Flight() {
		
	}

	public Flight(int flightid, String flightname, String flighttype, String source, String destination) {
		super();
		this.flightid = flightid;
		this.flightname = flightname;
		this.flighttype = flighttype;
		this.source = source;
		this.destination = destination;
	}

	public Flight(String flightname, String flighttype, String source, String destination) {
		super();
		this.flightname = flightname;
		this.flighttype = flighttype;
		this.source = source;
		this.destination = destination;
	}

	public int getFlightid() {
		return flightid;
	}

	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}

	public String getFlightname() {
		return flightname;
	}

	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}

	public String getFlighttype() {
		return flighttype;
	}

	public void setFlighttype(String flighttype) {
		this.flighttype = flighttype;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Flight [flightid=" + flightid + ", flightname=" + flightname + ", flighttype=" + flighttype
				+ ", source=" + source + ", destination=" + destination + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(destination, flightid, flightname, flighttype, source);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		return Objects.equals(destination, other.destination) && flightid == other.flightid
				&& Objects.equals(flightname, other.flightname) && Objects.equals(flighttype, other.flighttype)
				&& Objects.equals(source, other.source);
	}

	
}
