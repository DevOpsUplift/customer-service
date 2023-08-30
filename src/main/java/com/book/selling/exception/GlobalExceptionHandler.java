package com.book.selling.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.book.selling.validator.ValidationErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Object> handleCustomerNotFoundException(CustomerNotFoundException ex, WebRequest request) {
		Map<String, Object> body = new HashMap<>();
		body.put("message", ex.getMessage());

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationErrorResponse> handleValidationException(MethodArgumentNotValidException e) {
		ValidationErrorResponse errorResponse = new ValidationErrorResponse();
		e.getBindingResult().getAllErrors().forEach(error -> {
			FieldError fieldError = (FieldError) error;
			errorResponse.addError(fieldError.getField(), fieldError.getDefaultMessage());
		});

		return ResponseEntity.badRequest().body(errorResponse);
	}
}
