package com.revature.exceptions;

import java.util.InputMismatchException;


public class NotAGradeYearException extends RuntimeException{

	//Right click > source > generate constructors from super class
	public NotAGradeYearException(String s) {
		super(s);
		
		
	}
}
