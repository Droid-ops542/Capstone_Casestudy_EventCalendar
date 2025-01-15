package com.sashagayle_leckie_planning_casestudy.event_calendar.controller;

import com.sashagayle_leckie_planning_casestudy.event_calendar.entity.User;
import com.sashagayle_leckie_planning_casestudy.event_calendar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Display sign-up form
    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());  // Create a new user object for the form
        return "sign-up";  // "sign-up" corresponds to sign-up.html
    }

    // Handle sign-up form submission
    @PostMapping("/signup")
    public String handleSignUp(User user, Model model) {
        // Perform registration logic, such as saving the user
        userService.registerUser(user);
        model.addAttribute("message", "Registration successful! Please log in.");
        return "login";  // Redirecting to login page after successful registration
    }

    // Handle user login
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // "login" corresponds to login.html
    }

    // Display user profile page (after login)
    @GetMapping("/profile")
    public String showProfilePage(Model model) {
        // Fetch user details from the database and add to model
        Optional<User> user = Optional.ofNullable(userService.getUserById(1L));  // Example: fetch user by ID (this would normally be dynamic)
        model.addAttribute("user", user);
        return "profile";  // "profile" corresponds to profile.html
    }
}
