package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Theatre {

	private final String theatreName;
	private List<Seat> seats = new ArrayList<>();
	
	public Theatre(String theatreName, int numRows , int seatsPerRow) {
		this.theatreName = theatreName;
		
		int lastRow = 'A' + (numRows -1);
		for(char row = 'A'; row<= lastRow; row++) {
			
			for(int setNum =1; setNum <= seatsPerRow ; setNum++) {
				Seat seat = new Seat(row + String.format("%02d", setNum));
				seats.add(seat);
			}
			
		}
	}

	public void getSeats() {
		
		// applying a lambda function the impl
		// which is the absratct method I must 
		
		
		/*
		 * 	single line lambda 
		 * 		seats.forEach(seat -> System.out.println(seat));
		 */
		
		seats.forEach(seat-> System.out.println(seat));
//		
		
		
//		seats.forEach((seat)->{
//			System.out.println(seat);
//			System.out.println("Multi Lines of code");
//		});
		
		
		
//		seats.forEach(System.out :: println);
//		}
	
		/*  method refrencing
		 * 
		 * 
		 */
		
	
		
		
		// Anonymous class 
		
//		seats.forEach(new Consumer<Seat >() {
//
//			@Override
//			public void accept(Seat t) {
//				// TODO Auto-generated method stub
//				System.out.println(t);
//			}
//	
//	})
//
	}
	
	public boolean reserveSeatBinary(String seatNumber) {
		// binary search work on sorted list  
		int low = 0;
		int high = seats.size() - 1;
		
		while (low <= high) {
			
			System.out.println("Searching ....");
			
			int mid = (low+ high)/2 ;
			
			Seat midSeat = seats.get(mid);
			
			int cmp = midSeat.getSeatNumber().compareTo(seatNumber);
			
			// the setNumber is string ....... string automaticall implements the comparable interace 
			// and override the compareTo() 
			
			// compareto() return 0 , if equal | 1 if greater than | -1 if less than 

			if(cmp< 0) {
				low = mid+1;
			}else if (cmp > 0) {
				high = mid -1;
			}else {
				return seats.get(mid).reserve();
			}
			
		}
		
		System.out.println("there is no seat "+ seatNumber);
		return false;
	}
	
	public boolean reserveSeatBinary(Seat seat) {
		// binary search work on sorted list  
		int low = 0;
		int high = seats.size() - 1;
		
		while (low <= high) {
			
			System.out.println("Searching ....");
			
			int mid = (low+ high)/2 ;
			
			Seat midSeat = seats.get(mid);
			
			int cmp = midSeat.compareTo(seat);
			
			// the setNumber is string ....... string automaticall implements the comparable interace 
			// and override the compareTo() 
			
			// compareto() return 0 , if equal | 1 if greater than | -1 if less than 

			if(cmp< 0) {
				low = mid+1;
			}else if (cmp > 0) {
				high = mid -1;
			}else {
				return seats.get(mid).reserve();
			}
			
		}
		
		System.out.println("there is no seat "+ seat);
		return false;
	}
	
	
	
	
	
	// operating in linear time complexity  O(n)
	public boolean reserveSeatBruteForce(String seatNumber) {
		
		Seat requestedSeat = null;
		
		for(Seat seat : seats) {
			System.out.println("Searching ... ");
			
			if(seat.getSeatNumber().equals(seatNumber)) {
				requestedSeat = seat;
				break;
			}
		}
		
		
		if(requestedSeat == null) {
			System.out.println("Sorry there's no seat " + seatNumber);
			return false;
		}else {
			return requestedSeat.reserve();
		}
		
	}
	
	
	
	
	
	

	public String getTheatreName() {
		return theatreName;
	}
	
	
	
	
	/*
	 * Nesting classes is a way of logically grouping classes that only 
	 * used in one place
	 * 
	 * 
	 * Nesting classes increase encapsulation, 
	 */
	
	@Override
	public String toString() {
		return "Theatre [theatreName=" + theatreName + ", seats=" + seats + "]";
	}




	private class Seat implements Comparable<Seat>{
		private final String seatNumber; // G11 , H03 .....
		private boolean isReserved = false;
		
		public boolean reserve() {
			if(!this.isReserved) {
				this.isReserved = true;
				System.out.println("Reservation of seat "+ this.seatNumber + " confirmed.");
				return true;
			}else {
				return false;
			
		}
		}
				
		
		
		private Seat(String seatNumber) {
			this.seatNumber = seatNumber;
		}

		public String getSeatNumber() {
			return seatNumber;
		}

		public boolean isReserved() {
			return isReserved;
		}

		@Override
		public String toString() {
			return "Seat [seatNumber=" + seatNumber + "]";
		}

		
		// return 0 is equal | 1 if greater than | -1 less than
		@Override  
		public int compareTo(Seat othSeat) {
			// TODO Auto-generated method stub
			
			return this.seatNumber.compareToIgnoreCase(othSeat.getSeatNumber());
			
		}
		
		
		
		
	}
	
	
}
