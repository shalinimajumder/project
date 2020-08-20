package com.example.doctor.doctordetails.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice

public class CustomGlobalExceptionHandeler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), "This Is comming From MethodArgumentNotValidException ", ex.getMessage());
		
		return new ResponseEntity<>(customErrorDetails,HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), "This is from handleMissingServletRequestParameter Exception ", "Sorry the requestparam not available"); 
		return new ResponseEntity<>(customErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(RequestParamNotAvailable.class)
	protected ResponseEntity<Object> RequestParamNotAvailable(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), "This is from handleMissingServletRequestParameter Exception ", "Sorry the requestparam not available"); 
		return new ResponseEntity<>(customErrorDetails,HttpStatus.BAD_REQUEST);
	}

}
