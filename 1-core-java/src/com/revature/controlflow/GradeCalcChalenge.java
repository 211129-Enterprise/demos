package com.revature.controlflow;

import java.util.Scanner;

public class GradeCalcChalenge {

	public static void main(String[] args) {
		// build an algorythm
		// enter totla points
		// save to variable
		// points got right
		// calculate letter grade
		// return method
		System.out.println("Enter your score bellow: ");
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();
		scan.close();
		
		System.out.println(score);
		if(score >= 90) {
			System.out.println("You got an A!");
		} else if(score >= 80) {
			System.out.println("You got an B!");
		} else if(score >= 70) {
			System.out.println("You got an C!");
		} else if(score >= 60) {
			System.out.println("You got an D!");
		} else {
			System.out.println("wow you got an F!");
		}
		
		
		
	}

}