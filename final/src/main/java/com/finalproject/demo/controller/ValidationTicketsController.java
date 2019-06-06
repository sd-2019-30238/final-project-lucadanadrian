package com.finalproject.demo.controller;

import com.finalproject.demo.model.ValidationCode;
import com.finalproject.demo.service.ValidationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}

