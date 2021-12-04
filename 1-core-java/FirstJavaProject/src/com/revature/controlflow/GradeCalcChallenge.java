package com.revature.controlflow;

import java.text.DecimalFormat;
import java.util.Scanner;

public class GradeCalcChallenge {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner (System.in);
		
		 //1. Prompt the user to enter the total amount of points on the quiz (use the Scanner class) -> save it to a variable.
		System.out.println("Please enter the highest possible score on quiz");
		
		 //					====== HINT =======
		 // 					=== USE DOUBLES ===
		 //					====...but WHY? ===
		
		double maxScore = scan.nextDouble();
		 
		 
		 // DecimalFormat will format the decimal, which is actual a String
		
		DecimalFormat cleanDub = new DecimalFormat("0.#");
		
		 // 2. Prompt the user the enter the amount of points the student got right on the quiz (use Scanner) -> save to a variable.

		
		System.out.println("Please enter the student's grade out of max score " + cleanDub.format(maxScore));
		double score = scan.nextDouble();
		
		// The reason Sophia used doubles is because if a int was used, then this would floor to 0 and multiply by 100 every time.
		
		
		scan.close();
		
		  //3. Calculate the student's letter grade:
		  		
		 // 		-> ((amount of points right) / (total score)) * 100 
		 	
		 //if (x <= 90 ) {
		 // 	// some code
		 //} else if ( x <= ..) {
		 
		  
		  
		 // 		A 90 -100
		//	B 80 -89
		 // 		C 70-79
		 // 		D 60-69
		 // 		F 0-59
		  
		 // 4. Return the following message to the user: 
		  
		 // 		"The Student's Letter grade is ___. That's ___ % !" 
		 
		 //		~ For example
		  
		 //		Student scores 15 out of 20 -> 75% -> C
		 //		"The Student's Letter grade is C. That's 75% !" 
		
		
		double percent = calculatePercent(score, maxScore);
		
		
		String cleanPercent = cleanDub.format(percent);
		
		
		
		String letterGrade;
		
		if (percent >= 90) {
			letterGrade = "A";
		}else if (percent >= 80) {
			letterGrade = "B";
		}else if (percent >= 70) {
			letterGrade = "C";
		}else if (percent >= 60) {
			letterGrade = "D";
		}else {
			letterGrade = "F";
		}
		
		System.out.println("the students's letter grade is " + letterGrade + " . That's " + cleanPercent + "%!");
		 
		
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
		private static double calculatePercent(double score, double maxScore) {
			
			return (score / maxScore) * 100;
		

	}

}
