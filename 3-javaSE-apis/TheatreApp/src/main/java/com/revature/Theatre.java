package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
	
	public boolean reserveSeatBinary(Seat seatToReserve) {
		
		// binary search only works on a sorted list
		int low = 0;
		int high = seats.size() - 1; // equals to how many seats are in the theatre
		int count = 0;
		while (low <= high) {
			System.out.println("Searching... " + count + " times.");
			int mid = (low + high) / 2; // this represents index. Must finds eat at mid index
			Seat midSeat = seats.get(mid);
//			System.out.println("The middle seat is " + midSeat);			
			
			// How do I check whether my target seat is greater than or less than the mid seat?
			int cmp = midSeat.compareTo(seatToReserve);
			
			// The seatNumber is of type String. String automatically implements Comparable interface
			// which overrides the compareTo method.
			// compareTo() returns 0 if equal, 1 if greater than, -1 if less than.
			if (cmp < 0) {
				low = mid + 1;
				count++;
			} else if (cmp > 0) {
				high = mid - 1;
				count++;
			} else {
				return seats.get(mid).reserve();
			}
			
		}
		
		System.out.println("There is no seat " + seatToReserve.toString());
		return false;
	}
	public boolean reserveSeatBinary(String seatNumber) {
		
		// binary search only works on a sorted list
		int low = 0;
		int high = seats.size() - 1; // equals to how many seats are in the theatre
		int count = 0;
		while (low <= high) {
			System.out.println("Searching... " + count + " times.");
			int mid = (low + high) / 2; // this represents index. Must finds eat at mid index
			Seat midSeat = seats.get(mid);
//			System.out.println("The middle seat is " + midSeat);			
			
			// How do I check whether my target seat is greater than or less than the mid seat?
			int cmp = midSeat.getSeatNumber().compareTo(seatNumber);
			
			// The seatNumber is of type String. String automatically implements Comparable interface
			// which overrides the compareTo method.
			// compareTo() returns 0 if equal, 1 if greater than, -1 if less than.
			if (cmp < 0) {
				low = mid + 1;
				count++;
			} else if (cmp > 0) {
				high = mid - 1;
				count++;
			} else {
				return seats.get(mid).reserve();
			}
			
		}
		
		System.out.println("There is no seat " + seatNumber);
		return false;
	}
	
	// 0(n) - Linear time complexity
	public boolean reserveSeatBruteForce(String seatNumber) {
		
		// we will iterate through ALL the seats until we find the seat we're requesting
		Seat requestedSeat = null;
		int count = 0;
		
		for (Seat seat : seats) {
			System.out.println("Searching... " + count + " times.");
			count++;
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
		
		// return the requestedSeat.reserve();
		
		return requestedSeat.reserve(); //t his will call the seat's reserve method
		
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
	
	class Seat implements Comparable<Seat> {
		
		// All final instance variables must be initialized in a constructor
		private final String seatNumber;
		private boolean reserved = false;
		private String boxLevel;
		
		Seat (String seatNumber) {
			this.seatNumber = seatNumber;
		}
		
		public String getSeatNumber() {
			return seatNumber;
		}
		
		public String getBoxLevel() {
			return boxLevel;
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

		@Override
		public int compareTo(Seat anotherSeat) {
			
			return this.seatNumber.compareToIgnoreCase(anotherSeat.getSeatNumber());
		}
		
		
		// we'll create a reserve() method
		
			//we'll toggle that instance variable
		
	}	
		
}

