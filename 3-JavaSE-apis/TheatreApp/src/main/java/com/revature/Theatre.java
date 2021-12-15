package com.revature;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;
// consumer, supplier, predicate


public class Theatre {
	private final String theatreName;
	
	
	// SOPHIAQUESTION when changing arraylist to hashset, why does it not work?
	private List<Seat> seats = new ArrayList<>();

	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		this.theatreName = theatreName;
		
		int lastRow = 'A' + (numRows - 1);
		
		for (char row = 'A'; row <= lastRow; row++) {
			for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
			Seat seat = new Seat(row + String.format("%02d", seatNum));
			seats.add(seat);
			}
		}
	}
	// SOPHIAQUESTION if we only know recursion binary search and not brute force, are we ok for code audit?
	public boolean researchSeatBinary(String seatNumber) {
		
		int low = 0;
		
		int high = seats.size() - 1;
		
	    while (low <= high) {
	    	int mid = (low + high) / 2;
	    	Seat midSeat = seats.get(mid);
	    	System.out.println("THE MIDDLE SEAT IS" + midSeat);
	    	
	    	int cmp = midSeat.getSeatNumber().compareTo(seatNumber);
	    	
	    	if (cmp == -1) {
	    		low = mid + 1;
	    	} else if (cmp == 1) {
	    		high = mid -1;
	    	} else {
	    		return seats.get(mid).reserve();
	    	}
	    }
		
		return false;
	}
	
	// O(n) linear time complexity
	public boolean researveSeatBruteForce(String seatNumber) {
		// we will iterate through all the seats until we find the seat we're looking for
		Seat requestedSeat = null;
		
		for(Seat seat : seats) {
			System.out.println("searching...");
			if(seat.getSeatNumber().equals(seatNumber)) {
				// set the requestedSeat = to seat
				requestedSeat = seat;
				
				break;
			}
		}
		
		if (requestedSeat == null) {
			System.out.println("sorry, there is no seat " + seatNumber);
			return false;
		}
		// and then we'll check if it's reserved
		return requestedSeat.reserve();
	}
	


	public void getSeats() {
//		for (Seat s : seats) {
//			System.out.println(s);
//		}
		
		// first arguement is an abstract method called the accept method
//		seats.forEach(seat -> {
//			System.out.println(seat);
//			System.out.println("Multiple lines of code!");
//		});
		
		seats.forEach(seat -> System.out.println(seat));
		
		// lambdas have arg list, arrow, body
		
		// Method referencing
//		seats.forEach(System.out::println);
		
		
		
		// ANONYMOUS CLASS
		// CONSUMER interface is the only thing i need here
		// I can implement its accept() of the anonymous class implementing consume interface
		
//		seats.forEach(new Consumer<Seat>() {
//			@Override
//			public void accept(Seat t) {
//				System.out.println(t);
//			}
//		});
		
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public String getTheatreName() {
		return theatreName;
	}

	// nesting classes increases encapsulation
	private class Seat implements Comparable<Seat> {
		private final String seatNumber;
		private boolean reserved = false;
		
	
		
		public boolean reserve() {
			if (!this.reserved) {
				this.reserved = true;
				System.out.println("Reservation of seat" + seatNumber + " confirmed.");
				return true;
			} else {
				System.out.println("this seat is already reserved" + seatNumber);
				return false; // otherwise it's already reserved
			}
		}
		
		

		private Seat(String seatNumber) {
			this.seatNumber = seatNumber;
		}

		public String getSeatNumber() {
			return seatNumber;
		}

		public boolean isReserved() {
			return reserved;
		}

		@Override
		public String toString() {
			return "Seat [seatNumber=" + seatNumber + ", reserved=" + reserved + "]";
		}



		@Override
		public int compareTo(Seat anotherSeat) {
			return this.seatNumber.compareToIgnoreCase(anotherSeat.getSeatNumber());
		}
		
		

	}
}
