package com.sashagayle_leckie_planning_casestudy.event_calendar;

import com.sashagayle_leckie_planning_casestudy.event_calendar.entity.User;
import com.sashagayle_leckie_planning_casestudy.event_calendar.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User testUser;

    @BeforeEach
    void setUp() {
        // Setup a test user
        testUser = new User();
        testUser.setUsername("testUser");
        testUser.setEmail("testuser@example.com");
        testUser.setPassword("password123");

        // Save the test user in the database
        userRepository.save(testUser);
    }

    @Test
    void testFindByUsername() {
        // Retrieve the user by username
        User foundUser = userRepository.findByUsername("testUser");

        // Validate the result
        assertNotNull(foundUser);
        assertEquals("testUser", foundUser.getUsername());
    }

    @Test
    void testFindByEmail() {
        // Retrieve the user by email
        User foundUser = userRepository.findByEmail("testuser@example.com");

        // Validate the result
        assertNotNull(foundUser);
        assertEquals("testuser@example.com", foundUser.getEmail());
    }

    @Test
    void testExistsByEmail() {
        // Check if the user exists by email
        boolean exists = userRepository.existsByEmail("testuser@example.com");

        // Validate the result
        assertTrue(exists);
    }

    @Test
    void testExistsByUsername() {
        // Check if the user exists by username
        boolean exists = userRepository.existsByUsername("testUser");

        // Validate the result
        assertTrue(exists);
    }

    @Test
    void testFindByEmailIgnoreCase() {
        // Retrieve the user by email, ignoring case
        User foundUser = userRepository.findByEmailIgnoreCase("TESTUSER@EXAMPLE.COM");

        // Validate the result
        assertNotNull(foundUser);
        assertEquals("testuser@example.com", foundUser.getEmail());
    }

    @Test
    void testFindByUsernameAndPassword() {
        // Retrieve the user by username and password
        User foundUser = userRepository.findByUsernameAndPassword("testUser", "password123");

        // Validate the result
        assertNotNull(foundUser);
        assertEquals("testUser", foundUser.getUsername());
        assertEquals("password123", foundUser.getPassword());
    }
}
