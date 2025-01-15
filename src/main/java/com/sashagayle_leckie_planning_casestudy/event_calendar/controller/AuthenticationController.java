package com.sashagayle_leckie_planning_casestudy.event_calendar.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.security.authentication.BadCredentialsException;

@Controller
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private SimpleUrlAuthenticationFailureHandler authenticationFailureHandler;

    // Handle GET request for login
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Return login view
    }

    // Handle POST request for login
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        try {
            // Attempt to authenticate the user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );

            // If authentication is successful, set it in the security context
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Redirect to the home page or dashboard after successful login
            return "redirect:/home";
        } catch (BadCredentialsException e) {
            // In case of incorrect credentials, show error message
            model.addAttribute("error", "Invalid email or password. Please try again.");
            return "login"; // Return the login page with the error message
        }
    }

    // Handle GET request for logging out (this is a default Spring Security logout handler)
    @GetMapping("/logout")
    public String logout() {
        SecurityContextHolder.clearContext(); // Clear the authentication context
        return "redirect:/home"; // Redirect to the home page after logout
    }
}
