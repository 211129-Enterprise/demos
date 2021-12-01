package controlflow;

import java.util.Scanner;

public class GradecalcChallenge {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("What were the total points on the quiz?");
		double total = scan.nextInt();
		System.out.println("How many did the student get correct?");
		double correct = scan.nextInt();
		int average = (int) (((correct)/(total))*100);
		System.out.println("The average grade for this quiz is " + average);
			if (average >= 90) {
				System.out.println("Your grade is a " + average + "%," +" A.");
			} else if (average >= 80){
				System.out.println("Your grade is a " + average + "%," +" B.");
			} else if (average >= 70){
				System.out.println("Your grade is a " + average + "%," +" C.");
			} else if (average >= 60){
				System.out.println("Your grade is a " + average + "%," +" D.");
			} else {
				System.out.println("Your grade is a " + average + "%," +" F.");
				System.out.println("We apologize that you have failed.");
			}
			scan.close();

	}

	
}
