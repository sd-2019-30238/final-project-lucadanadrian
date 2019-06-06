package com.finalproject.demo.controller;

import com.finalproject.demo.model.BusSchedule;
import com.finalproject.demo.service.BusScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @DeleteMapping("/busScheduleStaff/lines/{id}")
    public ModelAndView delteLines(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("redirect:/busScheduleStaff/lines");
        busScheduleService.deleteSchedule(id);
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

    @GetMapping("/busLines")
    public ModelAndView displayLinesForUsers(){
        ModelAndView modelAndView = new ModelAndView("usersBusLines");
        modelAndView.addObject("schedules", busScheduleService.seeBusSchedules());
        return modelAndView;
    }

    @GetMapping("/busLines/line")
    public ModelAndView displaySelectedLine(@RequestParam(value = "line") String line){
        ModelAndView modelAndView = new ModelAndView("searchedLinePage");
        modelAndView.addObject("lines",busScheduleService.selectBusLine(line));
        return modelAndView;
    }

    @GetMapping("/busLines/type")
    public ModelAndView displayUrbanOrMetropolitan(@RequestParam(value = "type") String type){
        ModelAndView modelAndView = new ModelAndView("searchedTypePage");
        modelAndView.addObject("types",busScheduleService.selectByType(type));
        return modelAndView;
    }

}
