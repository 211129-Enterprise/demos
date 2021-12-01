package com.revature.exceptions;

import java.io.FileWriter;
import java.util.Scanner;

public class Driver {

	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int x = 10;
		int y = 0;
		try {
			System.out.println(divide(x,y));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		finally {
			System.out.println("Operation Complete");
		}
		
		try {
			checkAge(20);
		}
		catch(AgeDeniedException e) {
			e.printStackTrace();
		}
	}
	
	static int divide(int x, int y) {
		return x/y;
	}

	static void createFileCheckedException(String path,String text) {
		FileWriter writer;
		try {
			writer = new FileWriter(path, true);
			writer.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static void checkAge(int age) {
		if(age < 21) throw new AgeDeniedException("Sorry too young.");
		else System.out.println("Welsome!");
	}
	
}
