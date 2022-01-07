package com.revature.errorhandling;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ApiValidationError extends ApiSubError {
	
	private String object; // the type of object
	private String field; // field name
	private Object rejectedValue; // the entire object that couldn't pass
	private String reason; // why obj couldn't pass
	
	public ApiValidationError(String object, String reason) {
		this.object = object;
		this.reason = reason;
	}

	public ApiValidationError(String object, String field, String reason) {
		this(object, reason);
		this.field = field;
	}

	public ApiValidationError(String object, String field, String reason, Object rejectedValue) {
		this(object, reason, field);
		this.rejectedValue = rejectedValue;
	}
	
	
	
	
}
