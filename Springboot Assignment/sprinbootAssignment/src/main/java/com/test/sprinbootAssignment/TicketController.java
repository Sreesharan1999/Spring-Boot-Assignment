package com.test.sprinbootAssignment;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.sprinbootAssignment.model.Ticket;
import com.test.sprinbootAssignment.model.TicketService;

@Controller
public class TicketController {
	
	@Autowired
	TicketService service;
	
	@RequestMapping("/home")
	public String homePage() {
		return "home";
	}
	
	@RequestMapping("/addticket")
	public String addTicket() {
		return "addticket";
	}
	
	@PostMapping("/insertticket")
	public String insertTicket(@RequestParam int id , @RequestParam String ticketTitle , @RequestParam  String ticketShortDescription , @RequestParam LocalDate ticketCreated , Model data) {
		
		Ticket tic = new Ticket(id , ticketTitle , ticketShortDescription , ticketCreated);
		service.addTicket(tic);
		data.addAttribute("ticket", tic);
		return "showticket";
	}
	
	@RequestMapping("/showticket")
	public String showTicket(Model data) {
		List<Ticket> ticket = service.getAll();
		data.addAttribute("ticket", ticket);
		return "showticket";
	}
	
	 @GetMapping("/search")
	    public List<Ticket> searchTickets(@RequestParam String query) {
	        return service.searchTickets(query);
	    }
	
	@RequestMapping("/updateticket")
	public String updateTicket() {
		return "updateticket";
	}
	
	@GetMapping("/updateticketform")
	public String updateTicket(@RequestParam int id , @RequestParam String ticketTitle , @RequestParam  String ticketShortDescription , @RequestParam LocalDate ticketCreated , Model data) {
		
		Ticket ticup = new Ticket(id , ticketTitle , ticketShortDescription , ticketCreated);
		service.updateTicket(ticup);
		data.addAttribute("ticket", ticup);
		return "showticket";
	}
	
	@RequestMapping("/deleteticket")
	public String deleteTicket() {
		return "deleteticket";
	}
	
	@GetMapping("/deleteticketform")
	public String deleteTicket(@RequestParam int id , Model data) {
		
		Ticket ticdel = new Ticket(id , null , null , null);
		service.deleteTicket(ticdel);
		data.addAttribute("ticket", ticdel);
		return "home";
	}

}
