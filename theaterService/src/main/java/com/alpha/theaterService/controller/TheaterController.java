package com.alpha.theaterService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.theaterService.dto.ResponseStructure;
import com.alpha.theaterService.entity.Theater;
import com.alpha.theaterService.service.TheaterServices;

@RestController
public class TheaterController {
	
	@Autowired
	private TheaterServices theaterServices;
	
	@PostMapping("/theater/createAccount")
	public ResponseEntity<ResponseStructure<Theater>> createTheaterAccount(@RequestBody Theater theater) {
		return theaterServices.createTheaterAcoount(theater);
	}
}
