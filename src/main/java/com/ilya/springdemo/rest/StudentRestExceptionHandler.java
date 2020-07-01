package com.ilya.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	//add excption handling code here
	

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponce> handleException(StudentNotFoundException exc){
		//crezte response
		StudentErrorResponce error = new StudentErrorResponce();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		//return response entity
		
		return new ResponseEntity<StudentErrorResponce>(error, HttpStatus.NOT_FOUND);
	}
	
	//add another exception handle
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponce> handleException(Exception exc){
		//crezte response
		StudentErrorResponce error = new StudentErrorResponce();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		//return response entity
		
		return new ResponseEntity<StudentErrorResponce>(error, HttpStatus.BAD_REQUEST);
	}
	
}
