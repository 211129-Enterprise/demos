package com.revature.exception;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Driver {
	
	private static Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	System.out.println(Driver.divideTryCatch(1, 1));
	System.out.println( divideTryCatch());
	
	}
	
	public static  int divide(int x , int y) {
		return x/y;
	}
	
	static int divideTryCatch(int x , int y) {
		try {
			System.out.println(x/y);
			return x/y;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("You can't devide by 0 ");
			System.out.println(e.getStackTrace());
			return 0;
		}finally {
			// always excute 
			System.out.println("run the finnaly block");
		}
		

	}
	
	
	static int divideTryCatch() {
		try {
			System.out.println("enter your number :");
			int x = scanner.nextInt();
			
			System.out.println("enter divider :");
				
			int y = scanner.nextInt();
			
			return x/y;
			
		}catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("ENTER a valid dicvoder");
			return 0;
		}
		
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("ENTER a valid dicvoder");
			return 0;
		}finally {
			scanner.close();
		}
		
	
	}
	
	// this method  will create a file ;
	
	static void createAFile(String path , String text)  {
		FileWriter writer;
	try {
		writer = new FileWriter(path , true);//
		writer.close();
	}catch (IOException e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
//		writer.close();
	}
	
		
		
	}
	
	
	//Custom Exception 
	static void ageMin(int age) {
		if(age < 21) {
			throw new AgeDeniedException("age is denied");
		}else {
			System.out.println("welcome");
		}
	}
	
	
	
	
}
