package com.alpha.customerService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alpha.customerService.response.ResponseStructure;
@ControllerAdvice

public class GlobalExceptionHandler {
	@ExceptionHandler(CustomerAlreadyExistException.class)
	public ResponseEntity<ResponseStructure<String>> CustomerAlreadyExistExceptionHandler() {
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStatusCode(HttpStatus.ALREADY_REPORTED.value());
		rs.setMessage("customer already exist");
		rs.setData("customer Already Exist");
		
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.FOUND);
	}
}