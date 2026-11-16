package com.alpha.customerService.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.customerService.dto.CustomerDTO;
import com.alpha.customerService.entity.Customer;
import com.alpha.customerService.exception.CustomerAlreadyExistException;
import com.alpha.customerService.repo.CustomerRepo;
import com.alpha.customerService.response.ResponseStructure;




@Service
public class CustomerService {
	@Autowired
	private CustomerRepo customerRepo;
	
	public ResponseEntity<ResponseStructure<Customer>> createCustomerAccount(Customer customer) {
		ResponseStructure<Customer> rs=new ResponseStructure<Customer>();
		if (customerRepo.findByPhone(customer.getPhone()).isPresent()) {
		    throw new CustomerAlreadyExistException();
		}
		
		Customer c=customerRepo.save(customer);
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setMessage("customer Created Successfully");
		rs.setData(c);
		return new ResponseEntity<ResponseStructure<Customer>>(rs, HttpStatus.CREATED);
		
		
		
	}

	public ResponseEntity<ResponseStructure<Customer>> findCustomerById(long id) {
		ResponseStructure<Customer> rs=new ResponseStructure<Customer>();
		Customer c=customerRepo.findById(id).orElseThrow(()->new CustomerAlreadyExistException("Customer not found with id "+id));
		rs.setStatusCode(HttpStatus.FOUND.value());
		rs.setMessage("customer found");
		rs.setData(c);
		return new ResponseEntity<ResponseStructure<Customer>>(rs,HttpStatus.CREATED);
		
		
	}

	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(long id) {
		ResponseStructure<Customer> rs=new ResponseStructure<Customer>();
		Customer c=customerRepo.findById(id).orElseThrow(()->new CustomerAlreadyExistException("Customer not found with id "+id));
		customerRepo.delete(c);
		rs.setStatusCode(HttpStatus.FOUND.value());
		rs.setMessage("customer with id "+ id+"deleteed");
		rs.setData(c);
		return new ResponseEntity<ResponseStructure<Customer>>(rs,HttpStatus.ACCEPTED);
	
	}

}
