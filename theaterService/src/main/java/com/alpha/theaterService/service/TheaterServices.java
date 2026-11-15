package com.alpha.theaterService.service;

import org.hibernate.annotations.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.theaterService.dto.ResponseStructure;
import com.alpha.theaterService.entity.Address;
import com.alpha.theaterService.entity.Theater;
import com.alpha.theaterService.exception.TheaterAlreadyExistException;
import com.alpha.theaterService.repo.AddressRepository;
import com.alpha.theaterService.repo.TheaterRepository;

@Service
public class TheaterServices {

	@Autowired
	TheaterRepository theaterRepository;
	@Autowired
	AddressRepository addressRepository;
	
	public ResponseEntity<ResponseStructure<Theater>> createTheaterAcoount(Theater theater) {
		ResponseStructure<Theater> rs = new ResponseStructure<Theater>();
		if (theaterRepository.findBycontactNumber(theater.getContactNumber()).isPresent()) {
		    throw new TheaterAlreadyExistException();
		}
		theater.setStatus("Closed");
//		theater.setAllPlayingShows(null);
		Address add = theater.getAddress();
		if(add == null) {
			System.out.println("add is null");
		}else {
			add = addressRepository.save(add);
		}
		Theater th1 = theaterRepository.save(theater);
		th1.setAddress(add);
		rs.setStatuscode(HttpStatus.CREATED.value());
		rs.setMessage("Theater Created Successfully");
		rs.setData(th1);
		return new ResponseEntity<ResponseStructure<Theater>>(rs, HttpStatus.CREATED);
	}

}
