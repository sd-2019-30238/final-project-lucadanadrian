package com.finalproject.demo.controller;

import com.finalproject.demo.model.ValidationCode;
import com.finalproject.demo.service.ValidationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ValidationTicketsController {
    @Autowired
    private ValidationCodeService validationCodeService;

    @GetMapping("/ticketsToCheck")
    public ModelAndView showTicketsCodes(){
        ModelAndView modelAndView = new ModelAndView("codeTicketsPage");
        modelAndView.addObject("codes",validationCodeService.getSavedTickets());
        return modelAndView;
    }

    @PostMapping("/ticketsToCheck/{id}")
    public ModelAndView checkTicket(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("redirect:/ticketsToCheck");
        validationCodeService.acceptTicketCode(id);
        return modelAndView;
    }

    @DeleteMapping("/ticketsToCheck/{id}")
    public ModelAndView deleteTicketCode(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("redirect:/ticketsToCheck");
        validationCodeService.deleteTicketCode(id);
        return modelAndView;
    }

    @GetMapping("/ticketsToCheck/oneTicket")
    public ModelAndView selectTicket(@RequestParam(value = "ticketCode") String code){
        ModelAndView modelAndView = new ModelAndView("seeOneTicketCodePage");
        modelAndView.addObject("ticketsByCode",validationCodeService.selectByCode(code));
        return modelAndView;
    }

}

