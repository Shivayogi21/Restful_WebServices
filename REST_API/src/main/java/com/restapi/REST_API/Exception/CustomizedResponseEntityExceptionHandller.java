package com.restapi.REST_API.Exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.restapi.REST_API.user.UserNotFoundException;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandller extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Errordetails> handleAllException(Exception ex, WebRequest request) throws Exception {
	 Errordetails errordetails=new Errordetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	 
	 return new ResponseEntity<Errordetails>(errordetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Errordetails> handleUserNotFoundExceptionException(Exception ex, WebRequest request) throws Exception {
	 Errordetails errordetails=new Errordetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	 
	 return new ResponseEntity<Errordetails>(errordetails,HttpStatus.NOT_FOUND);
	}
	
}
