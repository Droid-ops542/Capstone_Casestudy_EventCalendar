package com.sashagayle_leckie_planning_casestudy.event_calendar.controller;

import com.sashagayle_leckie_planning_casestudy.event_calendar.dto.UserDTO;
import com.sashagayle_leckie_planning_casestudy.event_calendar.entity.User;
import com.sashagayle_leckie_planning_casestudy.event_calendar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDTO userDTO) {
        // Convert UserDTO to User entity
        User user = userDTO.toEntity();

        // Save the user entity using the UserService
        userService.save(user);

        return "User successfully registered!";
    }
}
