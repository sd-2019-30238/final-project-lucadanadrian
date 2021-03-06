package com.finalproject.demo.service;

import com.finalproject.demo.dao.TicketDAO;
import com.finalproject.demo.dao.TicketOrderDAO;
import com.finalproject.demo.model.Ticket;
import com.finalproject.demo.model.TicketOrder;
import com.finalproject.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class TicketService {
    private TicketDAO ticketDAO;
    private TicketOrderDAO ticketOrderDAO;
    private UserService userService;
    private ObserverService observerService;

    @Autowired
    public TicketService(TicketDAO ticketDAO, TicketOrderDAO ticketOrderDAO, UserService userService, ObserverService observerService) {
        this.ticketDAO = ticketDAO;
        this.ticketOrderDAO = ticketOrderDAO;
        this.userService = userService;
        this.observerService = observerService;
    }

    public void addTicket(Ticket ticket) {
        ticketDAO.insertTicket(ticket);
    }

    public List<Ticket> displayTickets() {
        return ticketDAO.selectAll();
    }

    public void orderTicket(int id, String email) {
        Date date = new Date();
        Ticket ticket = ticketDAO.selectById(id);
        User user = userService.selectUserByEmail(email);
        ticketOrderDAO.insert(new TicketOrder(user, ticket,date.toString()));
        observerService.notifyObserver(email, ticket);
    }
}
