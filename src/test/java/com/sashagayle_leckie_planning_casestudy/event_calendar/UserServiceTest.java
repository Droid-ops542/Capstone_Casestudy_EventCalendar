package com.sashagayle_leckie_planning_casestudy.event_calendar;

import com.sashagayle_leckie_planning_casestudy.event_calendar.entity.User;
import com.sashagayle_leckie_planning_casestudy.event_calendar.repository.UserRepository;
import com.sashagayle_leckie_planning_casestudy.event_calendar.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void testCreateUser() {
        // Prepare a new user
        User user = new User("testUser", "test@example.com", "password123");

        // Save the user using the service
        userService.createUser(user);

        // Retrieve the user from the repository
        User savedUser = userRepository.findByUsername("testUser");

        // Validate the saved user
        assertNotNull(savedUser, "User should be saved successfully.");
        assertEquals("testUser", savedUser.getUsername(), "Username should match.");
        assertEquals("test@example.com", savedUser.getEmail(), "Email should match.");
        assertEquals("password123", savedUser.getPassword(), "Password should match.");
    }
}
