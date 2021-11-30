package com.revature.controlFlow;

import java.util.Scanner;

public class gradeCalcChallenge {
	
	//Calculates the students score. Actual can be greater then possible thanks to extra credit questions so I don't have to bother with an exception. Yay!
	public static double calculatePercentage(double possible, double actual) {
		double percentage = actual/possible;
		return percentage;
	}
	
	public static void main(String[] args) {
		
		//Prompts the user to input the number of possible points and actual points and captures those variables with a scanner and double variables.
		Scanner scanGrade = new Scanner(System.in);
		
		System.out.print("Enter the number of possible points:");
		double possible = scanGrade.nextDouble();
		System.out.println();
		
		System.out.print("Enter the students actual score:");
		double actual = scanGrade.nextDouble();
		System.out.println();
		
		//Calls the calculatePercentage method
		double percentage = calculatePercentage(possible, actual);
		
		//Use the students percentage grade and a series of if-else statements to find the grade.
		if (percentage >= .90 ) {
			System.out.println("The student got an A with a score of "+(percentage*100));
		}
		else if (percentage >= .80) {
			System.out.println("The student got a B with a score of "+(percentage*100));
		}
		else if (percentage >= .80) {
			System.out.println("The student got a C with a score of "+(percentage*100));
		}
		else if (percentage >= .80) {
			System.out.println("The student got a D with a score of "+(percentage*100));
		}
		else {
			System.out.println("The student got a F with a score of "+(percentage*100));
		}
		
		//Closes the scanner.
		scanGrade.close();
		
	}

}
