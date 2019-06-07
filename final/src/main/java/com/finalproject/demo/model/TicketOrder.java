package com.finalproject.demo.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Table
@Entity
public class TicketOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private User user;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Ticket ticket;

    @Column(name="order_time")
    private String date;

    public TicketOrder() {
    }

    public TicketOrder(User user, Ticket ticket, String date) {
        this.user = user;
        this.ticket = ticket;
        this.date=date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketOrder that = (TicketOrder) o;
        return id == that.id &&
                Objects.equals(user, that.user) &&
                Objects.equals(ticket, that.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, ticket);
    }
}
