package com.alpha.customerService.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.alpha.customerService.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Optional<Customer> findByPhone(Long phone);

    Optional<Customer> findByMail(String mail);
}