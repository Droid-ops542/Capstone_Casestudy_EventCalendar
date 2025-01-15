package com.sashagayle_leckie_planning_casestudy.event_calendar.controller;

import com.sashagayle_leckie_planning_casestudy.event_calendar.entity.Event; // Import Event entity class (adjust according to your model)
import com.sashagayle_leckie_planning_casestudy.event_calendar.service.EventService; // Adjust according to your service layer
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final EventService eventService;

    @Autowired
    public HomeController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        List<Event> events = eventService.getAllEvents(); // Assuming you have an EventService that fetches events
        model.addAttribute("events", events);
        return "home"; // Refers to home.html in the templates folder
    }

    @GetMapping("/sign-up")
    public String signUpPage() {
        return "sign-up"; // Refers to sign-up.html
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Refers to login.html
    }

    @GetMapping("/confirmation")
    public String registrationConfirmationPage() {
        return "registration-confirmation"; // Refers to registration-confirmation.html
    }

    @GetMapping("/profile")
    public String profilePage() {
        return "profile"; // Refers to profile.html
    }

    @GetMapping("/lesson-details")
    public String lessonDetailsPage() {
        return "lesson-details"; // Refers to lesson-details.html
    }
}
