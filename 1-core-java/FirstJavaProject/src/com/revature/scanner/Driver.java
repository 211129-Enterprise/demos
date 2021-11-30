package com.revature.scanner;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your name!");
		String name =  scanner.nextLine();
		System.out.println("What's your age?");
		Integer age = scanner.nextInt();
		System.out.println("Your name is " + name + " and you are " + age + " years old");
		scanner.close();
		Integer futureAge = getFutureAge(age);
		System.out.println("In a 100 years... " + futureAge);
	}
	
	public static Integer getFutureAge(Integer age) {
		return age + 100;
	}
}
