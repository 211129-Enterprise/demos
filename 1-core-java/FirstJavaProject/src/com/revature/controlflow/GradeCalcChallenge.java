package com.revature.controlflow;

import java.util.Scanner;

public class GradeCalcChallenge {

	public static void main(String[] args) {
		
		//Create scanner
		Scanner scan = new Scanner(System.in);
		
		//Ask for input and save them to  to double type variables
		System.out.print("Please enter total possible points for quiz: ");
		double totalPoints = scan.nextDouble();
		
		System.out.print("Please enter the number of points scored on the quiz: ");
		double quizPoints = scan.nextDouble();
		
		//Create space
		System.out.println("");
		
		//Close scanner as it won't be used again
		scan.close();
		
		// calculate percentage
		double scorePercent = (quizPoints / totalPoints) * 100;
		
		// cast percentage to int for comparison, (could use something to round here if we wanted to?)
		int percentage = (int) scorePercent;
		
		//create char variable for the letter grade, default value of N for no grade in case of issues.
		char grade = 'N';
		
		/**
		 * If loop that tests that value is in a valid range (0-100) and assigns a letter grade if it is in range.
		 * 
		 *  Also prints a message if value is greater than 100 or less than 0
		 */
		
		if(percentage>100) {
			System.out.println("something seems to have gone wrong, did the student score more than the maximum?");
		}
		else if(percentage >= 90) {
			grade = 'A';
		}
		else if(percentage >= 80){
			grade = 'B';
		}
		else if(percentage >= 75){
			grade = 'C';
		}
		else if(percentage >= 70){
			grade = 'D';
		}
		else if(percentage >= 0){
			grade = 'F';
		}
		else {
			System.out.println("Something seems to have gone wrong, did the student get a negative score?");
		}
		
		// Print the grade and the percentage (I wanted to print the double %, but couldn't figure out how to truncate the .0 in case of whole numbers)
		System.out.println("The student's Grade was " + grade + ", and the score was " + percentage +"%");
	
		
	}
	

}
