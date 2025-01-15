package com.sashagayle_leckie_planning_casestudy.event_calendar.service;

import com.sashagayle_leckie_planning_casestudy.event_calendar.entity.Registration;
import com.sashagayle_leckie_planning_casestudy.event_calendar.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    // Method to create a new registration
    public Registration createRegistration(Long userId, Long eventId) {
        Optional<Registration> existingRegistration = registrationRepository.findByUserIdAndEventId(userId, eventId);

        // If a registration already exists, return null
        if (existingRegistration.isPresent()) {
            return null;
        } else {
            Registration registration = new Registration();
            registration.setUserId(userId);
            registration.setEventId(eventId);
            return registrationRepository.save(registration);
        }
    }

    // Method to update an existing registration
    public Registration updateRegistration(Long userId, Long eventId) {
        Optional<Registration> existingRegistration = registrationRepository.findByUserIdAndEventId(userId, eventId);

        if (existingRegistration.isPresent()) {
            Registration registration = existingRegistration.get();
            // Update registration details here as necessary
            return registrationRepository.save(registration);
        } else {
            return null;
        }
    }

    // Method to delete a registration
    public void deleteRegistration(Long userId, Long eventId) {
        Optional<Registration> existingRegistration = registrationRepository.findByUserIdAndEventId(userId, eventId);
        existingRegistration.ifPresent(registration -> registrationRepository.delete(registration));
    }

    // Method to get a registration
    public Optional<Registration> getRegistration(Long userId, Long eventId) {
        return registrationRepository.findByUserIdAndEventId(userId, eventId);
    }

    // Register user for event
    public Registration registerUserForEvent(Long userId, Long eventId) {
        return createRegistration(userId, eventId);
    }
}
