package com.finalproject.demo.service;

import com.finalproject.demo.dao.TicketDAO;
import com.finalproject.demo.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class TicketService {
    @Autowired
    private TicketDAO ticketDAO;

    public void addTicket(Ticket ticket){
        ticketDAO.insertTicket(ticket);
    }

}
