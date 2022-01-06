package com.revature.errorhandling;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ApiValidationError extends ApiSubError{
	
	private String object; // the Type of object
	private String field; // field name
	private Object rejectedValue; // the entire object that couldn't pass
	private String reason;
	
	public ApiValidationError(String object, String reason) {
		this.object = object;
		this.reason = reason;
	}

	public ApiValidationError(String object, String field, String reason) {
		this(object, reason); // this is calling a previous constructor of this class
		this.field = field;
	}

	public ApiValidationError(String object, String field, Object rejectedValue, String reason) {
		this(object, reason, field);
		this.rejectedValue = rejectedValue;

	}
}
