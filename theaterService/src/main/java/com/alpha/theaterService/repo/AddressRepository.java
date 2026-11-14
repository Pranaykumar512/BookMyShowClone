package com.alpha.theaterService.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.theaterService.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
