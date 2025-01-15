package com.sashagayle_leckie_planning_casestudy.event_calendar.controller;

import com.sashagayle_leckie_planning_casestudy.event_calendar.entity.User;
import com.sashagayle_leckie_planning_casestudy.event_calendar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Handle user registration
    @PostMapping("/sign-up")
    public String registerUser(@RequestParam String fullName, @RequestParam String email,
                               @RequestParam String password, Model model) {
        // Check if the email is already registered
        if (userService.userExists(email)) {
            model.addAttribute("error", "An account with this email already exists.");
            return "sign-up";  // Show the sign-up form with the error message
        }

        // Encrypt the password before saving
        String encodedPassword = passwordEncoder.encode(password);

        // Create a new user and save it
        User newUser = new User(fullName, email, encodedPassword);
        userService.saveUser(newUser);

        // Authenticate the user after registration
        authenticateUser(newUser);

        return "redirect:/dashboard";  // Redirect to the dashboard after successful registration
    }

    // Handle user login
    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password, Model model) {
        // Check if the user exists
        User user = userService.findByEmail(email);
        if (user == null) {
            model.addAttribute("error", "Invalid email or password.");
            return "login";  // Show the login form with an error message
        }

        // Check if the password matches
        if (!passwordEncoder.matches(password, user.getPassword())) {
            model.addAttribute("error", "Invalid email or password.");
            return "login";  // Show the login form with an error message
        }

        // Authenticate the user
        authenticateUser(user);

        return "redirect:/dashboard";  // Redirect to the dashboard after successful login
    }

    // Handle user logout
    @GetMapping("/logout")
    public String logoutUser() {
        SecurityContextHolder.clearContext();
        return "redirect:/login";  // Redirect to the login page after logout
    }

    // Helper method to authenticate the user
    private void authenticateUser(User user) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
