package com.alpha.customerService.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.customerService.entity.Customer;

public interface CustomerRepository
        extends JpaRepository<Customer, Long> {

}
