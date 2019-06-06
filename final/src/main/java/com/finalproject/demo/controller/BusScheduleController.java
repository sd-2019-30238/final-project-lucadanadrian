package com.finalproject.demo.controller;

import com.finalproject.demo.model.BusSchedule;
import com.finalproject.demo.service.BusScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BusScheduleController {
    @Autowired
    private BusScheduleService busScheduleService;

    @GetMapping("/busScheduleStaff/lines")
    public ModelAndView getSchedules(){
        ModelAndView modelAndView= new ModelAndView("staffBusPage");
        modelAndView.addObject("busSchedules",busScheduleService.seeBusSchedules());
        return modelAndView;
    }

    @PostMapping("/busScheduleStaff")
    public ModelAndView addSchedule(BusSchedule busSchedule){
        ModelAndView modelAndView = new ModelAndView("redirect:/busScheduleStaff");
        busScheduleService.addSchedule(busSchedule);
        return modelAndView;
    }

    @GetMapping("/busScheduleStaff")
    public ModelAndView displayInsertedSchedule(){
        ModelAndView modelAndView = new ModelAndView("addBusLinesPage");
        modelAndView.addObject("schedule", new BusSchedule());
        return modelAndView;
    }
}
