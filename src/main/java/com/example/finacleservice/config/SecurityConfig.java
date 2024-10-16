//package com.example.finacleservice.config;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import java.io.IOException;
//
//@Configuration
//@EnableWebSecurity
//@Order(1)
//public class SecurityConfig {
//
//    private final AuthorizationCodeFilter authorizationCodeFilter;
//
//    @Autowired
//    public SecurityConfig(AuthorizationCodeFilter authorizationCodeFilter) {
//        this.authorizationCodeFilter = authorizationCodeFilter;
//    }
//
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http.addFilterBefore(authorizationCodeFilter, UsernamePasswordAuthenticationFilter.class);
//
//        http
//                .authorizeHttpRequests(authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers("/").permitAll()  // Allow public access to the home page
//                                .anyRequest().authenticated()  // All other requests require authentication
//                )
//                .oauth2Login(oAuth2Login -> oAuth2Login.successHandler((request, response, authentication) -> response.sendRedirect("/profile")))
//                .formLogin(Customizer.withDefaults());
//
//        return http.build(); // Return the configured HttpSecurity
//    }
//}