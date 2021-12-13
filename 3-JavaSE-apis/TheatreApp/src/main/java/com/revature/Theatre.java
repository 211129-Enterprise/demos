package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
// Consumer, supplier, predicate functional interfaces

public class Theatre {
	
	private final String theatreName;
	private List<Seat> seats = new ArrayList<Seat>();
		
	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		
		this.theatreName = theatreName;
		
		// we will construct all of the seats that exist within the theatre
		int lastRow = 'A' + (numRows - 1); // A01 - A12, H01 - H12
		
		for (char row = 'A'; row <= lastRow; row++) {
			
			for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
				
				Seat seat = new Seat(row + String.format("%02d", seatNum)); // first seat would be A01...
				seats.add(seat);
			}
		}
	}
	
	// 0(n) - Linear time complexity
	public boolean reserveSeatBruteForce(String seatNumber) {
		
		// we will iterate through ALL the seats until we find the seat we're requesting
		Seat requestedSeat = null;
		
		for (Seat seat : seats) {
			System.out.println("Searching...");
			
			if (seat.getSeatNumber().equals(seatNumber)) {
				// set the requested Seat = to seat
				requestedSeat = seat;
				break;
			}
			
		}
		// and then reserve it
		
		// check if the requestedSeat is null
		if (requestedSeat == null) {
			// if so, say there is no seat that you're requesting
			System.out.println("Sorry, there is no seat " + seatNumber);
			return false;
		}
		
		
		return requestedSeat.reserve();
	}
	
	public void getSeats() {
		
		// Goal: print all the seats returned when I call getSeats()
		
		/**
		 * Here I'm applying a lambda function to specify the implementation of the accept() method
		 * which is the abstract method I must implement within the forEach method of the Iterable interface
		 */
		// ======== multi-line lambda function ======
//		seats.forEach(seat -> {
//			System.out.println(seat);
//			System.out.println("===");
//		});
		
		/**
		 * arg list
		 * arrow
		 * body
		 */
		// ====== single line lambda ==========:
		seats.forEach(seat -> System.out.println(seat));
		
		// ====== method referencing =========
//		seats.forEach(System.out::println);
		// here we're calling the method name within the class
		
		/* ====== Anonymous class =======
		 * Consumer interface is the only thing I need here, I can implement its accept method by way of 
		 * of the anonymous class imlementing consumer interface
		 */
//		seats.forEach(new Consumer<Seat>() {
//			
//			@Override
//			public void accept(Seat t) {
//				System.out.println(t);
//			}
//		});
		
		//		for (Seat s : seats) {
//			System.out.println(s);
//		}
	}

	public String getTheatreName() {
		return theatreName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(theatreName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Theatre other = (Theatre) obj;
		return Objects.equals(theatreName, other.theatreName);
	}

	@Override
	public String toString() {
		return "Theatre [theatreName=" + theatreName + "]";
	}
	
	/**
	 * Nesting classes is a way of logically grouping classes 
	 * that are only used in one place.
	 * 
	 * Nesting classes increases encapsulation, thus leading to more maintainable
	 * and readable code.
	 */
	
	private class Seat {
		
		// All final instance variables must be initialized in a constructor
		private final String seatNumber;
		private boolean reserved = false;
		
		private Seat (String seatNumber) {
			this.seatNumber = seatNumber;
		}
		
		public String getSeatNumber() {
			return seatNumber;
		}
		
		public boolean isReserved() {
			return reserved;
		}
		
		public boolean reserve() {
		
			if (!this.reserved)  { //IF not reserved, reserve it.
				this.reserved = true;
				System.out.println("Reservation of " + this.seatNumber + " confirmed.");
				return true;
			} else {
				System.out.println("Sorry, " + this.seatNumber + " is already reserved.");
				return false; // otherwise it's already reserved
			}
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(reserved, seatNumber);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Seat other = (Seat) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return reserved == other.reserved && Objects.equals(seatNumber, other.seatNumber);
		}

		private Theatre getEnclosingInstance() {
			return Theatre.this;
		}

		@Override
		public String toString() {
			return seatNumber;
		}
		
		
		// we'll create a reserve() method
		
			//we'll toggle that instance variable
		
	}	
		
}

