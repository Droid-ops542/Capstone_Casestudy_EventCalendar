package com.sashagayle_leckie_planning_casestudy.event_calendar.controller;

import com.sashagayle_leckie_planning_casestudy.event_calendar.entity.Registration;
import com.sashagayle_leckie_planning_casestudy.event_calendar.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    // Endpoint to register user for an event
    @PostMapping("/{userId}/{eventId}")
    public Registration registerUserForEvent(@PathVariable Long userId, @PathVariable Long eventId) {
        return registrationService.registerUserForEvent(userId, eventId);
    }


}
