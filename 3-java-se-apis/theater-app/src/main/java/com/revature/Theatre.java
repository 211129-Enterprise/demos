package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Theatre {
	
/* CLASS VARIABLES */	
	private final String theatreName;
	
	private List<Seat> seats = new ArrayList<>();
	//private Set<Seat> seats = new HashSet<>(); // Arbitrary order / no insertion order
	//private Set<Seat> seats = new LinkedHashSet<>(); // Will maintian insertion order, but a little more difficult to iterate through
	
	
/* CONSTRUCTOR */	
	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		
		this.theatreName = theatreName;
		
		// we will construct all of the seats that exist within the theatre.
		int lastRow = 'A' + (numRows - 1); // Range like: 01 - A12, H01 - H12
		
		for(char row = 'A'; row <= lastRow; row++) {
			
			for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
				
				Seat seat = new Seat(row + String.format("%02d", seatNum)); // First seat would be A01, A02, etc
				seats.add(seat);
			}
			
		}
	}


/* GETTERS & SETTERS */
	
	// As of now, it's operating in O(n) LINEAR time complexity
	public boolean reserveSeatBruteForce(String seatNumber) {
		
		// We'll iterate through ALL the seats until we find
		// the seats we're requesting and then we'll
		// reserve it.
		Seat requestedSeat = null;
		
		for(Seat seat : seats) {
			System.out.println("Searching...");
			
			if(seat.getSeatNumber().equals(seatNumber)) {
				
				//set the requested seat = to seat
				requestedSeat = seat;
				
				//then break
				break;
			}
			
		}
		
		// and then we'll reserve it
		
		//check if the requestedSeat is null
		if(requestedSeat == null) {
			// if so, say there is no seat that you are requesting
			System.out.println("Sorry, there is no seat " + seatNumber); 
		}

		// else, return the requestedSeat.reserve();
		return requestedSeat.reserve(); // This will call the seat's reserve method.
	}
	
	
	//REMEMBER: Binary search only works on a sorted list
	// e.g. 1, 34, 54, 394, 2003, etc
	public boolean reserveSeatBinary(String seatNumber) {
		
		int low = 0;
		int high = seats.size() - 1; // Equals HOW MANY seats are in the theatre
		
		while (low <= high) {
			
			int mid = (low + high) / 2; // This represents the index I am looking for.

			// I'll need to find the SEAT at that middle index.
			Seat midSeat = seats.get(mid);
			System.out.println("Looking at " + midSeat + ".");
			
			// How do I check whether my TARGET seat is greater than or less than the middle value?
			int comparison = midSeat.getSeatNumber().compareTo(seatNumber);
			
			// The seatNumber is of type String.... String automatically implements the Comparable interface
			// which overrides the compareTo() method.
			
			// compareTo() returns 0, if equal, 1 if greather than, and -1 if less than
			if(comparison < 0) {
				low = mid + 1; // Discard the LHS
			
			} else if(comparison > 0) {
				high = mid - 1; // Discard the RHS
			
			} else {
				return seats.get(mid).reserve(); // The target is found
				
			}
			
		}
		
		System.out.println("There is no seat " + seatNumber);
		return false;

	}
	
	//OVERLOADED reserveSeatBinary
	// Using object comparison using compareTo
	public boolean reserveSeatBinary(Seat seatToReserve) {
		
		// Alternatively, you could just instantiate the seat here from the seatNumber.
		
		int low = 0;
		int high = seats.size() - 1; // Equals HOW MANY seats are in the theater
		
		while (low <= high) {
			
			int mid = (low + high) / 2; // This represents the index I am looking for.

			// I'll need to find the SEAT at that middle index.
			Seat midSeat = seats.get(mid);
			System.out.println("Looking at " + midSeat + ".");
			
			// How do I check whether my TARGET seat is greater than or less than the middle value?
			int comparison = midSeat.compareTo(seatToReserve);
			
			// The seatNumber is of type String.... String automatically implements the Comparable interface
			// which overrides the compareTo() method.
			
			// compareTo() returns 0, if equal, 1 if greather than, and -1 if less than
			if(comparison < 0) {
				low = mid + 1; // Discard the LHS
			
			} else if(comparison > 0) {
				high = mid - 1; // Discard the RHS
			
			} else {
				return seats.get(mid).reserve(); // The target is found
				
			}
			
		}
		
		System.out.println( "There is no seat " + seatToReserve.getSeatNumber() );
		return false;
	}
	
	
	
	
	public void getSeats() {
		
		
		// Print all the seats returned when I call getSeats()
		
		// TRADITIONAL forEach example
//		for(Seat s : seats) {
//			System.out.println(s);
//		}
		
		
		
		// LAMBDA example
		// Lambda consists of a parameter, arrow, and action to be called
		// Below is an example of a lambda function to specify the implementation
		// of the accept() method which is the abstract method I must implement
		// within the forEach method of the Iterable interface
		seats.forEach(seat -> System.out.println(seat));
		/* A LAMBDA consists of three things:
		 * arg list ( seat object)
		 * arrow ( -> )
		 * body ( System.out.println(seat) )
		 * 
		 * 
		 * MULTI-LINE LAMBDA
		 * seats.forEach(seat) -> {
		 * 		System.out.println(seat);
		 * 		System.out.println("Multiple lines of code!");
		 * });
		 * 
		 * 
		 * SINGLE-LINE LAMBDA
		 * seats.forEach(seat -> System.out.println(seat));
		 * 
		 */
		
		
		
		// ANONYMOUS CLASS example
		// You might also use an anonymous class...
		// The consumer interface is the only thing I need here.
		// I can implement its accept method by way of the anonymous class implementing
		// the Consumer interface
//		seats.forEach(new Consumer<Seat>() {
//
//			@Override
//			public void accept(Seat t) {
//				
//				System.out.println(t);
//				
//			}
//						
//		});
		
		
		
		// METHOD REFERENCING example
		// It allows you to refer to a method like a variable by 
		// calling its signature instead.
//		seats.forEach(System.out::println); // Method referencing using ::
		// Here, we're calling the method name within the class.
		//
		// Read more: https://www.javatpoint.com/java-8-method-reference
		

		
	}


	public String getTheatreName() {
		return theatreName;
	}
	

	

/* NESTED CLASS */
/*
 * Only the theatre class can modify seat objects.
 * 
 * Nesting classes is a way of logically grouping
 * classes that are only used in one place.
 * 
 * Nesting classes also increases encapsulation,
 * which leads to more maintainable and readable code.
 * 
 * Comparable Interface is used to order the objects of a user defined class.
 * Think of the compareTo() method as the default comparison strategy for a class.
 */
	private class Seat implements Comparable<Seat>{
		
		private final String seatNumber; // Could be: G11, H03, etc
		private boolean isReserved = false;
		
		
		
		//ALL final instance variables must be initialized in a constructor
		private Seat(String seatNumber) {
			this.seatNumber = seatNumber;
		}
		
		
		
		
		// CONSIDER this for compareTo method: 
		// private String boxLevel;
		
		@Override // Returns 0 if the object its being compared to is equal, 1 if greater than, and -1 if less than
		public int compareTo(Seat anotherSeat) {
			
			//CONSIDER: return.this.boxLeve.compareToIgnoreCase(anotherSeat.getBoxLevel());
			return this.seatNumber.compareToIgnoreCase(anotherSeat.getSeatNumber());
		}
		
		
		
		
		// We'll create a reserve() method...
		// We'll toggle that instance variable.
		public boolean reserve() {
			
			if(!this.isReserved) { // IF the isReserved instance variable of a seat is false, return true
				this.isReserved = true;
				
				System.out.println("Reservation of seat " + this.seatNumber + " confirmed.");
				return true;
				
			} else {
				
				System.out.println("Sorry, seat " + this.seatNumber + " is already reserved.");
				return false;
			}
		}

		
		
		
		
		public String getSeatNumber() {
			return seatNumber;
		}

		
		
		
		public boolean isReserved() {
			return isReserved;
		}
		
		
		
		
		@Override
		public String toString() {
			return "Seat [seatNumber=" + seatNumber + ", isReserved=" + isReserved + "]";
		}


		
	}




	
/* OVERRIDES */
	@Override
	public String toString() {
		return "Theatre [theatreName=" + theatreName + ", seats=" + seats + "]";
	}

}
