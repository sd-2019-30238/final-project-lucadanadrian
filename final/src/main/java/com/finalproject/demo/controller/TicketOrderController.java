package com.finalproject.demo.controller;

import com.finalproject.demo.service.TicketOrderService;
import com.finalproject.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TicketOrderController {
    private TicketOrderService ticketOrderService;
    private TicketService ticketService;

    @Autowired
    public TicketOrderController(TicketOrderService ticketOrderService, TicketService ticketService) {
        this.ticketOrderService = ticketOrderService;
        this.ticketService = ticketService;
    }

    @GetMapping("/ticketOrders/currentUser")
    public ModelAndView getTicketOrders(Authentication authentication){
        ModelAndView modelAndView = new ModelAndView("ticketOrdersPage");
        modelAndView.addObject("orderedTickets", ticketOrderService.getOrdersByEmail(authentication.getName()));
        return modelAndView;
    }

    @DeleteMapping("/ticketOrders/currentUser/{id}")
    public ModelAndView deleteTicketOrder(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("redirect:/ticketOrders/currentUser");
        ticketOrderService.deleteOrder(id);
        return modelAndView;
    }


    @PostMapping("tickets/{id}")
    public ModelAndView orderTicket(@PathVariable("id") int id, Authentication authentication){
        ModelAndView modelAndView = new ModelAndView("redirect:/tickets");
        ticketService.orderTicket(id, authentication.getName());
        return modelAndView;
    }

}
