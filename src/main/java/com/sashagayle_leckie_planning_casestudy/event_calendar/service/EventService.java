package com.sashagayle_leckie_planning_casestudy.event_calendar.service;

import com.sashagayle_leckie_planning_casestudy.event_calendar.entity.Event;
import com.sashagayle_leckie_planning_casestudy.event_calendar.entity.User;
import com.sashagayle_leckie_planning_casestudy.event_calendar.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // Create a new event
    public Event createEvent(Event event) {
        return eventRepository.save(event);  // This will save the event to the database
    }

    // Get an event by ID
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);  // This returns the event or null if not found
    }

    // Get a list of events by user
    public List<Event> getEventsByUser(User user) {
        return eventRepository.findByUser(user);  // This will return events associated with the user
    }

    // Get all events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();  // This will return a list of all events
    }

    // Update an existing event
    public Event updateEvent(Event event) {
        return eventRepository.save(event);  // This will update the event details in the database
    }

    // Delete an event by ID
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);  // This will delete the event by its ID
    }
}
