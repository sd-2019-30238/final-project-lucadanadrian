package com.finalproject.demo.service;

import com.finalproject.demo.dao.TicketOrderDAO;
import com.finalproject.demo.dao.ValidationCodeDAO;
import com.finalproject.demo.model.Ticket;
import com.finalproject.demo.model.TicketOrder;
import com.finalproject.demo.model.User;
import com.finalproject.demo.model.ValidationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ObserverService {
    private TicketOrderDAO ticketOrderDAO;
    private EmailService emailService;
    private ValidationCodeDAO validationCodeDAO;

    @Autowired
    public ObserverService(TicketOrderDAO ticketOrderDAO, EmailService emailService, ValidationCodeDAO validationCodeDAO) {
        this.ticketOrderDAO = ticketOrderDAO;
        this.emailService = emailService;
        this.validationCodeDAO = validationCodeDAO;
    }

    public void notifyObserver(String email, Ticket ticket) {
        UUID uuid = UUID.randomUUID();
        String randomUUID = uuid.toString();
        emailService.sendSimpleEmail(email,"Ticket","Bought a/an "+ ticket.getTicketType() +" ticket with a price of "+ ticket.getPrice() +" RON. Ticket Code is: "+ randomUUID);
        validationCodeDAO.insertTable(new ValidationCode(randomUUID,""));
    }

    public void addObserver(Ticket ticket, User user){
        ticketOrderDAO.insert(new TicketOrder(user,ticket));
    }
}
