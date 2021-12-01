package com.revature;

import java.util.HashMap;

public class GarbageCode {

	public static void main(String[] args) {
		
		String[] testWords = {"Portable Network Graphics", "First In, First Out", "GNU Image Manipulation Program", "Complementary metal-oxide semiconductor"};
		String[] correctAbbrev = {"PNG", "FIFO", "GIMP", "CMOS"};
		
		for(int i = 0; i < testWords.length; i++) {
			String output = acronym(testWords[i]);
						
			System.out.println("LOOP #" + i + ": Matching '" + output + "' against '" + correctAbbrev[i] + "' using '" + testWords[i] + "'");
			System.out.println("LOOP #" + i + ": " + ((output.equals(correctAbbrev[i])) ? "MATCH": "NO MATCH") + " found");
		}
		

	}
	

	public static String acronym(String phrase) { 
		
		//Process phrase and remove anything that isn't a letter, a comma, or apostrophe
		String specialCharsRemoved = phrase.replaceAll("[^A-Za-z,' ]", " ");
		String acronym = "";
		
		//For each loop through array of words (split at white space)
		for (String s : specialCharsRemoved.split(" ")) {
			acronym+=s.charAt(0);
		}
		
		//Return the acronym in upper case
		return acronym.toUpperCase();
	}

}
