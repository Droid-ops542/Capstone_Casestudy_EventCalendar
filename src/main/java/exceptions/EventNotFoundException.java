package com.sashagayle_leckie_planning_casestudy.event_calendar.exception;

public class EventNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EventNotFoundException(String message) {
        super(message);
    }
}
