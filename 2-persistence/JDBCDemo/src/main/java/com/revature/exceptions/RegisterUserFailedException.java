package com.revature.exceptions;

// any exception that extends runtime exception will be unchecked
public class RegisterUserFailedException extends RuntimeException{

	public RegisterUserFailedException(String message) {
		super(message);
	}

}
