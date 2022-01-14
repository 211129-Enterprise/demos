package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Theatre {
	private final String theatreName;
	private List<Seat> seats = new ArrayList<>();
	
	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		this.theatreName = theatreName;
		
		int lastRow = 'A'+ (numRows -1);
		
		for (char row = 'A'; row <= lastRow; row++) {
			for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
				Seat seat = new Seat(row + String.format("%02d", seatNum));
				seats.add(seat);
			}
		}
		
		//We will construct all the seats within the theater
		
	}
	
	public boolean reserveSeatBruteForce(String seatNumber) {
		//iterate over all seats until we find the seat we're looking for
		//then reserve it
		Seat requestedSeat = null;
		
		for (Seat seat: seats){
			System.out.println("searching..");
			
			if (seat.getSeatNumber().equals(seatNumber)) {
				//set the requestedSeat = to seat
				requestedSeat = seat;
				
				break;
			}
		}
		//and then we'll reserve it
		
		//check is the requestedSeat is null
		//if so the seat does not exist
		
		if (requestedSeat == null) {
			System.out.println("Sorry, there is no seat " + seatNumber);
			return false;
		}
		
		return requestedSeat.reserve();
	}
	
	public boolean reserveSeatBinary(String seatNumber) {
		int low =0;
		int high = seats.size() -1;
		
		while (low <= high) {
			int mid = (low + high) / 2;
			
			Seat midSeat = seats.get(mid);
			System.out.println("The middle seat is "+midSeat);
			
			int cmp = midSeat.getSeatNumber().compareTo(seatNumber);
			
			if (cmp < 0) {
				low = mid+1;
			} else if (cmp > 0) {
				high = mid - 1;
			} else {
				return seats.get(mid).reserve();
			}
		}
		System.out.println("There is no seat "+seatNumber);
		return false;
	}
	
	public void getSeats() {
		
		//The lambda function specifies the implementation of 
		//accept() which is the abstract method I must implement
		//Within the forEach method of the Iterable interface
		//seats.forEach((seat) -> {	
		//	System.out.println(seat);
		//	System.out.println("Multiple lines of code!");
		//});
		
		/*
		 * Arg list
		 * Arrow
		 * Body
		 */
		
		//Single line LAMBDA function is like
		seats.forEach(seat -> System.out.println(seat));
		
		//Method References
		//seats.forEach(System.out::println);
		//Calling the method name within the class
		
		//Anonymous Class
		//Consumer interface is the only thing we need here, we implemenet its accept method by way
		//Of the anonymous class implementing consume interface
		
		//This is convoluted and annoying so lambdas exist
		//seats.forEach(new /*_____*/ Consumer<Seat>(){
		//	@Override
		//	public void accept (Seat t) {
		//		System.out.println(t);
		//	}	
		//});
		
		//for (Seat s: seats){
		//	System.out.println(s);
		//}
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public String getTheatreName() {
		return theatreName;
	}
	/*
	 * Nesting classes is a way to logically group classes that are only
	 * Usable in one place
	 * Only the theatre can modify seats
	 * Nesting classes increases encapsulation, thus leading to more maintainable
	 * And readable code
	 */
	private class Seat{
		private final String seatNumber;
		private boolean reserved = false;
		
		private Seat(String seatNumber) {
			this.seatNumber = seatNumber;
		}
		
		public boolean reserve() {
			if (!this.reserved) {
				this.reserved = true;
				System.out.println("Reservation of seat "+this.seatNumber+" confirmed.");
				return true;
			} else {
				return false;
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
				
		//The reserve() method will fill up 
	}
	
}
