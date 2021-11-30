package com.revature.controlFlow;

import java.util.Scanner;

public class GradeCalcChallenge {
	
	public static double percentCalc(double correct, double total) {
		double numScore = correct / total * 100;
		return numScore;
	}
	
	public static void main(String[] args) {
		

		/*
		 * =======================================================
		 * ========= GRADING CALCULATOR CHALLENGE ================
		 * ================== 30 min =============================
		 * =======================================================
		 * 
		 * The GradingCalc does the following: 
		 * 
		 * 1. Prompt the user to enter the total amount of points on the quiz (use the Scanner class) -> save it to a variable.
		 * 
		 * 					====== HINT =======
		 * 					=== USE DOUBLES ===
		 * 					====...but WHY? ===
		 */
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter the total number of points on the quiz.");
		
		double total = scan.nextDouble();
		
		// 2. Prompt the user the enter the amount of points the student got right on the quiz (use Scanner) -> save to a variable.
		System.out.println("Please enter the amount of points the student got right on the quiz");
		
		double correct = scan.nextDouble();
		
		scan.close();
		/* 3. Calculate the student's letter grade:
		 * 		
		 * 		-> ((amount of points right) / (total score)) * 100 
		 *
		 * /* if (x <= 90 ) {
		 * 	// some code
		 * } else if ( x <= ..) {
		 * 
		 * 
		 * 
		 * 		A 90 -100
		 * 		B 80 -89
		 * 		C 70-79
		 * 		D 60-69
		 * 		F 0-59
		 */
		
		double numScore = percentCalc(correct, total);
		String letterScore = "N/A";
		
			if (numScore < 60) {				
				letterScore = "F";
			} else if (numScore < 70 ) {
				letterScore = "D";
			} else if (numScore < 80) {
				letterScore = "C";
			} else if (numScore < 90) {
				letterScore = "B";
			} else {
				letterScore = "A";
			}
		
		
		/* 4. Return the following message to the user: 
		 * 
		 * 		"The Student's Letter grade is ___. That's ___ % !" 
		 * 	
		 * 		~ For example
		 * 
		 * 		Student scores 15 out of 20 -> 75% -> C
		 * 		"The Student's Letter grade is C. That's 75% !" 
		 */
		System.out.println("The Student's Letter Grade is " + letterScore + ". That's " + numScore + "!");
		/*
		 *  Bonus:
		 *  
		 *   + Create a custom method to perform the percent calculation within the GradeCalcChallenge Class, but outside of the main method. 
		 *   	+ It should be public, static, and its return type should be double.  
		 *   	+ It should take in 2 parameters, a maxPoints and score, both of type double.
		 *   
		 *   + Format the double that it returns so that I don't see the trailing 0's.  (You can do this in a lot of ways).
		 *   
		 */

	}

}
