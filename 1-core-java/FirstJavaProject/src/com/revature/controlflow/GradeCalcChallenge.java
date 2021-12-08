package com.revature.controlflow;

<<<<<<< HEAD
import java.util.Scanner;

public class GradeCalcChallenge {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		// Prompt the user to enter the total amount of points on the quiz 
		// (use the Scanner class) -> save it to a variable.
		System.out.println("Please Enter Total Amount of points: ");
		double totalPoints = scan.nextDouble();
		
		// Prompt the user the enter the amount of points the 
		// student got right on the quiz (use Scanner) -> save to a variable.
		System.out.println("Please Enter Student Amount of points: ");
		double studentPoints = scan.nextDouble();
		
		// Calculate the student's letter grade:
		double studentPercentage = (studentPoints / totalPoints) * 100;
		
		char grade = 'U';
		
		if(studentPercentage <= 100 && studentPercentage >= 90) {
			grade = 'A';
			
		}
		
		else if (studentPercentage  < 90 && studentPercentage >= 80) {
			grade = 'B';
		}
		
		else if (studentPercentage < 80  && studentPercentage >= 70) {
			grade = 'C';
		}
		
		else if (studentPercentage < 70  && studentPercentage >= 60) {
			grade = 'D';
		}
		
		else if (studentPercentage < 60  && studentPercentage >= 0) {
			grade = 'F';
		}
		
		
		// Return the following message to the user:
		// "The Student's Letter grade is ___. That's ___ % !" 
		
		System.out.println("The Student's Letter grade is " + grade + ". That's " + studentPercentage + "% ");
		
		
=======
public class GradeCalcChallenge {

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
		 * 		
		 * 2. Prompt the user the enter the amount of points the student got right on the quiz (use Scanner) -> save to a variable.
		 * 
		 * 3. Calculate the student's letter grade:
		 * 		
		 * 		-> ((amount of points right) / (total score)) * 100 
		 * 	
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

>>>>>>> 0bca53b785f2de35fc67962dfe9e69979522c923
	}

}
