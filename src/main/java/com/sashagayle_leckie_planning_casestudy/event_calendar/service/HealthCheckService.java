package com.sashagayle_leckie_planning_casestudy.event_calendar.service;

import com.sashagayle_leckie_planning_casestudy.event_calendar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckService {

    @Autowired
    private UserRepository userRepository;

    public boolean isDatabaseConnected() {
        try {
            // Attempt to count users to verify database connection
            long userCount = userRepository.count();
            return userCount >= 0;
        } catch (Exception e) {
            return false;
        }
    }
}
