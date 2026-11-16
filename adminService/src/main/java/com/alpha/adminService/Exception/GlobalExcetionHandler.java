package com.alpha.adminService.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alpha.adminService.ResponseStructure.ResponseStructure;

@ControllerAdvice
public class GlobalExcetionHandler {

	@ExceptionHandler(MovieAlreadyExistException.class)
	public ResponseEntity<ResponseStructure<String>> MovieAlreadyExistExceptionHandler() {
		ResponseStructure<String> rs= new ResponseStructure<String>();
		rs.setStatusCode(HttpStatus.CONFLICT.value());
		rs.setMessage("Movie already exists");
		rs.setData("movie already exists");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.CONFLICT);
	}
	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> MovieNotFoundExceptionHandler() {
		ResponseStructure<String> rs= new ResponseStructure<String>();
		rs.setStatusCode(HttpStatus.NOT_FOUND.value());
		rs.setMessage("Movie Not Found");
		rs.setData("movie Not Found");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
}
