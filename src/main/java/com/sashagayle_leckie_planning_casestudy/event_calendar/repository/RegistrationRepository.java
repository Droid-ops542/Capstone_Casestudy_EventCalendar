package com.sashagayle_leckie_planning_casestudy.event_calendar.repository;

import com.sashagayle_leckie_planning_casestudy.event_calendar.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    // Custom query method to find Registration by userId and eventId
    Optional<Registration> findByUserIdAndEventId(Long userId, Long eventId);
}
