package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
// consumer, supplier, predicate functional interfaces

public class Theatre {

	private final String theatreName;
	private List<Seat> seats = new ArrayList<>();

	public Theatre(String theatreName, int numRows, int seatsPerRow) {

		this.theatreName = theatreName;
		
		// we will construct all of the seats that exist within  the theatre
		int lastRow = 'A' + (numRows - 1); // A01 - A12, H01 - H12
		
		for (char row = 'A'; row <= lastRow; row++) {
			
			for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
				
				Seat seat = new Seat(row + String.format("%02d", seatNum)); // first seat would be A01,
				seats.add(seat);
			}
		}
	}
	
	// O(n) - Linear Time complexity
	public boolean reserveSeatBruteForce(String seatNumber) {
		
		// we will iterate through ALL the seats until we find the seat we're looking for
		Seat requestedSeat = null;
		
		for (Seat seat : seats) {
			
			System.out.println("searching...");
			
			if (seat.getSeatNumber().equals(seatNumber)) {
				
				// set the requestedSeat = to seat
				requestedSeat = seat;
				//then break
				break;
			}
		}
		// and then we'll reserve it
		
		// check is the requestedSeat is null
		if (requestedSeat == null) {
			
			// if so, say that there is no seat that you're requesting
			System.out.println("Sorry, there is no seat " + seatNumber);
			return false;
		}
			
		
		// return the requestedSeat.reserve();
		return requestedSeat.reserve(); // this will call that seat's reserve method.
	}

	public void getSeats() {
		
		// Goal: print all the seats returned when I call getSeats()
		
		// Here I'm applying a lambda function to specify the implementation of the accept() method
		// which is the abstract method I must implement within the forEach method of the Iterable interface
//		seats.forEach((seat) -> {
//			// this is a multi-line LAMBDA function
//			System.out.println(seat);
//			System.out.println("Multiple lines of code!");
//		});
//		
//		/**
//		 * arg list
//		 * arrow
//		 * body
//		 */
//		
//		// ===== single line LAMBDA function is like this: ============
		seats.forEach(seat -> System.out.println(seat));
		
		
		// ======== METHOD REFERENCES =========
//		seats.forEach(System.out::println); // method referencing 
		// here we're calling the method name within the class.
		
		
		
		// ====== ANONYMOUS CLASS ========
		// Consumer Interface is the only thing I need here, I can implement its accept() method by way
		// of the anonymous class implementing consume interface
		
//		seats.forEach(new Consumer<Seat>() {
//
//			@Override
//			public void accept(Seat t) {
//				System.out.println(t);
//				
//			}
//		});
		
		
//		for (Seat s : seats) {
//			System.out.println(s);
//		}
		
		
	}

	public String getTheatreName() {
		return theatreName;
	}

	/**
	 * Nesting classes is a way of logically grouping classes that only used in one
	 * place.
	 * 
	 * Nesting classes increases encapsulation, thus leading to more maintainable
	 * and readable code.
	 */
	private class Seat {
		
		private final String seatNumber; // G11, H03, etc...
		private boolean reserved = false;
		
		// All FINAL instance variables must be initialized in a constructor
		private Seat(String seatNumber) {
			this.seatNumber = seatNumber;
		}
		
		public boolean reserve() {
			
			if (!this.reserved) { // IF the reserved instance variable of a seat object is false, now its true
				
				this.reserved = true;
				
				System.out.println("Reservation of seat " + this.seatNumber + " confirmed.");
				return true;
			} else {
				System.out.println("Sorry it's reserved!");
				return false; // otherwise its already reserved
			}
			
		}
		

		public String getSeatNumber() {
			return seatNumber;
		}

		public boolean isReserved() {
			return reserved;
		}

		@Override
		public String toString() {
			return seatNumber;
		}
		
		// we'll create a reserve() method
		
			// we'll toggle that instance variable 
		
		
		
		
		
	}

}








