package com.sashagayle_leckie_planning_casestudy.event_calendar;

import com.sashagayle_leckie_planning_casestudy.event_calendar.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private final UserServiceImpl userService = new UserServiceImpl();  // Directly instantiating the service

    // Parameterized test for email validation
    @ParameterizedTest
    @CsvSource({
            "testuser@example.com, true",
            "invalid-email, false",
            "user@domain, false",
            "user@domain.com, true",
            "@nousername.com, false",
            "user@subdomain.domain.com, true"
    })
    public void testEmailValidation(String email, boolean expectedValid) {
        boolean result = userService.isValidEmail(email);
        assertEquals(expectedValid, result);
    }


}
