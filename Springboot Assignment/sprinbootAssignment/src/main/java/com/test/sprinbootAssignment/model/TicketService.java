package com.test.sprinbootAssignment.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
	
	@Autowired
	TicketRepo repo;
	
	public void addTicket(Ticket ticket) {
		repo.save(ticket);	
	}
	
	public List<Ticket> getAll(){
		return repo.findAll();
	}
	
	public Ticket getById(int id) {
		Optional<Ticket> opt = repo.findById(id);
		if(opt.isEmpty()) {
			return null;
		}
		return opt.get();
	}
	
	public List<Ticket> searchTickets(String query) {
        return repo.findByTitleContainingOrShortDescriptionContaining(query, query);
    }
	
	public void updateTicket(Ticket ticket) {
		repo.save(ticket);
	}
	
	public void deleteTicket(Ticket ticket) {
		repo.delete(ticket);
	}
}
