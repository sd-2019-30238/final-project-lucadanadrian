package com.finalproject.demo.dao;

import com.finalproject.demo.model.Ticket;
import com.finalproject.demo.model.TicketOrder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketOrderDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public TicketOrderDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public TicketOrder selectById(int id) {
        return sessionFactory.getCurrentSession().get(TicketOrder.class, id);
    }

    public List<TicketOrder> selectAll(){
        return sessionFactory.getCurrentSession().createQuery("from " + TicketOrder.class.getName()).list();
    }

    public List<TicketOrder> selectTicketsByUsersEmail(String email) {
        return sessionFactory.getCurrentSession().createQuery("from " + TicketOrder.class.getName() + " b where b.user.email =:email").setParameter("email", email).list();
    }

    public void insert(TicketOrder ticketOrder){
        sessionFactory.getCurrentSession().saveOrUpdate(ticketOrder);
    }

    public void delete(TicketOrder ticketOrder){
        sessionFactory.getCurrentSession().delete(ticketOrder);
    }
}
