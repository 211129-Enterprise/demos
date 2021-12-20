package com.revature.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Driver {
	
	/*
	 * 
	 * a stream is not a clolection , 
	 * 
	 */

	public static void main(String[] args) {
		List<String> bingoNums = Arrays.asList("D40", "D46", "B12", "B6" , "G42" , "G15", "I09", "i12", "g15");
		
		bingoNums.forEach((n)-> {
			if(n.startsWith("G")) {
				System.out.println(n);
			}
		});
		
	List<String> gNumsOnly =	(List<String>) bingoNums.stream()
		.map((n)-> n.toUpperCase()) // .map applies given function to each element in the stream 
		.filter((n)-> n.startsWith("G"))
		.sorted()
		.collect(Collectors.toList());
	
	System.out.println(gNumsOnly);
	
	
	Optional<String>  aNum = bingoNums.stream().map(String::toUpperCase)
			.filter(n-> n.startsWith("A"))
			.findFirst();
	
		
		System.out.println(bingoNums);
		
	if(aNum.isPresent()) {
		System.out.println(aNum);
	}else {
		System.out.println("Sorry the optionall returned a snull because no anums exist !!!!");
	}
	
	System.out.println(bingoNums);
		
	}
}
