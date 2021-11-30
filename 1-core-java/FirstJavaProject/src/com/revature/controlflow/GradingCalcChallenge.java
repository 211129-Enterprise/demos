package com.revature.controlflow;

import java.util.Scanner;

public class GradingCalcChallenge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*
		 * =======================================================
		 * ========= GRADING CALCULATOR CHALLENGE ================
		 * ================== 30 min =============================
		 * =======================================================
		 * 
		 * The GradingCalc does the following: 
		 * 
		 * 1. Prompt the user to enter the total amount of points on the quiz (use the Scanner class) -> save it to a variable.
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the total amount of points.");
		String totalPointsStr = scan.nextLine();
		Double totalPoints = Double.parseDouble(totalPointsStr);
		System.out.println("Please enter the number of points the student received.");
		String pointsScoredStr = scan.nextLine();
		Double scoredPoints = Double.parseDouble(pointsScoredStr);
		
		scan.close();
		/*
		 * 
		 * 					====== HINT =======
		 * 					=== USE DOUBLES ===
		 * 					====...but WHY? ===
		 * 		
		 * 2. Prompt the user the enter the amount of points the student got right on the quiz (use Scanner) -> save to a variable.
		 * 
		 * 3. Calculate the student's letter grade:
		 * 		
		 * 		-> ((amount of points right) / (total score)) * 100 
		 * 	
		 * 
		 * */
	    /*
	     
	     */
		Double grade = ((scoredPoints / totalPoints) * 100);
		
		
		if (grade >= 90) {
		System.out.println("The Student's Letter grade is an A. That's " + String.format("%,.0f", grade) + "%");
		} else if (grade >= 80) {
		System.out.println("The Student's Letter grade is a B. That's " + String.format("%,.0f", grade) + "%");
		} else if (grade >= 70) {
		System.out.println("The Student's Letter grade is a C. That's " + String.format("%,.0f", grade) + "%");
		} else if (grade >= 60) {
		System.out.println("The Student's Letter grade is a D. That's " + String.format("%,.0f", grade) + "%");
		} else if (grade >= 50) {
		System.out.println("The Student's Letter grade is an F. That's " + String.format("%,.0f", grade) + "%");
		}
		
		/*
		 * if (x <= 90 ) {
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
		 * 
		 * 4. Return the following message to the user: 
		 * 
		 * 		"The Student's Letter grade is ___. That's ___ % !" 
		 * 	
		 * 		~ For example
		 * 
		 * 		Student scores 15 out of 20 -> 75% -> C
		 * 		"The Student's Letter grade is C. That's 75% !" 
		 */
		
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
		
		public static double calc(double maxPoints, double score) {
			Double grade = ((score / maxPoints) * 100);
			
			return grade;
		}

}
