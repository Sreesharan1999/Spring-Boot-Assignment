package com.test.sprinbootAssignment.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket, Integer>{
	
	 List<Ticket> findByTitleContainingOrShortDescriptionContaining(String ticketTitle, String ticketShortDescription);

	
}
