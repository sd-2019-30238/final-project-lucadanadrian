package com.finalproject.demo.service;

import com.finalproject.demo.dao.TicketOrderDAO;
import com.finalproject.demo.model.Ticket;
import com.finalproject.demo.model.TicketOrder;
import com.finalproject.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObserverService {
    private TicketOrderDAO ticketOrderDAO;
    private EmailService emailService;

    @Autowired
    public ObserverService(TicketOrderDAO ticketOrderDAO, EmailService emailService) {
        this.ticketOrderDAO = ticketOrderDAO;
        this.emailService = emailService;
    }

    public void notifyObserver(String email, Ticket ticket) {
        emailService.sendSimpleEmail(email,"Ticket","Bought a/an "+ ticket.getTicketType() +" ticket with a price of "+ ticket.getPrice() +" RON");
    }

    public void addObserver(Ticket ticket, User user){
        ticketOrderDAO.insert(new TicketOrder(user,ticket));
    }
}
