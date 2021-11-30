package com.revature.controlflow;
import java.util.Scanner;

public class GradeCalcChallange {
 
	
	public static double calculate(double rightPoints , double totalPoints){
		double numberGrade = (rightPoints / totalPoints) * 100;
		return numberGrade;
	}
	
	
	
	public static void main(String[] args) {
	
		 double totalPoints;
		 double rightPoints;
		 char letterGrade = ' ';
		 double numberGrade;
		 
		
		
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Please enter the total number of points on the quiz?");		
		 totalPoints = scan.nextDouble();
		
		System.out.println("Please enter the amount of point the students got right on the quiz?");
		 rightPoints = scan.nextDouble();
		
		
		numberGrade = calculate(rightPoints, totalPoints);
		
		if (numberGrade >= 90 && numberGrade <= 100 ){ 
			 letterGrade = 'A';
		} else if (numberGrade >= 80 && numberGrade <= 89 ){ 
			 letterGrade = 'B';
		} else if (numberGrade >= 70 && numberGrade <= 79 ){ 
			 letterGrade = 'C';
		} else if (numberGrade >= 60 && numberGrade <= 69 ){ 
			 letterGrade = 'D';  
		} else {
			 letterGrade = 'F';
		}
	
		
		System.out.println("The Student's Letter grade is " + letterGrade +". That's " + numberGrade + "% !");
	}

	
}
