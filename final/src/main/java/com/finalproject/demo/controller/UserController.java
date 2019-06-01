package com.finalproject.demo.controller;

import com.finalproject.demo.model.User;
import com.finalproject.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView showLogIn() {
        ModelAndView modelAndView = new ModelAndView("loginPage");
        return modelAndView;
    }

    @PostMapping("/signUp")
    public ModelAndView addUser(User user) {
        ModelAndView modelAndView = new ModelAndView("signUpPage");
        userService.addUser(user);
        return modelAndView;
    }

    @GetMapping("/signUp")
    public ModelAndView displaySignUpPage() {
        ModelAndView modelAndView = new ModelAndView("signUpPage");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

}

