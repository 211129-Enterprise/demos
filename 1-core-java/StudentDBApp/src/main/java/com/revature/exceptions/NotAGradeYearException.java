package com.revature.exceptions;

import java.util.InputMismatchException;

public class NotAGradeYearException extends RuntimeException{

	public NotAGradeYearException(String s) {
		super(s);
	}
}
