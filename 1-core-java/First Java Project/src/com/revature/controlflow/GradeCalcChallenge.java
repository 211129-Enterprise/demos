package com.revature.controlflow;

import java.util.Scanner;

public class GradeCalcChallenge {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		// Prompt user to enter total points on quiz
		System.out.println("Enter the total points possible: ");
		
		// save total points to double totalPoints
		double totalPoints = scan.nextDouble();
		
		// prompt user to enter student points gotten on quiz
		System.out.println("Enter amount of points student got on quiz: ");
		
		// save students points in double studentPoints
		double studentPoints = scan.nextDouble();
		
		// calculate percentage
		double percentageGrade = 100*(studentPoints/totalPoints);
		
		char grade;
		
		if (percentageGrade >= 90 & percentageGrade <= 100) {
			grade = 'A';
		}
		else if (percentageGrade >= 80 & percentageGrade < 90) {
			grade = 'B';
		}
		else if (percentageGrade >= 70 & percentageGrade < 80) {
			grade = 'C';
		}
		else if (percentageGrade >= 60 & percentageGrade < 70) {
			grade = 'D';
		}
		else {
			grade = 'F';
		}
		
		System.out.println("The Student's Letter grade is " + grade + ". That's " + percentageGrade);
		
		scan.close();
		
		

	}

}
