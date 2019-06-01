package com.finalproject.demo.controller;

import com.finalproject.demo.model.Ticket;
import com.finalproject.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/addTicket")
    public ModelAndView addTicket(Ticket ticket){
        ModelAndView modelAndView = new ModelAndView("insertTicket");
        ticketService.addTicket(ticket);
        return modelAndView;
    }
    @GetMapping("/addTicket")
    public ModelAndView showAddTicket(){
        ModelAndView modelAndView = new ModelAndView("insertTicket");
        modelAndView.addObject("ticket", new Ticket());
        return modelAndView;
    }

}
