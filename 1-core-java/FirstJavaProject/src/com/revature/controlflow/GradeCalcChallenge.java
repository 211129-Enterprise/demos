package com.revature.controlflow;

import java.util.Scanner;

public class GradeCalcChallenge {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the total amount of points on the quiz: ");
		double total = scan.nextDouble();
		
		System.out.println("Enter the amount of points the student got right on the quiz: ");
		double score = scan.nextDouble();
		
		// calculating student's letter grade:
		
		double grade = percentCal(score,total);
		
		char letterGrade = 'F'; 
		
		if (score >= 90 && score <= 100  ) {
			letterGrade = 'A';
		} 
		else if ( score <= 89 && score>= 80 ) 
		{
			letterGrade = 'B';
		}
		else if ( score <= 79 && score >= 70 ) 
		{
			letterGrade = 'C';
		}
		else if ( score <= 69 && score>= 60 ) 
		{
			letterGrade = 'D';
		}
		else if (score <= 59)
		{
			letterGrade = 'F';
		}
		
		System.out.println("The Student's Letter grade is " + letterGrade + " . That's " + String.format("%,.2f", grade)  + " % !");

	}
	
	public static double percentCal(double score, double total)
	{
		
		return ( score / total ) * 100;
	}
}