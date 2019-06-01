package com.finalproject.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Ticket {
    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ticket_type")
    private String ticketType;
    @Column(name="ticket_price")
    private int price;

    @OneToMany(mappedBy = "ticket")
    private List<TicketOrder> ticketOrders = new ArrayList<>();

    public Ticket() {
    }

    public Ticket(String ticketType, int price) {
        this.ticketType = ticketType;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<TicketOrder> getTicketOrders() {
        return ticketOrders;
    }

    public void setTicketOrders(List<TicketOrder> ticketOrders) {
        this.ticketOrders = ticketOrders;
    }
}
