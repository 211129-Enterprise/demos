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
	
	public boolean reserveSeatBinary(Seat seatToReserve) {
		
		int low = 0;
		int high = seats.size() -1; // equaLS TO HOW MANY seats are in the theatre
		
		while (low <= high) {
			
			System.out.println("searching...");
			int mid = (low + high) / 2; // thbis represents the index I'm looking for
			// I need to finc the SEAT at that middle index
			Seat midSeat = seats.get(mid);
			
//			System.out.println("THE MIDDLE SEAT IS" + midSeat);
			
			// How do I check whether my TARGET seat is greater than or less than the mid value?
			int comparison = midSeat.compareTo(seatToReserve);
			
			// The seatNumber is of type String.... String automatically implements the Comparable interface which
			// which the the compareTo() method
			
			// compareTo() returns 0, if equal, 1 if greater than , and -1 if less than
			if (comparison < 0) { // let's say D12 is the mid point that's found, that's technically less than 
				low = mid + 1; // discard the LHS
			} else if (comparison > 0) {
				high = mid -1;// discard the RHS
			} else {
				return seats.get(mid).reserve();
			}
		}
		
		System.out.println("There is no seat " + seatToReserve.getSeatNumber());
		return false;

	}
	
	public boolean reserveSeatBinary(String seatNumber) {
		
		// Alternatively you could just instantiate the seat here from the seatNumber
		
		// binary search only works on a sorted
		int low = 0;
		int high = seats.size() -1; // equaLS TO HOW MANY seats are in the theatre
		
		while (low <= high) {
			
			System.out.println("searching...");
			int mid = (low + high) / 2; // thbis represents the index I'm looking for
			// I need to finc the SEAT at that middle index
			Seat midSeat = seats.get(mid);
			
//			System.out.println("THE MIDDLE SEAT IS" + midSeat);
			
			// How do I check whether my TARGET seat is greater than or less than the mid value?
			int comparison = midSeat.getSeatNumber().compareTo(seatNumber);
			
			// The seatNumber is of type String.... String automatically implements the Comparable interface which
			// which the the compareTo() method
			
			// compareTo() returns 0, if equal, 1 if greater than , and -1 if less than
			if (comparison < 0) { // let's say D12 is the mid point that's found, that's technically less than 
				low = mid + 1; // discard the LHS
			} else if (comparison > 0) {
				high = mid -1;// discard the RHS
			} else {
				return seats.get(mid).reserve();
			}
		}
		
		System.out.println("There is no seat " + seatNumber);
		return false;
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
	 * 
	 * Comparable Interface is used to order the objects of a user defined class
	 * Think of the compareTo() method as the default comparison strategy for a class
	 */
	private class Seat implements Comparable<Seat>{ 
		
		private final String seatNumber; // G11, H03, etc...
		private boolean reserved = false;
		
		private String boxLevel;
		
		// All FINAL instance variables must be initialized in a constructor
		public Seat(String seatNumber) {
			this.seatNumber = seatNumber;
		}
		
		@Override // returns 0 is the object it's being compared to is equal, 1 if greater than, -1 if less than
		public int compareTo(Seat anotherSeat) {
			
			return this.seatNumber.compareTo(anotherSeat.getSeatNumber());
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

		public String getBoxLevel() {
			return boxLevel;
		}

		public void setBoxLevel(String boxLevel) {
			this.boxLevel = boxLevel;
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








