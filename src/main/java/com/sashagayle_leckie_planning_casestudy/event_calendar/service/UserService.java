package com.sashagayle_leckie_planning_casestudy.event_calendar.service;

import com.sashagayle_leckie_planning_casestudy.event_calendar.entity.User;
import com.sashagayle_leckie_planning_casestudy.event_calendar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public abstract class UserService {
    // Method to save a user
    public void save(User user) {

    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Method to save a new user (e.g., during sign-up)
    public User saveUser(User user) {
        return null;
    }

    // Method to fetch a user by email
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Method to check if a user already exists by email (e.g., during sign-up)
    public boolean userExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public User findByEmail(String email) {
        return null;
    }
}
