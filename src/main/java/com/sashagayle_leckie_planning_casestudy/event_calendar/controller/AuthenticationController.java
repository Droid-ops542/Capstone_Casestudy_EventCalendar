package com.sashagayle_leckie_planning_casestudy.event_calendar.controller;

import com.sashagayle_leckie_planning_casestudy.event_calendar.entity.User;
import com.sashagayle_leckie_planning_casestudy.event_calendar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {

    @Autowired
    private UserService userService;

    // Display the signup form
    @GetMapping("/signup")
    public String showSignupForm() {
        return "sign-up";
    }

    // Handle the registration
    @PostMapping("/signup")
    public String registerUser(@ModelAttribute User user) {
        userService.registerUser(user);
        return "registration-confirmation";
    }

    // Display the login form
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // Handle logout
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/home";
    }
}
