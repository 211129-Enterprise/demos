package com.revature.exceptions;

// Any excepion that extends RuntimeException will be unchecked
public class RegisterUserFailedException extends RuntimeException {

	public RegisterUserFailedException(String message) {
		super(message);
	}

	
}
