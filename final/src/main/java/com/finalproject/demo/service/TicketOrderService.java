package com.finalproject.demo.service;

import com.finalproject.demo.dao.TicketOrderDAO;
import com.finalproject.demo.model.Ticket;
import com.finalproject.demo.model.TicketOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TicketOrderService {
    private TicketOrderDAO ticketOrderDAO;

    @Autowired
    public TicketOrderService(TicketOrderDAO ticketOrderDAO) {
        this.ticketOrderDAO = ticketOrderDAO;
    }

    public List<TicketOrder> getOrdersByEmail(String email){
        return ticketOrderDAO.selectTicketsByUsersEmail(email);
    }

    public void deleteOrder(int id){
        TicketOrder ticketOrder= ticketOrderDAO.selectById(id);
        ticketOrderDAO.delete(ticketOrder);
    }
}
