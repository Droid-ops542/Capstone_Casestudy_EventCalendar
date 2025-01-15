package com.sashagayle_leckie_planning_casestudy.event_calendar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig { // Removed extending WebSecurityConfigurerAdapter

    // Method to configure HTTP security
    @Bean
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/home", "/signup", "/login").permitAll() // Allow certain paths without authentication
                .anyRequest().authenticated() // All other paths require authentication
                .and()
                .formLogin()
                .loginPage("/login") // Specify custom login page
                .permitAll()
                .and()
                .logout()
                .permitAll(); // Allow logout without authentication
    }

    // Bean for password encoding
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
