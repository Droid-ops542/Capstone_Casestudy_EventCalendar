package com.sashagayle_leckie_planning_casestudy.event_calendar.dto;

import com.sashagayle_leckie_planning_casestudy.event_calendar.entity.User;

public class UserDTO {

    private String firstName;
    private String lastName;
    private String email;

    // Getters and Setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Method to convert DTO to Entity
    public User toEntity() {
        User user = new User();
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setEmail(this.email);
        return user;
    }
}
