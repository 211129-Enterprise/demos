package com.revature.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.revature.errorhandling.ApiError;
import com.revature.errorhandling.ApiValidationError;
import com.revature.exception.UserNotFoundException;


/*
 * All methods here will intercept certain exceptions
 * that are sent back as HTTP responses from the CONTROLLER.
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	/*
	 * The following method will be what constructs a NEW response entity
	 * to send back to the client when something goes wrong.	
	 */
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError){
		
		// We pass the status of the apiError and the body of the apiError
		return ResponseEntity.status(apiError.getStatus()).body(apiError);
		
	}
	
	
	/*
	 * Intercept Exceptions that are caused by invalid JSON
	 * Send back some 4XX code
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
			HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		String error = "Malformed JSON Request";
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, error, ex);
		
		return buildResponseEntity(apiError);
	}
	
	
	
	/*
	 * Intercept exceptions caused by validation issues 
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		String error = "Request failed validation";
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, error, ex);
		
		// Iterate over the fields of the object we're trying to persist
		// and return the fields that are NOT valid
		for(FieldError e : ex.getFieldErrors()) {
			apiError.addSubError(new ApiValidationError(e.getObjectName(), e.getDefaultMessage(), e.getField(), e.getRejectedValue()));
		}
		
		return buildResponseEntity(apiError);
	}
	
	
	/*
	 * Intercept user not found from the findByUsername controller method
	 * This is an example of Custom Business logic. 
	 */
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex){
		
		String error = "No User Found";
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, error, ex);
		
		return buildResponseEntity(apiError);
	}
	
}
