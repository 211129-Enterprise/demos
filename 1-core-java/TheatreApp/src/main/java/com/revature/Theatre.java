package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

//Consumer, supplier, predicate functional interfaces

public class Theatre {
	private final String theatreName;
	private List<Seat> seats = new ArrayList<Seat>();
	
	//ALL FINAL instance variables must be initialized in a constructor

	//Constructor for Theatre =====================================================================================
	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		this.theatreName = theatreName;
		//we will construct all seats that exist within the theatre
		int lastRow = 'A' + (numRows -1); //A01 - A12, H01 - H12
		
		for (char row = 'A'; row <= lastRow; row++) {
			for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
				Seat seat = new Seat(row + String.format("%02d", seatNum));
				seats.add(seat);
			}
		}
	}
	
	public boolean reserveSeatBinary(Seat seatToReserve) { //overloaded method
		int low= 0;
		int high = seats.size() -1; 
		while (low <= high) {
			System.out.println("Searching.....");
			int mid = (low + high) / 2; 
			Seat midSeat = seats.get(mid);
			int comparison = midSeat.compareTo(seatToReserve);
			if (comparison <0) { 
				low = mid +1; 
			} else if (comparison > 0) {
				high = mid -1; 
			} else {
				return seats.get(mid).reserve();
			}
 		}
		System.out.println("There is no seat.");
		return false;
	}
	
	public boolean reserveSeatBinary(String seatNumber) {
		//binary search only works on sorted lists
		int low= 0;
		int high = seats.size() -1; //equals to how many seats are in the theatre
		
		while (low <= high) {
			System.out.println("Searching.....");
			int mid = (low + high) / 2; //this represents the index im looking for. I need to find the SEAT at the middle index
			Seat midSeat = seats.get(mid);
			//System.out.println("THE MIDDLE SEAT IS " + midSeat);
			int comparison = midSeat.getSeatNumber().compareTo(seatNumber);
			//The seatNumber is of type String.... String automatically implements the Comparable interface which the compareTo method
			//compareTo() returns 0, if equals, 1 if greater than, and -1 if less than
			if (comparison <0) { //lets say D12 is the mid point that's found, that's technically less than 
				low = mid +1; //discard the LHS
			} else if (comparison > 0) {
				high = mid -1; //discard the RHS
			} else {
				return seats.get(mid).reserve();
			}
 		}
		System.out.println("There is no seat.");
		return false;
	}
	
	//O(n) --Linear time complexity -- this can be simplified. 
	public boolean reserveSeatBruteForce(String seatNumber) {
		//we will iterate through all the seats until we find the seat we are looking for then we'll reserve it.
		Seat requestedSeat = null;
		for (Seat seat : seats) {
			System.out.println("Searching....");
			if (seat.getSeatNumber().equals(seatNumber)) {
				//seat the requestedSeat = to seat
				requestedSeat = seat;
				break;
			}
		}
		//check if the requestedSeat is null
		if (requestedSeat == null) {
			System.out.println("Sorry, there is no seat " + seatNumber);
			return false;
		}
		//and we'll reserve it
		return requestedSeat.reserve();
	}
	
	//Getters and Setters ============================================================================================
	public void getSeats() { //getters was change from <theatre> to void just to print out the seats method.
		//Goal is print all the seats returned when I call getSeats(), old way was enhanced for loop.
//		for (Seat s : seats) {
//			System.out.println(s); //old method
		
//		seats.forEach(new /*_anonymous_*/ Consumer<Seat>() { //complicated way to print the seats. We use them to define the 
//			public void accept(Seat t) {   //class. Consumer interface is the only way here. We can implement it's accept method by
//				System.out.println(t);     //way of the anonymous class implementing consume interface
//			}
//		});
		
		seats.forEach(seat -> System.out.println(seat)); //Here we're applying a lambda function to specify the implementation
								//of the accept method which is the accept method I must implement within the for-each method
								//of the Iterable interface.
		//multiple-line lambda function
//		seats.forEach(seat -> {
//			System.out.println(seat);
//			System.out.println("Multiple lines of code");
//		});
		/*
		 * arg list
		 * arrow
		 * body
		 */
		//METHOD referencing
//------seats.forEach(System.out::println);
		//here we're calling the method name within the class. Can only use this when you have ONE method parameter
		//https://www.javatpoint.com/java-8-method-reference
	
	}
	
//	public void setSeats(List<Seat> seats) {
//		this.seats = seats;
//	} deleted 
	public String getTheatreName() {
		return theatreName;
	}
	
	/* =================SEAT CLASS=============================================================================================
	 * Nesting classes is a way of logically grouping classes that only
	 * used in one place
	 * 
	 * nesting classes increases encapsulation, thus leading to more maintainable code.
	 * 
	 * Comparable interface is used to order the objects of a user defined class. Think of the compareTo() method to 
	 */
	protected class Seat implements Comparable<Seat> {
		
		private final String seatNumber;
		private boolean reserved = false;
		
		Seat(String seatNumber) {
			this.seatNumber = seatNumber;
		}
		
		@Override
		public int compareTo(Seat anotherSeat) {
			
			return this.seatNumber.compareToIgnoreCase(anotherSeat.getSeatNumber());
		}
		
		
		public boolean reserve() { //IF the reserved seat method instance variable of the seat object is false, now its true.
			if (!this.reserved) {
				this.reserved = true;
				System.out.println("Reservation of seat " + this.seatNumber + " confirmed.");
				return true;
			} else {
				return false; //otherwise it's already reserved.
			}
		}
		
		
		
		//Getters and Setters ==========================================================================================
		public String getSeatNumber() {
			return seatNumber;
		}
		public boolean isReserved() {
			
			
			return reserved;
		}
		//we'll create a reserve() method
		//we'll toggle rgar instance variable

		//toString ========== ============================================================================================
		@Override
		public String toString() {
			return "Seat [seatNumber=" + seatNumber + "]";
		}

		//returns 0 if the object its being compared to, 1 if greater than, -1 if less than.
		
		
	}
	
	
	
	
	
}
