package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class ResponseErrorHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> userNotFound(UserNotFoundException ex,WebRequest req) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
	
	@ExceptionHandler(FieldMandatoryException.class)
	public ResponseEntity<ErrorMessage> fieldMandatory(FieldMandatoryException ex,WebRequest req){
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_ACCEPTABLE,ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(message);
		
	}
}
