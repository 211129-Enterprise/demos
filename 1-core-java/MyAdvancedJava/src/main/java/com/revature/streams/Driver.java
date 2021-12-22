package com.revature.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Driver {
	
	// Stream is not a collection it self. 
	// ** whats the difference between a stream and a collecion?? **
	// A stream is not a collection. It is a sequence of object references
	// that support various method that can be pipelined to  produce a desired
	// result , without changing the underlying data source.
	
	// we use streams to take input from collections, arrays, or IO channels

	public static void main(String[] args) {
		
		List<String> bingoNums = Arrays.asList(
				"D40", "D46",
				"B12", "B6",
				"G53", "G42", "g15",
				"I12", "I09"
				);
		
		// foreach method
		// and multi line lambda
		bingoNums.forEach(n -> {
			if(n.startsWith("G")) {
				System.out.println(n);
			}
		});
		// streams allow us to apply functions to data structures without actually changing them
		
		System.out.println("==================================");
		System.out.println("printing out streams");
		// this doesn't change underlying objects
		bingoNums.stream()
			.map(n -> n.toUpperCase()) // .map applies given function to each element in the streams
			.filter(n -> n.startsWith("G"))
			.sorted()
			.forEach(System.out::println);
		
		
		System.out.println("Actual list");
		System.out.println(bingoNums);
		
		List<String> gNumsOnly =bingoNums.stream()
		.map(n -> n.toUpperCase()) // .map applies given function to each element in the streams
		.filter(n -> n.startsWith("G"))
		.sorted()
		.collect(Collectors.toList());
		
		System.out.println("Stream Changed: ");
		System.out.println(gNumsOnly);
		
		
		Optional<String> aNum = bingoNums.stream()
				.map(String::toUpperCase)
				.filter(n -> n.startsWith("A"))
				.findFirst();
		// if it doesn't exist it will return as null
		
		if(aNum.isPresent())
			System.out.println(aNum);
		else
			System.out.println("Sorry the optional returned as null becuase no anums exist!!!");
		
		
	}
	
	
		
}
