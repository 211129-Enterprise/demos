package com.revature;

public class GarbageCode {

	public static void main(String[] args) {

//		/* QUESTION 2 SCRAP CODE */		
//		String[] testWords = {"Portable Network Graphics", "First In, First Out", "GNU Image Manipulation Program", "Complementary metal-oxide semiconductor"};
//		String[] correctAbbrev = {"PNG", "FIFO", "GIMP", "CMOS"};
//		
//		for(int i = 0; i < testWords.length; i++) {
//			String output = acronym(testWords[i]);
//						
//			System.out.println("LOOP #" + i + ": Matching '" + output + "' against '" + correctAbbrev[i] + "' using '" + testWords[i] + "'");
//			System.out.println("LOOP #" + i + ": " + ((output.equals(correctAbbrev[i])) ? "MATCH": "NO MATCH") + " found");
//		}
		

		
		
		
				
		
		
	}

	
//	/* QUESTION 4 SCRAP CODE */
//	public static int getScrabbleScore(String string) {
//		
//		//Initialize variables to be used in loop
//		int totalPoints = 0;
//		String word = string.toUpperCase();
//
//		//Determine value of each character in word / string
//		for(int i = 0; i < word.length(); i++) {
//			switch(word.charAt(i)) {
//			
//				case 'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T':
//					totalPoints += 1;
//					break;
//					
//				case 'D', 'G':
//					totalPoints += 2;
//					break;
//					
//				case 'B', 'C', 'M', 'P':
//					totalPoints += 3;
//					break;
//					
//				case 'F', 'H', 'V', 'W', 'Y':
//					totalPoints += 4;
//					break;
//					
//				case 'K':
//					totalPoints += 5;
//					break;
//					
//				case 'J', 'X':
//					totalPoints += 8;
//					break;
//					
//				case 'Q', 'Z':
//					totalPoints += 10;
//					break;
//			}
//		}
//		
//		
//		return totalPoints;
//	}	
	
	
//	/* QUESTION 3 SCRAP CODE */
//	public static boolean isEquilateral(double sideOne, double sideTwo, double sideThree) {
//		
//		//If all three sides are equal, return true
//		if(sideOne == sideTwo && sideTwo == sideThree){
//			return true;
//		}
//		
//		return false;
//	}
//
//	public static boolean isIsosceles(double sideOne, double sideTwo, double sideThree) {
//		
//		//If two sides are equal AND not all three sides are equal, return true
//		if((sideOne == sideTwo || sideTwo == sideThree || sideOne == sideThree) &&
//			!(sideOne == sideTwo && sideTwo == sideThree)){
//			return true;
//		}
//		
//		return false;
//	}
//	
//	public static boolean isScalene(double sideOne, double sideTwo, double sideThree) {
//		
//		//If any two sides are equal, it's not a scalene triangle
//		if(sideOne == sideTwo || sideOne == sideThree ||sideTwo == sideThree){
//				return false;
//			}
//		
//		return true;
//	}
	
	
//	/* QUESTION 2 SCRAP CODE */
//	public static String acronym(String phrase) { 
//		
//		//Process phrase and remove anything that isn't a letter, a comma, or apostrophe
//		String specialCharsRemoved = phrase.replaceAll("[^A-Za-z,' ]", " ");
//		String acronym = "";
//		
//		//For each loop through array of words (split at white space)
//		for (String s : specialCharsRemoved.split(" ")) {
//			acronym+=s.charAt(0);
//		}
//		
//		//Return the acronym in upper case
//		return acronym.toUpperCase();
//	}

}
