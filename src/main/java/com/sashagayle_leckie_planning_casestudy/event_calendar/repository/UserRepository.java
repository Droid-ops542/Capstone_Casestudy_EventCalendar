package com.sashagayle_leckie_planning_casestudy.event_calendar.repository;

import com.sashagayle_leckie_planning_casestudy.event_calendar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by username (returns Optional<User>)
    User findByUsername(String username);

    // Custom query to find user by email (returns Optional<User>)
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String email);

    // Custom query to check if a user exists by email (returns boolean)
    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.email = :email")
    boolean existsByEmail(@Param("email") String email);

    // Custom query to check if a user exists by username (returns boolean)
    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.username = :username")
    boolean existsByUsername(@Param("username") String username);

    // Find user by email ignoring case (returns Optional<User>)
    @Query("SELECT u FROM User u WHERE LOWER(u.email) = LOWER(:email)")
    User findByEmailIgnoreCase(@Param("email") String email);

    // Custom query to find user by username and password (authentication purposes) (returns Optional<User>)
    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
