package com.alpha.theaterService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alpha.theaterService.dto.ResponseStructure;
import com.alpha.theaterService.entity.Theater;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(TheaterAlreadyExistException.class)
	public ResponseEntity<ResponseStructure<String>> TheaterAlreadyExistExceptionHandler() {
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStatuscode(HttpStatus.ALREADY_REPORTED.value());
		rs.setMessage("Theater Already Exist");
		rs.setData("Theater Already Exist");
		
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.FOUND);
	}
}
