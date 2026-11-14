package com.alpha.customerService.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.customerService.entity.Ticket;

public interface TicketRepository
        extends JpaRepository<Ticket, Long> {

}
