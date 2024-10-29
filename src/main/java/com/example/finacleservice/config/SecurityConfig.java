package com.example.finacleservice.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;

@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityConfig {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/").permitAll()  // Allow public access to the home page
                                .anyRequest().authenticated()  // All other requests require authentication
                )
                .oauth2Login(oAuth2Login ->
                        oAuth2Login.successHandler((request, response, authentication) -> {
                            // Log Authorization Code (if you want to capture it here)
                            String authorizationCode = request.getParameter("code");
                            if (authorizationCode != null) {
                                logger.info("Authorization Code: {}", authorizationCode);
                            }

                            // Redirect to profile page after successful login
                            response.sendRedirect("/profile");
                        })
                )
                .formLogin(Customizer.withDefaults());

        return http.build();
    }
}
