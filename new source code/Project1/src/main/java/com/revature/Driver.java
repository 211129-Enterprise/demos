package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.BookingDAO;
import com.revature.dao.CustomerDAO;
import com.revature.dao.FlightDAO;
import com.revature.inspection.ClassInspector;
import com.revature.models.Booking;
import com.revature.models.Customer;
import com.revature.models.Flight;

public class Driver {
	
	static FlightDAO fdao = new FlightDAO();

	public static void main(String[] args) {
		
//		ClassInspector CI = new ClassInspector();
//		CI.listPublicMethods(Customer.class);
//		CI.listPublicMethods(Flight.class);
//		CI.listPublicMethods(Booking.class);
		
		System.out.println("Running our Hibernae Demo");

		
		Flight f1 = new Flight("SouthWest", "Domestic", "New York", "Atlanta");
		Flight f2 = new Flight("Delta", "Domestic", "Atlanta", "New York");
		Flight f3 = new Flight("AirCanada", "International", "Los Angelos", "Toronto");
		
		fdao.insert(f1);
		fdao.insert(f2);
		fdao.insert(f3);
		
		List<Flight> flights = new ArrayList<Flight>();
		
		flights.add(f1);
		flights.add(f3);
		
		Booking early = new Booking(458, 474, "Business", 600, "Apr-1-2022");
		
		Customer adam = new Customer("Adam", "Johnson", flights);
		
		BookingDAO bdao = new BookingDAO();
		bdao.insert(early);
		
		CustomerDAO cdao = new CustomerDAO();
		cdao.insert(adam);
		
	}

}
