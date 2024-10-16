//package com.example.finacleservice.config;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationResponse;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain,
//                                        Authentication authentication
//                                        ) throws IOException, ServletException {
//
//        // Get Authorization Code from the OAuth2 Response
//        OAuth2AuthorizationResponse oAuth2Response = (OAuth2AuthorizationResponse) request.getAttribute(OAuth2AuthorizationResponse.class.getName());
//
//        if (oAuth2Response != null) {
//            String authorizationCode = oAuth2Response.getCode();
//            System.out.println("Authorization Code: " + authorizationCode);
//        }
//        this.onAuthenticationSuccess(request,response,authentication);
//
//    }
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        OAuth2AuthorizationResponse oAuth2Response = (OAuth2AuthorizationResponse) request.getAttribute(OAuth2AuthorizationResponse.class.getName());
//
//        if (oAuth2Response != null) {
//            String authorizationCode = oAuth2Response.getCode();
//            System.out.println("Authorization Code: " + authorizationCode);
//        }
//    }
//}
