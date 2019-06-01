package com.finalproject.demo.dao;

import com.finalproject.demo.model.Ticket;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public Ticket selectById(int id){
        return sessionFactory.getCurrentSession().get(Ticket.class, id);
    }

    public List<Ticket> selectAll(){
        return (List<Ticket>) sessionFactory.getCurrentSession().createSQLQuery("Select * from ticket").addEntity(Ticket.class).list();
    }

    public void insertTicket(Ticket ticket){
        sessionFactory.getCurrentSession().save(ticket);
    }

    public void updateTicket(Ticket ticket){
        sessionFactory.getCurrentSession().saveOrUpdate(ticket);
    }

    public void deleteFromTable(int id) {
        sessionFactory.getCurrentSession().createSQLQuery("Delete from user where ticket_id = :id")
                .setParameter("id", id).executeUpdate();
    }

}
