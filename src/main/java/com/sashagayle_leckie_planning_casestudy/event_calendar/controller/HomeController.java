package com.sashagayle_leckie_planning_casestudy.event_calendar.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;


@Controller
public class HomeController {

    @GetMapping("/home")
    public String homePage(Model model) {
        // Add model attributes for dynamic data if needed
        model.addAttribute("events", getUpcomingEvents()); // List of events
        return "home";  // Returns home.html
    }

    private List<String> getUpcomingEvents() {
        // Mockup of event data, replace with real data from database later
        return List.of("Math Lesson - Jan 20, 2025", "Science Workshop - Jan 22, 2025", "History Webinar - Jan 25, 2025");
    }
}
