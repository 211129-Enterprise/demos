package com.revature.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Driver {
	public static void main(String[] args) {
		List<String> bingoNums = Arrays.asList("D40", "D46", "B12", "B6", "G53", "G42", "G15", "I12", "I09");
	
	
		bingoNums.forEach(n -> {
			if(n.startsWith("G")) {
				System.out.println(n);
			}
		});
		
		 bingoNums.stream()
		.map(n -> n.toUpperCase())
		.filter(n -> n.startsWith("G"))
		.sorted()
		.forEach(System.out::println);
		
		System.out.println("==================================================");
		
		List<String> gNumsOnly = bingoNums.stream()
		.map(n -> n.toUpperCase())
		.filter(n -> n.startsWith("G"))
		.sorted()
		.collect(Collectors.toList());
		
		Optional<String> aNum = bingoNums.stream()
				.map(String::toUpperCase)
				.filter(n -> n.startsWith("A"))
				.findFirst();
		
		if (aNum.isPresent()) {
			System.out.println(aNum);
		} else {
			System.out.println("sorry the option returned as null ");
		}
		
	}
}
