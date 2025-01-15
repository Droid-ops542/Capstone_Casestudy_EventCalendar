package com.sashagayle_leckie_planning_casestudy.event_calendar.exceptions;

public class UserAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
