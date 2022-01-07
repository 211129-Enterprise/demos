package com.revature.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Driver {
	
	/**
	 * Stream API was introduced in Java 8
	 * It is used to process a collection of objects.
	 * 
	 * A stream is NOT a collection.  It is a sequence of object references that
	 * support various method that can be pipelined to produce a desired result,
	 * wihtout changing the underlying data source.
	 * 
	 * We use Streams to take input from Collections, Arrays, or IO channels
	 * 
	 */
	
	public static void main(String[] args) {
		
		
		List<String> bingoNums = Arrays.asList(
				"D40", "D46",
				"B12", "B6",
				"G53", "G42", "g15",
				"I12", "I09"
				);
		
		// PRINT ALL THE BINGO NUMS - only print the bingo nums that start with G
		bingoNums.forEach(n -> {
			// {} mean multi-line lmabda here
			if(n.startsWith("G")) {
				System.out.println(n);
			}
			
		});
		
		System.out.println("========================================");
		
		 bingoNums.stream()
			.map(n -> n.toUpperCase()) // .map appliees given function to each element in the streams
			.filter(n -> n.startsWith("G"))
			.sorted()
			.forEach(System.out::println); // method referencing 
		 
			
		 List<String> gNumsOnly = bingoNums.stream()
			.map(n -> n.toUpperCase()) // .map appliees given function to each element in the streams
			.filter(n -> n.startsWith("G"))
			.sorted()
			.collect(Collectors.toList()); 
		 
		 System.out.println(gNumsOnly);
		
		 // create a stream and save it to an optional of the first A numvalue
		 Optional<String> aNum = bingoNums.stream()
				 .map(String::toUpperCase) // .map appliees given function to each element in the streams
				.filter(n -> n.startsWith("A"))
				.findFirst(); // find first aNUm that exists
		 
		 
		 // if it doesn't exist, aNum will be null
		 
		 if (aNum.isPresent()) {
			 System.out.println(aNum);
		 } else {
			 System.out.println("Sorry the optional returned as null because no anums exist!!!!");
		 }
		 
		System.out.println(bingoNums);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
