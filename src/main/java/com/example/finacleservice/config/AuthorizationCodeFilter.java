//package com.example.finacleservice.config;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//public class AuthorizationCodeFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//
//        // Check if the request contains an authorization code in the query parameters
//        String code = httpRequest.getParameter("code");
//
//        if (code != null) {
//            // Print or log the authorization code
//            System.out.println("Authorization Code: " + code);
//        }
//
//        // Continue with the filter chain
//        chain.doFilter(request, response);
//    }
//}
