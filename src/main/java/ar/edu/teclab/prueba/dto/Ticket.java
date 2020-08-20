package ar.edu.teclab.prueba.dto;

import ar.edu.teclab.prueba.service.ZendApiService;

import java.util.*;
import org.json.*;

public class Ticket {
	
	private int id;
	private String comments;	
	
	public int getId() {		
		return this.id;		
	}

	public void setId(int id) {
		this.id = id;	
		this.getTicketComments();
	}
	
	public String getComments() {		
		return this.comments;		
	}
	
	public void getTicketComments() {
		ZendApiService apiService = new ZendApiService();
		this.comments = apiService.getCommentsTicket(this.id);		
	}
}
