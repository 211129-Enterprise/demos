package com.revature.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Driver {
	
	
	
	/**
	 * Stream API was introduced in java 8
	 * It is used to process a collection of object.
	 * 
	 * A Stream is NOT an object.
	 * It is a sequence of object references that support
	 * various methods that can be pipelined to produce a
	 * desired result without changing the underlying data
	 * structure.
	 * 
	 * We can use Streams to take input from Collections, Arrays, or IO channels.
	 */
	
	public static void main (String[] args_) {
		
		System.out.println("\n=====================\n");
		
		List<String> bingoNums = Arrays.asList(	"D40", "D46", 
												"B12", "B6",
												"G53", "G42", "g15",
												"I12", "I09"
												);

		// PRINT ALL THE BINGO NUMS - Only print the bingo nums that start with "G"
		bingoNums.forEach( n -> { // {} mean multi-line
			if(n.startsWith("G")) {
				System.out.println(n);
			}
		});
		
		System.out.println("\n=====================\n");
		
		
		// .map applies given function to each element in the stream
		bingoNums.stream()
			.map(n -> n.toUpperCase())
			.filter(n -> n.startsWith("G")) // Predicate and lambda example
			.sorted()
			.forEach(System.out::println); // Method Referencing example
		
		
		List<String> gNumsOnly = bingoNums.stream()
				.map(n -> n.toUpperCase())
				.filter(n -> n.startsWith("G")) // Predicate and lambda example
				.collect(Collectors.toList()); // Method Referencing example
		
		System.out.println(gNumsOnly);
		
		// Create a stream and save it to an optional of the first A numvalue
		Optional<String> aNum = bingoNums.stream()
							.map(String::toUpperCase)
							.filter(n -> n.startsWith("A"))
							.findFirst();

		// If it doesn't exist, aNum will be null
		if(aNum.isPresent()) {
			System.out.println(aNum);
		} else {
			System.out.println("Sorry, the optional returned as null because no aNums exist.");
		}
		
		
		System.out.println(bingoNums);
	}

}
