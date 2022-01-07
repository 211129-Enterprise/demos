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
	 * A stream is not a collection. It is a sequence of object references that
	 * support various methods that can be pipelined to produce a desired result,
	 * without changing the underlying data source.
	 * 
	 * We use streams to take input from Collections, Arrays, or IO Channels
	 *  
	 */
	
	public static void main(String[] args) {
		
		List<String> bingoNums = Arrays.asList(
				"D40", "D46",
				"B12", "B6", 
				"G53", "G42", "g15",
				"I12", "I9"
				);
		
		// PRINT ALL BINGO NUMS - only print the bingo nums that start with G
		bingoNums.forEach(n -> {
			if(n.startsWith("G")) {
				System.out.println(n);
			}
		});
	
		System.out.println("============================================");
		
//		bingoNums.stream()
//			.map(n -> n.toUpperCase()) // .map applies given function to teach element in the streams
//			.filter(n -> n.startsWith("G"))
//			.sorted()
//			.forEach(System.out::println); // method referencing
		List<String> gNumsOnly = bingoNums.stream()
		.map(n -> n.toUpperCase()) // .map applies given function to teach element in the streams
		.filter(n -> n.startsWith("G"))
		.sorted()
		.collect(Collectors.toList()); // method referencing
		
		System.out.println(bingoNums);
		
		// Create a stream and save it to an Optional of the first A num
		Optional<String> aNum = bingoNums.stream()
				.map(String::toUpperCase) // .map applies given function to teach element in the streams
				.filter(n -> n.startsWith("A"))
				.findFirst();
		
		// if it doesn't exist, aNum will be bull
		
		if (aNum.isPresent()) {
			System.out.println(aNum);
		} else {
			System.out.println("Optional returned as null because no anums exist!");
		}
		
		System.out.println(gNumsOnly);
		
	}
	
}
