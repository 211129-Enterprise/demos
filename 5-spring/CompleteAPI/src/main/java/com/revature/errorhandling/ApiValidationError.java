package com.revature.errorhandling;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class ApiValidationError extends ApiSubError{
	
	private String object; // The type of object
	private String field; // The field name
	private Object rejectedValue; // The entire object that couldn't pass
	private String reason; // Why the object couldn't pass
	
	
	
	public ApiValidationError(String object, String reason) {
		this.object = object;
		this.reason = reason;
	}



	public ApiValidationError(String object, String field, String reason) {
		this(object, reason); // This is calling a previous constructor of this class
		this.field = field;
	}



	public ApiValidationError(String object, String field, String reason, Object rejectedValue) {
		this(object, reason, field);
		this.rejectedValue = rejectedValue;
	}
	
	
	
	
	

}
