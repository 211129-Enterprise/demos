package com.revature.errorhandling;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


@Data
public class ApiError {
	
	/*
	 * This class is designed to represent information about an HTTP error.
	 * 
	 * The structure of it must be serialized into JSON and sent back to the
	 * client in order to inform what has gone wrong.
	 */
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-mm-yyy hh:mm:ss")
	private LocalDateTime timestamp;
	
	private int status;
	
	private String error; // Represents HTTP error (in words)
	private String message;
	private String debugMessage;
	
	private List<ApiSubError> subErrors = new ArrayList<>();

	
	public ApiError() {
		super();
		this.timestamp = LocalDateTime.now();
	}

	
	public ApiError(HttpStatus status) {
		this();
		this.status = status.value();
		this.error = status.getReasonPhrase();
	}
	
	

	
	public ApiError(HttpStatus status, Throwable ex) {
		this();
		this.message = "No message available";
		this.debugMessage = ex.getLocalizedMessage();
	}
	
	public void addSubError(ApiSubError err) {
		this.subErrors.add(err);
	}


	public ApiError(HttpStatus status, String message, Throwable ex) {
		this(status, ex);
		this.message = message;
	}
	
	
	

}
