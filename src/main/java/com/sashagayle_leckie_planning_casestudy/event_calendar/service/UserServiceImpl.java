package com.sashagayle_leckie_planning_casestudy.event_calendar.service;

import com.sashagayle_leckie_planning_casestudy.event_calendar.entity.User;
import com.sashagayle_leckie_planning_casestudy.event_calendar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Other existing methods...

    /**
     * Method to create a new user and save it to the database.
     *
     * @param user the user to be created
     * @return the saved user
     */
    public User createUser(User user) {
        // Encrypt the user's password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the user using the repository
        return userRepository.save(user);
    }

    /**
     * Method to validate email format using regular expressions.
     *
     * @param email the email to validate
     * @return true if the email format is valid, false otherwise
     */
    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        // Define a simple regex pattern for email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    /**
     * Method to find a user by username.
     *
     * @param username the username to search for
     * @return the user object if found, or null if not found
     */
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
