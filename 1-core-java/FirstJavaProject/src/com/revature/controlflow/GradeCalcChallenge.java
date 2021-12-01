package com.revature.controlflow;

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
		
		
	}

}
